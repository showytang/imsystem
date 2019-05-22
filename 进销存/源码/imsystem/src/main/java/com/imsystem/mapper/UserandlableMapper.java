package com.imsystem.mapper;

import com.imsystem.domain.Customer;
import com.imsystem.domain.UserLableVO;
import com.imsystem.domain.Userandlable;
import com.imsystem.domain.UserandlableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

public interface UserandlableMapper {
	
	/**
	 *  根据客户id查询
	 * @Description:TODO 王军辉
	 * @param cid
	 * @return 
	 */
	List<Userandlable> queryByCid(String cid);
	
	List<Customer> queryCustomer(String sid);
	
	List<UserLableVO> queryCustomerLabel(@Param("cid") String cid, @Param("name") String name);
	
    int addUserLabel(Userandlable ual);
	
	int countByExample(UserandlableExample example);

    int deleteByExample(UserandlableExample example);

    int deleteByPrimaryKey(String id);

    int insert(Userandlable record);

    int insertSelective(Userandlable record);

    List<Userandlable> selectByExample(UserandlableExample example);

    Userandlable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Userandlable record, @Param("example") UserandlableExample example);

    int updateByExample(@Param("record") Userandlable record, @Param("example") UserandlableExample example);

    int updateByPrimaryKeySelective(Userandlable record);

    int updateByPrimaryKey(Userandlable record);
}