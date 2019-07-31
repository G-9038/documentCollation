package club.laomile.dao;

import club.laomile.bean.UserBean;

public interface UserDao {
    public abstract UserBean findByUsername(String user_name);
    public abstract Integer insertIntoUser(UserBean UB);
}
