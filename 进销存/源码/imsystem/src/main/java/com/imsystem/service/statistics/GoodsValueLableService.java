package com.imsystem.service.statistics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.GoodsvaluelableExample;

public interface GoodsValueLableService {
    int deleteByPrimaryKey(String id);

    int insert(Goodsvaluelable record);
    
    List<Goodsvaluelable> selectByExample(GoodsvaluelableExample example);

    Goodsvaluelable selectByPrimaryKey(String id);
    
    int updateByPrimaryKey(Goodsvaluelable record);
    
    List<Goodsvaluelable> querySalesGoodsValueByLable(String cid,String season);
    /***
     * 更具客户id查询买过的商品标签的最多的商品
     * @param lid
     * @param season
     * @return
     */
    List<Goodsvaluelable> queryByLid(String lid,String season);

    /***
     * 根据用户买过的商品id查询其他买过此商品的用户买过最多的商品
     * @param gvid
     * @return
     */
    List<Goodsvaluelable> queryTaLikeBygvid(@Param("gvid") String gvid);
    /***
     * 更具用户标签查询该标签用户所购买的数量最多的商品
     * @param ulid
     * @return
     */
    List<Goodsvaluelable> queryGoodsByUl(@Param("ulid") String ulid);
    /***
     * 查询客户标签
     * @param cid
     * @return
     */
    List<Goodsvaluelable> queryUlidByCid(@Param("cid") String cid);
    /***
     * 根据gvid查询商品
     * @param gvid
     * @return
     */
    Goodsvaluelable queryGoodsBygvid(@Param("gvid") String gvid);
}
