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
import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Noticefiles;
import com.imsystem.domain.Noticestore;
import com.imsystem.domain.Store;
import com.imsystem.domain.Supplier;
import com.imsystem.domain.SupplierExample;
import com.imsystem.domain.User;
import com.imsystem.domain.SupplierExample.Criteria;
import com.imsystem.mapper.NoticeMapper;
import com.imsystem.mapper.NoticefilesMapper;
import com.imsystem.mapper.NoticestoreMapper;
import com.imsystem.mapper.StoreMapper;
import com.imsystem.mapper.SupplierMapper;
import com.imsystem.mapper.UserMapper;
import com.imsystem.service.customer.NewsService;
import com.imsystem.service.customer.SupplierService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NoticestoreMapper nsDao;
	@Autowired
	NoticeMapper nDao;
	@Autowired
	UserMapper uDao;
	@Autowired
	NoticefilesMapper nfDao;

	/**
	 * 查询我的所有公告
	 */
	@Override
	public List<NewsVo> queryMyNotice(String content, String uid) {
		// TODO Auto-generated method stub
		List<NewsVo> nvoList=new ArrayList<NewsVo>();
		List<Noticestore> nsList=nsDao.queryMyNotice(content, uid);
		if(nsList.size()>0) {
			for(Noticestore nsobj:nsList) {
				NewsVo nvobj=new NewsVo();
				if(nsobj!=null) {
					nvobj.setNsobj(nsobj);
					if(nsobj.getNid()!=null) {
						Notice nobj=nDao.selectByPrimaryKey(nsobj.getNid());
						if(nobj!=null) {
							nvobj.setNobj(nobj);
							if(nobj.getUid()!=null) {
								User uobj=uDao.selectByPrimaryKey(nobj.getUid());
								if(uobj!=null) {
									nvobj.setUobj(uobj);
								}
							}
						}
					}
				}
				nvoList.add(nvobj);
			}
		}
		return nvoList;
	}

	@Override
	public NewsVo queryNoticeById(String id) {
		// TODO Auto-generated method stub
		Noticestore nsobj=nsDao.selectByPrimaryKey(id);
		NewsVo nvobj=new NewsVo();
		nvobj.setNobj(nDao.selectByPrimaryKey(nsobj.getNid()));
		nvobj.setNflist(nfDao.queryFilesByNid(nsobj.getNid()));
		int row=nsDao.updateState(id);
		return nvobj;
	}

	@Override
	public int addNews(NewsVo nvobj) {
		// TODO Auto-generated method stub
		nvobj.setUlist(nDao.queryUserBySid(nvobj));
		String rand=UUID.randomUUID().toString();
		Date time=new Date();
		nvobj.getNobj().setId(rand);
		nvobj.getNobj().setTime(time);
		int row1=nDao.insertNotice(nvobj.getNobj());
		if(row1>0) {
			if(nvobj.getNflist()==null) {
				for(User uobj1:nvobj.getUlist()) {
					Noticestore nsobj1=new Noticestore();
					String randns1=UUID.randomUUID().toString();
					nsobj1.setId(randns1);
					nsobj1.setNid(nvobj.getNobj().getId());
					nsobj1.setSid(uobj1.getId());
					nsobj1.setColumn1("0");
					int rwo2=nsDao.insertns(nsobj1);
				}
			}else {
				for(Noticefiles nfobj:nvobj.getNflist()) {
					String randnf=UUID.randomUUID().toString();
					nfobj.setId(randnf);
					nfobj.setNid(nvobj.getNobj().getId());
					int rwo3=nfDao.insertnf(nfobj);
				}
				for(User uobj2:nvobj.getUlist()) {
					Noticestore nsobj2=new Noticestore();
					String randns2=UUID.randomUUID().toString();
					nsobj2.setId(randns2);
					nsobj2.setNid(nvobj.getNobj().getId());
					nsobj2.setSid(uobj2.getId());
					nsobj2.setColumn1("0");
					int rwo2=nsDao.insertns(nsobj2);
				}
			}
		}
		return 0;
	}

	@Override
	public int queryNotReadNews(String uid) {
		// TODO Auto-generated method stub
		int num=nsDao.queryNotReadNewsNum(uid);
		return num;
	}
	
	


}
