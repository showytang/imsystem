package com.imsystem.service.customer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customertype;
import com.imsystem.domain.QueryCustomerTypeVO;
import com.imsystem.mapper.CustomertypeMapper;
import com.imsystem.service.customer.CustomerTypeService;

@Service
@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService{

	@Autowired
	CustomertypeMapper ctDao;
	
	/**
	 * 查询所有客户类型
	 */
	@Override
	public List<Customertype> queryCustomerType() {
		// TODO Auto-generated method stub
		return ctDao.selectByExample(null);
	}

	/**
	 * 新增客户类型
	 */
	@Override
	public int insertCustomerType(Customertype ctObj) {
		// TODO Auto-generated method stub
		String rand=UUID.randomUUID().toString();
		ctObj.setId(rand);
		Date time=new Date();
		ctObj.setTime(time);
		ctObj.setUpdatetime(time);
		ctObj.setState(0);
		int row1=ctDao.insert(ctObj);
		if(row1>0) {
			if(ctObj.getDefaulttype()==0) {
				int row2=ctDao.updateDefaultType(ctObj.getId());
				if(row2>0) {
					return 2;
				}
			}
			return 1;
		}
		return 0;
	}

	/**
	 * 删除客户类型(修改状态)
	 */
	@Override
	public int deleteCustomerType(int ctId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改客户类型
	 */
	@Override
	public int updateCustomerType(Customertype ctObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据ID查询客户类型
	 */
	@Override
	public Customertype queryCustomerTypeById(int ctId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询所有客户类型VO
	 */
	@Override
	public List<QueryCustomerTypeVO> queryAllCustomerType() {
		// TODO Auto-generated method stub
		List<QueryCustomerTypeVO> ctListVO=new ArrayList<QueryCustomerTypeVO>();
		List<Customertype> ctList=ctDao.selectByExample(null);
		for(Customertype ctObj:ctList) {
			QueryCustomerTypeVO ctvObj=new QueryCustomerTypeVO();
			if(ctObj!=null) {
				ctvObj.setCtObj(ctObj);
				if(ctObj.getUid()!="" || ctObj.getUid()!=null) {
					/*根据id查询用户对象*/
//					ctvObj.setuObj(uObj);
					ctListVO.add(ctvObj);
				}
			}
		}
		return ctListVO;
	}

}
