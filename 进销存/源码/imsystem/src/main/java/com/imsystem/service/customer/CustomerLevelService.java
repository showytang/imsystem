package com.imsystem.service.customer;

import java.util.List;

import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.QueryCustomerLevelVO;

public interface CustomerLevelService {
	
	/**
	 * 查询所有客户等级
	 * @return
	 */
	public List<Customerlevel> queryCustomerLevel();
	
	/**
	 * 新增客户等级
	 * @param clObj  客户等级对象
	 * @return
	 */
	public int insertCustomerLevel(Customerlevel clObj);
	
	/**
	 * 删除客户等级（修改状态）
	 * @param clId  客户等级id
	 * @return
	 */
	public int deleteCustomerLevel(String clId);
	
	/**
	 * 修改客户等级
	 * @param clObj  客户等级对象
	 * @return
	 */
	public int updateCustomerLevel(Customerlevel clObj);
	
	/**
	 * 根据ID查询客户等级
	 * @param clId  客户等级id
	 * @return
	 */
	public Customerlevel queryCustomerLevelById(String clId);
	
	/**
	 * 查询所有未删除的客户等级
	 * @return
	 */
	public List<QueryCustomerLevelVO> queryAllCustomerLevel();
	
	/**
	 * 根据条件查询未删除的客户等级
	 * @return
	 */
	public List<QueryCustomerLevelVO> queryLikeCustomerLevel(String content);

}
