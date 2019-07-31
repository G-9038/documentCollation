package club.laomile.service;

import club.laomile.bean.FileBean;
import club.laomile.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileInsertService {
    @Autowired
    FileDao fd;

    public Integer fileInsert(FileBean fb){
        Integer success = fd.insertIntoFile(fb);
        return success ;
    }
}
