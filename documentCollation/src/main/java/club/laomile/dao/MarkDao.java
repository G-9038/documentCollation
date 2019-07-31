package club.laomile.dao;

import club.laomile.bean.MarkBean;

import java.util.List;

public interface MarkDao {
    public abstract Integer insertIntoMark(MarkBean mb);
    public abstract List<MarkBean> findByMarkName(String mark_name);
    public abstract List<MarkBean> distinctMarkName();
}
