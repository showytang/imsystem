package com.imsystem.service.goods;

import java.util.List;

import com.imsystem.domain.Goodstype;
import com.imsystem.domain.Standard;

public interface GoodsTypeService {

	List<Goodstype> QueryGoodsTypeByPid(Integer id);
	
	List<Standard> queryStandradByid(Integer id);
	
	
}
