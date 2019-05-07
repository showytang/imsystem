package com.imsystem.mapper;

import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.GoodsvaluelableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvaluelableMapper {
    int countByExample(GoodsvaluelableExample example);

    int deleteByExample(GoodsvaluelableExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsvaluelable record);

    int insertSelective(Goodsvaluelable record);

    List<Goodsvaluelable> selectByExample(GoodsvaluelableExample example);

    Goodsvaluelable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsvaluelable record, @Param("example") GoodsvaluelableExample example);

    int updateByExample(@Param("record") Goodsvaluelable record, @Param("example") GoodsvaluelableExample example);

    int updateByPrimaryKeySelective(Goodsvaluelable record);

    int updateByPrimaryKey(Goodsvaluelable record);
    
    List<Goodsvaluelable> querySalesGoodsValueByLable(@Param("cid") String cid,@Param("season") String season);
    
    List<Goodsvaluelable> queryByLid(@Param("lid") String lid,@Param("season") String season);
}