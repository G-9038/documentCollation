package club.laomile.bean;

public class PictureBean {
    private Integer picture_id;
    private String picture_name;
    private String picture_path;
    private Integer picture_user_id;

    public Integer getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public Integer getPicture_user_id() {
        return picture_user_id;
    }

    public void setPicture_user_id(Integer picture_user_id) {
        this.picture_user_id = picture_user_id;
    }

    public PictureBean(String picture_name, String picture_path, Integer picture_user_id) {
        this.picture_name = picture_name;
        this.picture_path = picture_path;
        this.picture_user_id = picture_user_id;
    }

    public PictureBean() {

    }
}
