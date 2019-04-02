package com.imsystem.service.customertype;

import java.util.List;

import com.imsystem.domain.Customertype;

public interface CustomerTypeService {
	

	/**
	 * 查询所有客户类型
	 * @return
	 */
	public List<Customertype> queryCustomerType();
	
	/**
	 * 新增客户类型
	 * @param ctObj  新增客户类型对象
	 * @return
	 */
	public int insertCustomerType(Customertype ctObj);
	
	/**
	 * 删除客户类型（修改状态）
	 * @param ctId  客户类型id
	 * @return
	 */
	public int deleteCustomerType(int ctId);
	
	/**
	 * 修改客户类型
	 * @param ctObj  修改客户类型对象
	 * @return
	 */
	public int updateCustomerType(Customertype ctObj);
	
	/**
	 * 根据ID查询客户类型
	 * @param ctId  客户类型id
	 * @return
	 */
	public Customertype queryCustomerTypeById(int ctId);

}
