package com.imsystem.service.customer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customerlevel;
import com.imsystem.domain.Customertype;
import com.imsystem.domain.QueryCustomerLevelVO;
import com.imsystem.domain.QueryCustomerTypeVO;
import com.imsystem.domain.User;
import com.imsystem.mapper.CustomerlevelMapper;
import com.imsystem.mapper.UserMapper;
import com.imsystem.service.customer.CustomerLevelService;

@Service
@Transactional
public class CustomerLevelServiceImpl implements CustomerLevelService{

	@Autowired
	CustomerlevelMapper clDao;
	@Autowired
	UserMapper uDao;
	
	/**
	 * 查询所有客户等级
	 */
	@Override
	public List<Customerlevel> queryCustomerLevel() {
		// TODO Auto-generated method stub
		return clDao.selectByExample(null);
	}

	/**
	 * 新增客户等级
	 */
	@Override
	public int insertCustomerLevel(Customerlevel clObj) {
		// TODO Auto-generated method stub
		String rand=UUID.randomUUID().toString();
		Date time=new Date();
		clObj.setId(rand);
		clObj.setTime(time);
		clObj.setUpdatetime(time);
		clObj.setState(0);
		int row=clDao.insert(clObj);
		return row;
	}

	/**
	 * 删除客户等级（修改状态）
	 */
	@Override
	public int deleteCustomerLevel(String clId) {
		// TODO Auto-generated method stub
		return clDao.deleteCustomerLevel(clId);
	}

	/**
	 * 修改客户等级
	 */
	@Override
	public int updateCustomerLevel(Customerlevel clObj) {
		// TODO Auto-generated method stub
		Date time=new Date();
		clObj.setUpdatetime(time);
		int row=clDao.updateCustomerLevel(clObj);
		return row;
	}

	/**
	 * 根据ID查询客户等级
	 */
	@Override
	public Customerlevel queryCustomerLevelById(String clId) {
		// TODO Auto-generated method stub
		return clDao.selectByPrimaryKey(clId);
	}

	/**
	 * 查询所有未删除的客户级别VO
	 */
	@Override
	public List<QueryCustomerLevelVO> queryAllCustomerLevel() {
		// TODO Auto-generated method stub
		List<QueryCustomerLevelVO> clListVO=new ArrayList<QueryCustomerLevelVO>();
		List<Customerlevel> clList=clDao.queryCustomerLevel();
		for(Customerlevel clObj:clList) {
			QueryCustomerLevelVO clvObj=new QueryCustomerLevelVO();
			if(clObj!=null) {
				clvObj.setClObj(clObj);
				if(clObj.getUid()!="" || clObj.getUid()!=null) {
					/*根据id查询用户对象*/
					User uObj=uDao.queryUserById(clObj.getUid());
					clvObj.setuObj(uObj);
					clListVO.add(clvObj);
				}
			}
		}
		return clListVO;
	}

	/**
	 * 根据条件查询未删除的客户等级
	 */
	@Override
	public List<QueryCustomerLevelVO> queryLikeCustomerLevel(String content) {
		// TODO Auto-generated method stub
		List<QueryCustomerLevelVO> clListVO=new ArrayList<QueryCustomerLevelVO>();
		List<Customerlevel> clList=clDao.queryLikeCustomerLevel(content);
		for(Customerlevel clObj:clList) {
			QueryCustomerLevelVO clvObj=new QueryCustomerLevelVO();
			if(clObj!=null) {
				clvObj.setClObj(clObj);
				if(clObj.getUid()!="" || clObj.getUid()!=null) {
					/*根据id查询用户对象*/
					User uObj=uDao.queryUserById(clObj.getUid());
					clvObj.setuObj(uObj);
					clListVO.add(clvObj);
				}
			}
		}
		return clListVO;
	}
	
}
