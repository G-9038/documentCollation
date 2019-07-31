package club.laomile.service;

import club.laomile.bean.UserBean;
import club.laomile.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInsertService {
    @Autowired
    UserDao ud;

    public String userinsert(UserBean ub,String userPasswordDouble){
        if("".equals(ub.getUser_name())){
            return "请输入用户名";
        }else if("".equals(ub.getUser_password())){
            return "请输入密码";
        }else if("".equals(userPasswordDouble)){
            return "请再次输入密码";
        }else if(!userPasswordDouble.equals(ub.getUser_password())){
            return "两次输入的密码不一致";
        }else{
            try{
                ud.insertIntoUser(ub);
                return "注册成功，请登录";
            }catch (Exception e){
                return "系统未知错误";
            }

        }
    }
}
