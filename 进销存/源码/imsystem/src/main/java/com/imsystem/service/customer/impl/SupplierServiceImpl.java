package com.imsystem.service.customer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.Customer;
import com.imsystem.domain.Store;
import com.imsystem.domain.Supplier;
import com.imsystem.domain.SupplierExample;
import com.imsystem.domain.User;
import com.imsystem.domain.SupplierExample.Criteria;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.mapper.SupplierMapper;
import com.imsystem.mapper.UserMapper;
import com.imsystem.service.customer.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	SupplierMapper sDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	StoreMapper storeDao;

	/**
	 *  查询所有供应商
	 */
	@Override
	public List<Supplier> querySupplier() {
		// TODO Auto-generated method stub
		return sDao.selectAllSupplier();
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
		
		if(addr.length>4) {
			supObj.setProvince(addr[0]);
			supObj.setCity(addr[1]);
			supObj.setDistrict(addr[2]);
			String address1=addr[3]+"/"+addr[4];
			supObj.setAddres(address1);
		}else {
			supObj.setProvince(addr[0]);
			supObj.setCity(addr[1]);
			supObj.setDistrict(addr[2]);
			supObj.setAddres(addr[3]);
		}
		
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
		return sDao.deleteSupplier(supId);
	}

	/**
	 * 修改供应商
	 */
	@Override
	public int updatSupplier(Supplier supObj) {
		// TODO Auto-generated method stub
		Date time=new Date();
		String address=supObj.getAddres();
		String[] addr=address.split("/");
		supObj.setUpdatetime(time);
		if(addr.length>4) {
			supObj.setProvince(addr[0]);
			supObj.setCity(addr[1]);
			supObj.setDistrict(addr[2]);
			String address1=addr[3]+"/"+addr[4];
			supObj.setAddres(address1);
		}else {
			supObj.setProvince(addr[0]);
			supObj.setCity(addr[1]);
			supObj.setDistrict(addr[2]);
			supObj.setAddres(addr[3]);
		}
		
		
		int row=sDao.updateSupplier(supObj);
		return row;
	}

	/**
	 * 根据ID查询供应商 
	 */
	@Override
	public Supplier querySupplierById(String supId) {
		// TODO Auto-generated method stub
		return sDao.selectByPrimaryKey(supId);
	}

	@Override
	public List<Supplier> querySupplierList(Double zero, String content,String uid) {
		// TODO Auto-generated method stub
		
		List<Supplier> slist=new ArrayList<Supplier>();
		
		//根据id查得用户对象
		User uobj=userDao.queryUserById(uid);
		//获取用户所属门店id，并转换为String类型
		String sid=uobj.getStoreid().toString();
		//根据用户门店id查得用户所属门店对象
		Store sobj=storeDao.selectByPrimaryKey(sid);
		
		//若所属门店父级为0；则需查询该门店及其分店下的供应商
		if(sobj.getParented().equals("0")) {
			//查询该门店下的供应商
			List<Supplier> slist1=sDao.querySupplierByPage(content, zero, sobj.getId());
			if(slist1.size()>0) {
				slist.addAll(slist1);
			}
			//查询该门店下的分店
			List<Store> sList=storeDao.SelectStoreByParentId(sobj.getId());
			if(sList.size()>0) {
				//遍历查询各分门店下的供应商
				for(Store sObj1:sList) {
					
					List<Supplier> slist2=sDao.querySupplierByPage(content, zero, sObj1.getId());
					if(slist2.size()!=0) {
						slist.addAll(slist2);
					}
				}
			}
		}else {
			//否则只需查出该门店的供应商
			List<Supplier> slist3=sDao.querySupplierByPage(content, zero, sobj.getId());
			if(slist3.size()>0) {
				slist.addAll(slist3);
			}
		}
		
		
		/*Page<Supplier> page=PageHelper.startPage(curentPage,1,true);
		sDao.querySupplierByPage(content, zero,uid);
		PageInfo<Supplier> pages=page.toPageInfo();*/
		return slist;
	}

	@Override
	public List<Supplier> queryRecentDealSupplier(String storeid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Supplier> queryDealOrderSupplier(String storeid) {
		// TODO Auto-generated method stub
		return sDao.queryDealOrderSupplier(storeid);
	}

	@Override
	public List<Supplier> queryByName(String name) {
		// TODO Auto-generated method stub
		
		return sDao.queryByName(name);
	}

}
