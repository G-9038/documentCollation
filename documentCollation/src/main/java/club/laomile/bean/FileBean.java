package club.laomile.bean;

public class FileBean {
    private Integer file_id;
    private String file_name;
    private String file_path;
    private String file_remarks;
    private Integer file_user_id;

    public Integer getFile_user_id() {
        return file_user_id;
    }

    public void setFile_user_id(Integer file_user_id) {
        this.file_user_id = file_user_id;
    }

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_remarks() {
        return file_remarks;
    }

    public void setFile_remarks(String file_remarks) {
        this.file_remarks = file_remarks;
    }

    public FileBean() {

    }

    public FileBean(String file_name, String file_path, String file_remarks) {
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_remarks = file_remarks;
    }

    public FileBean(Integer file_id, String file_name, String file_path, String file_remarks) {
        this.file_id = file_id;
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_remarks = file_remarks;
    }

    public FileBean(String file_name, String file_path, String file_remarks, Integer file_user_id) {
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_remarks = file_remarks;
        this.file_user_id = file_user_id;
    }
}
