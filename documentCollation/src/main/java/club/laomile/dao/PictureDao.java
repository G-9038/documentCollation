package club.laomile.dao;

import club.laomile.bean.PictureBean;

public interface PictureDao {
    public abstract Integer insertIntoPicture(PictureBean pb);
    public abstract PictureBean findByPictureId(Integer picture_id);
}
