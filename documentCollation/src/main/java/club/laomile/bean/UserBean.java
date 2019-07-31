package club.laomile.bean;

public class UserBean {
    private Integer User_id;
    private String User_name;
    private String User_password;

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }

    public UserBean() {
    }

    public UserBean(Integer user_id, String user_name, String user_password) {
        User_id = user_id;
        User_name = user_name;
        User_password = user_password;
    }

    public UserBean(String user_name, String user_password) {
        User_name = user_name;
        User_password = user_password;
    }
}
