package club.laomile.controller;

import club.laomile.bean.FileBean;
import club.laomile.bean.QuestionBean;
import club.laomile.bean.UserBean;
import club.laomile.service.FileInsertService;
import club.laomile.service.QuestionInsertService;
import club.laomile.utils.ExcelUtils;
import club.laomile.utils.SaveExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;




@Controller
public class FileController {

    @Autowired
    FileInsertService fis;

    @Autowired
    QuestionInsertService qis;

    @RequestMapping(value="/file/upload",method = RequestMethod.POST)
    public ModelAndView fileUpload(HttpSession session, @RequestParam("file") MultipartFile file, @RequestParam("value") String value){
        //把文件保存在web目录的upload下
        Boolean bool = SaveExcel.saveExcel(session,file,"/upload");
        String realPath = SaveExcel.real;
        String fileName = SaveExcel.fileN;

        ModelAndView mav = new ModelAndView();
        if(bool){
            //将文件信息存入数据库
            UserBean user = (UserBean) session.getAttribute("user");
            Integer file_user_id = user.getUser_id();
            FileBean fb = new FileBean(file.getOriginalFilename(),realPath+"/"+fileName,value,file_user_id);
            Integer success = fis.fileInsert(fb);
            Integer question_file_id = fb.getFile_id();
            //将文件信息解析存入数据库
            InputStream in =null;
            try {
                in = file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //获取解析后的list
            List<List<Object>> listob = null;
            try {
                listob = new ExcelUtils().getBankListByExcel(in,file.getOriginalFilename());
                for(int i=0;i<listob.size();i++){
                    String question = (String)listob.get(i).get(0);
                    String answer = (String)listob.get(i).get(1);
                    QuestionBean qb = new QuestionBean(question_file_id,question,answer);
                    qis.questionInsert(qb);
                }
                mav.addObject("message","上传成功");
                mav.setViewName("select");
            } catch (Exception e) {
                mav.addObject("message","请上传Excel文件");
                mav.setViewName("fileUpload");
                e.printStackTrace();
            }
        }
        return mav;
    }
}



