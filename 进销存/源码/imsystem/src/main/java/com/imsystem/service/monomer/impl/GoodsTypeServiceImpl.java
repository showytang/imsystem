package com.imsystem.service.monomer.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;



import com.imsystem.mapper.GoodstypeMapper;
import com.imsystem.service.monomer.GoodsTypeService;
@Service
@Controller
public class GoodsTypeServiceImpl implements GoodsTypeService{
	@Autowired
	GoodstypeMapper goods;

	

	/*@Override
	public PageInfo<Goodstype> queryByPage(Integer currentPage, Integer pageSize) {
		Page<Goodstype> page = PageHelper.startPage(currentPage, pageSize,true);
		
		goods.queryall();
		
		return page.toPageInfo();
	}*/

}
