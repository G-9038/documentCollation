package club.laomile.service;

import club.laomile.bean.MarkBean;
import club.laomile.dao.MarkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkSelectService {
    @Autowired
    MarkDao md;

    public List<MarkBean> fileInsert(String mark_name){
        List<MarkBean> list = md.findByMarkName(mark_name);
        return list;
    }
}
