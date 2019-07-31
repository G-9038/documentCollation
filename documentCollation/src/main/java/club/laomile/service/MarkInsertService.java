package club.laomile.service;

import club.laomile.bean.MarkBean;
import club.laomile.dao.MarkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkInsertService {
    @Autowired
    MarkDao md;

    public Integer fileInsert(MarkBean mb){
        Integer success = md.insertIntoMark(mb);
        return success ;
    }
}
