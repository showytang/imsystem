package com.imsystem.service.customer;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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

	
	/**
	 * 根据条件分页查询供应商
	 * @param zero 是否查询0欠款
	 * @param content  是否包含条件
	 * @param curentPage 当前页码
	 * @param pageSize  当前页数据条数
	 * @return
	 */
	public PageInfo<Supplier> querySupplierList(Double zero,String content,Integer curentPage,String uid);

	
	public List<Supplier> queryRecentDealSupplier(String storeid);

	/**
	 * 查询最经交易的供应商
	 * @Description:TODO 王军辉
	 * @param storeid 门店id
	 * @return
	 */
	public List<Supplier> queryDealOrderSupplier(String storeid);
	
	/**
	 * 根据name模糊查
	 * @Description:TODO 王军辉
	 * @param name 名称
	 * @return
	 */
	public List<Supplier> queryByName(String name);
	


}
