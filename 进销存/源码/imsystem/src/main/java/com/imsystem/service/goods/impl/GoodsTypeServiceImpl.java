package com.imsystem.service.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Goodstype;
import com.imsystem.domain.Standard;
import com.imsystem.mapper.GoodstypeMapper;
import com.imsystem.mapper.StandardMapper;
import com.imsystem.service.goods.GoodsTypeService;

@Transactional
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	
	/**
	 * 商品类型Mapper
	 */
	@Autowired
	private GoodstypeMapper goodstypeMap;
	
	@Autowired
	private StandardMapper standardMap;
	
	/**
	 * 商品类型查询
	 */
	@Override
	public List<Goodstype> QueryGoodsTypeByPid(String id) {
		// TODO Auto-generated method stub
		return goodstypeMap.QueryGoodsTypeByPid(id);
	}

	@Override
	public List<Standard> queryStandradByid(String id) {
		// TODO Auto-generated method stub
		return standardMap.queryStandardById(id);
	}

	@Override
	public Goodstype queryGoodsTypeReverse(String id) {
		// TODO Auto-generated method stub
		return goodstypeMap.queryGoodsTypeReverse(id);
	}
	
	
	
	
	
	
	
	
}
