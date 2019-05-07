package com.imsystem.service.statistics;

import java.util.List;


import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.GoodsvaluelableExample;

public interface GoodsValueLableService {
    int deleteByPrimaryKey(String id);

    int insert(Goodsvaluelable record);
    
    List<Goodsvaluelable> selectByExample(GoodsvaluelableExample example);

    Goodsvaluelable selectByPrimaryKey(String id);
    
    int updateByPrimaryKey(Goodsvaluelable record);
    
    List<Goodsvaluelable> querySalesGoodsValueByLable(String cid,String season);
    
    List<Goodsvaluelable> queryByLid(String lid,String season);
}
