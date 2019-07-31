package club.laomile.bean;

import java.util.Objects;

public class MarkBean {
    private Integer mark_id;
    private String mark_name;
    private Integer mark_picture_id;

    public Integer getMark_id() {
        return mark_id;
    }

    public void setMark_id(Integer mark_id) {
        this.mark_id = mark_id;
    }

    public String getMark_name() {
        return mark_name;
    }

    public void setMark_name(String mark_name) {
        this.mark_name = mark_name;
    }

    public Integer getMark_picture_id() {
        return mark_picture_id;
    }

    public void setMark_picture_id(Integer mark_picture_id) {
        this.mark_picture_id = mark_picture_id;
    }

    public MarkBean(String mark_name, Integer mark_picture_id) {
        this.mark_name = mark_name;
        this.mark_picture_id = mark_picture_id;
    }

    public MarkBean() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkBean markBean = (MarkBean) o;
        return Objects.equals(mark_id, markBean.mark_id) &&
                Objects.equals(mark_name, markBean.mark_name) &&
                Objects.equals(mark_picture_id, markBean.mark_picture_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark_id, mark_name, mark_picture_id);
    }

    @Override
    public String toString() {
        return "MarkBean{" +
                "mark_id=" + mark_id +
                ", mark_name='" + mark_name + '\'' +
                ", mark_picture_id=" + mark_picture_id +
                '}';
    }
}
