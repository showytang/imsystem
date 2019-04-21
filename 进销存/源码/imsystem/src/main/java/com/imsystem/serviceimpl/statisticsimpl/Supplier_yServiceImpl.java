package com.imsystem.serviceimpl.statisticsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Supplier;
import com.imsystem.mapper.SupplierMapper;
import com.imsystem.service.statistics.Supplier_yService;

@Service
@Transactional
public class Supplier_yServiceImpl implements Supplier_yService{

	@Autowired
	SupplierMapper sm;
	
	@Override
	public List<Supplier> querySupplier_yByStore(String sid) {
		// TODO Auto-generated method stub
		return sm.querySupplier_yByStore(sid);
	}

}
