package com.imsystem.service.customer;

import java.util.List;

import com.imsystem.domain.Supplier;

public interface SupplierService {
	
	/**
	 * 查询所有供应商
	 * @return
	 */
	public List<Supplier> querySupplier();
	
	/**
	 * 新增供应商
	 * @param supObj  供应商对象
	 * @return
	 */
	public int insertSupplier(Supplier supObj);
	
	/**
	 * 删除供应商  
	 * @param supId  供应商id
	 * @return
	 */
	public int deleteSupplier(String supId);
	
	/**
	 * 修改供应商
	 * @param supObj  修改供应商对象
	 * @return
	 */
	public int updatSupplier(Supplier supObj);
	
	/**
	 * 根据ID查询供应商 
	 * @param supId  供应商id
	 * @return
	 */
	public Supplier querySupplierById(String supId);

}
