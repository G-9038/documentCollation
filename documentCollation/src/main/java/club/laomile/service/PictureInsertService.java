package club.laomile.service;

import club.laomile.bean.PictureBean;
import club.laomile.dao.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureInsertService {
    @Autowired
    PictureDao pd;

    public Integer fileInsert(PictureBean pb){
        Integer success = pd.insertIntoPicture(pb);
        return success ;
    }
}
