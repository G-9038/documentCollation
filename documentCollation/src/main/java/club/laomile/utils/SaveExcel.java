package club.laomile.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class SaveExcel {
    public static  String real=null;
    public static  String fileN=null;
    public static boolean  saveExcel(HttpSession session, MultipartFile file,String path){
        //标识是否上传成功
        boolean bool = false;
        //获取要上传的目标文件夹绝对路径、webapp下
        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath(path);
        real=realPath;

        //重新定义文件名、避免名称重复
        String fileName = UUID.randomUUID().toString().replace("-", "").substring(0, 15) + "_file_" + file.getOriginalFilename();
        try {
            //上传文件至指定位置
            File newFile = new File(realPath + "/" + fileName);
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            file.transferTo(new File(realPath + "/" + fileName));
            bool=true;
            fileN=fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return bool;
        }
    }
}
