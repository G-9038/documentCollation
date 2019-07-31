package club.laomile.controller;

import club.laomile.bean.MarkBean;
import club.laomile.bean.PictureBean;
import club.laomile.bean.UserBean;
import club.laomile.service.*;
import club.laomile.utils.SaveExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;

@Controller
public class PngContoller {

    @Autowired
    PictureInsertService pis;

    @Autowired
    MarkInsertService mis;

    @Autowired
    MarkSelectService mss;

    @Autowired
    MarkSelectDistinctService msds;

    @Autowired
    PictureSelectService pss;

    @RequestMapping(value = "/png/upload",method = RequestMethod.POST)
    public ModelAndView pngUpload(HttpSession session, @RequestParam("pngFile") MultipartFile file, HttpServletRequest request){
        //将文件存入web目录的png下
        SaveExcel.saveExcel(session,file,"png");
        String realPath = SaveExcel.real;
        String fileName = SaveExcel.fileN;
        //将图片信息存入数据库
        UserBean ub = (UserBean) session.getAttribute("user");
        Integer picture_user_id = ub.getUser_id();
        PictureBean pb = new PictureBean(file.getOriginalFilename(),fileName,picture_user_id);
        pis.fileInsert(pb);
        //拿到标签信息，并存入数据库
        String[] marks = request.getParameterValues("marks");
        Integer picture_id = pb.getPicture_id();
        for(int i=0;i<marks.length;i++){
            MarkBean markBean = new MarkBean(marks[i],picture_id);
            mis.fileInsert(markBean);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fileUpload");
        return mav;
    }

    @RequestMapping(value = "/mark/select",method = RequestMethod.POST)
    public ModelAndView markSelectDistinct(HttpSession session,@RequestParam("hiddean") String hidden){
        List<MarkBean> list = msds.fileInsert();
        String marksList = "";
        for(int i=0;i<list.size();i++){
            marksList+=list.get(i).getMark_name()+",";
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("marksList",marksList);
        if("fileUpload".equals(hidden)){
            mav.setViewName("fileUpload");
        }else{
            mav.setViewName("select");
        }
        return mav;
    }

    @RequestMapping(value = "/png/select",method = RequestMethod.POST)
    public ModelAndView pngSelect(HttpServletRequest request){
        String[] marks = request.getParameterValues("marks");

        ModelAndView mav = new ModelAndView();
        String pngs = "";
        HashSet<String> set = new HashSet<String>();
        if(marks!=null){
            for(int i=0;i<marks.length;i++){
                //System.out.println(marks[i]);
                List<MarkBean> list = mss.fileInsert(marks[i]);
                for(MarkBean mb : list){
                    //System.out.println(mb.getMark_picture_id());
                    PictureBean pb = pss.fileInsert(mb.getMark_picture_id());
                    System.out.println(pb.getPicture_name());
                    set.add(pb.getPicture_path());
                }
            }
        }
        for(String str : set){
            pngs += str+",";
        }
        mav.addObject("pngs",pngs);
        mav.setViewName("pngSelect");
        return mav;
    }
}
