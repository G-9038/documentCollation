package club.laomile.service;

import club.laomile.bean.UserBean;
import club.laomile.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDao ud;
	
	public UserBean findUser(UserBean ub)throws Exception{
		UserBean userBean = ud.findByUsername(ub.getUser_name());
		if(!ub.getUser_password().equals(userBean.getUser_password())){
			throw new Exception("密码不正确");
		}
		return userBean;
	}
}
