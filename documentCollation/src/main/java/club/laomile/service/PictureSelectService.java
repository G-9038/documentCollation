package club.laomile.service;

import club.laomile.bean.PictureBean;
import club.laomile.dao.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureSelectService {
    @Autowired
    PictureDao pd;

    public PictureBean fileInsert(Integer picture_id){
        PictureBean pb = pd.findByPictureId(picture_id);
        return pb;
    }
}
