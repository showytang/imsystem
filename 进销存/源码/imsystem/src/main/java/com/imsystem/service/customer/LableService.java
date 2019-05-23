package com.imsystem.service.customer;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.Goodsvaluelable;
import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Supplier;
import com.imsystem.domain.UserLableVO;
import com.imsystem.domain.Userlable;

public interface LableService {
	
	/**
	 * 查询所有客户标签
	 * @return
	 */
	public List<Userlable> queryLableList();
	
	/**
	 * 新增客户标签
	 * @param ulobj  客户标签类
	 * @return
	 */
	public int addLabel(Userlable ulobj);
	
	/**
	 * 根据id查询客户标签
	 * @param lid
	 * @return
	 */
	public Userlable queryLableById(String lid);
	
	/**
	 * 修改客户标签
	 * @param ulobj
	 * @return
	 */
	public int updateLabel(Userlable ulobj);
	
	/**
	 * 删除客户标签
	 * @param id
	 * @return
	 */
	public int deleteLabel(String id);
	
	/**
	 * 查询该用户门店下的客户
	 * @param uid
	 * @return
	 */
	public List<Customer> queryCustomer(String uid);
	
	/**
	 * 查询客户标签及所有标签
	 * @param cid    客户id
	 * @param name  标签名称（模糊查）
	 * @return
	 */
	public List<UserLableVO> queryCustomerLable(String cid,String name);
	
	/**
	 * 为客户新增标签
	 * @param ulvo
	 * @return
	 */
	public int addUserLable(UserLableVO ulvo);
	
	/**
	 * 查询所有商品实例标签
	 * @return
	 */
	public List<Goodsvaluelable> queryGoodsValueLableList();
	
	/**
	 * 新增商品实例标签
	 * @param ulobj  客户标签类
	 * @return
	 */
	public int addgvLabel(Goodsvaluelable gvlobj);
	
}
