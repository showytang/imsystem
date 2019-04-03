package com.imsystem.service.supplier.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Supplier;
import com.imsystem.service.supplier.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

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
		return 0;
	}

	/**
	 * 删除供应商 
	 */
	@Override
	public int deleteSupplier(int supId) {
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
	public Supplier querySupplierById(int supId) {
		// TODO Auto-generated method stub
		return null;
	}

}
