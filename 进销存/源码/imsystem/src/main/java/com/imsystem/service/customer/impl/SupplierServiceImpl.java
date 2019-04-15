package com.imsystem.service.customer.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Supplier;
import com.imsystem.mapper.SupplierMapper;
import com.imsystem.service.customer.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	SupplierMapper sDao;

	/**
	 *  查询所有供应商
	 */
	@Override
	public List<Supplier> querySupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增供应商
	 */
	@Override
	public int insertSupplier(Supplier supObj) {
		// TODO Auto-generated method stub
		String rand=UUID.randomUUID().toString();
		Date time=new Date();
		String address=supObj.getAddres();
		String[] addr=address.split("/");
		supObj.setId(rand);
		supObj.setTime(time);
		supObj.setUpdatetime(time);
		supObj.setProvince(addr[0]);
		supObj.setCity(addr[1]);
		supObj.setDistrict(addr[2]);
		supObj.setAddres(addr[3]);
		supObj.setState(0);
		int row=sDao.insert(supObj);
		return row;
	}

	/**
	 * 删除供应商 
	 */
	@Override
	public int deleteSupplier(String supId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改供应商
	 */
	@Override
	public int updatSupplier(Supplier supObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据ID查询供应商 
	 */
	@Override
	public Supplier querySupplierById(String supId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Supplier> querySupplierList(Double zero, String content, Integer curentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		Page<Supplier> page=PageHelper.startPage(curentPage,pageSize,true);
		sDao.selectByExample(null);
		PageInfo<Supplier> pages=page.toPageInfo();
		return pages;
	}

}
