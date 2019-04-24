package com.imsystem.mapper;

import com.imsystem.domain.Goodstype;
import com.imsystem.domain.GoodstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeMapper {
	
	Goodstype queryGoodsTypeReverse(String id);
	
	/**
	 * 商品类型查询
	 * @param id 上级id
	 * @return
	 */
	List<Goodstype> QueryGoodsTypeByPid(String id);
	
    int countByExample(GoodstypeExample example);

    int deleteByExample(GoodstypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);
    
    List<Goodstype> queryall();
    
    List<Goodstype> querygoodstype(@Param("tiaojian")String tiaojian);
    

    List<Goodstype> selectByExample(GoodstypeExample example);

    Goodstype selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
    
    int deleteupdate(Integer id);
    
    int insertgoodstype(Goodstype good);
    
    Goodstype querybyid(Integer id);
    
    int toupdate(Goodstype good);
    
    List<Goodstype> querybypid();
}