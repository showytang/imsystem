package com.imsystem.mapper;

import com.imsystem.domain.Goods;
import com.imsystem.domain.QuoteVO;
import com.imsystem.domain.Quotedprice;
import com.imsystem.domain.QuotedpriceExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuotedpriceMapper {
	List<Quotedprice> queryQuoteByPage(@Param("cname") String cname,@Param("gname") String gname);
	
	Goods selectGoodsById(@Param("id") String id);
	
	List<Quotedprice> queryQuoteByCustomerId(@Param("cid") String cid);
	
	List<Quotedprice> queryQuoteByGoodsValueId(@Param("gid") String gid);
	
	int updatePrice(@Param("qid") String qid,@Param("price") Double price);
	
	int deleteQuote(@Param("qid") String qid);
	
	List<QuoteVO> queryQuoteCustomer(@Param("name") String name,@Param("gid") String gid);
	
	int addUpdateQuote(@Param("price") Double price,@Param("time") Date time,@Param("uid") String uid,@Param("qid") String qid);
	
	List<QuoteVO> queryQuoteGoods(@Param("name") String name,@Param("cid") String cid);
	
    int countByExample(QuotedpriceExample example);

    int deleteByExample(QuotedpriceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Quotedprice record);

    int insertSelective(Quotedprice record);

    List<Quotedprice> selectByExample(QuotedpriceExample example);

    Quotedprice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Quotedprice record, @Param("example") QuotedpriceExample example);

    int updateByExample(@Param("record") Quotedprice record, @Param("example") QuotedpriceExample example);

    int updateByPrimaryKeySelective(Quotedprice record);

    int updateByPrimaryKey(Quotedprice record);
}