package com.imsystem.service.customer;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.imsystem.domain.NewsVo;
import com.imsystem.domain.Notice;
import com.imsystem.domain.Supplier;

public interface NewsService {
	
	/**
	 * 查询我的所有公告
	 * @return
	 */
	public List<NewsVo> queryMyNotice(String content,String uid);
	
	/**
	 * 根据id查询公告详情
	 * @param id
	 * @return
	 */
	public NewsVo queryNoticeById(String id);
	
	/**
	 * 新增公告
	 * @param nvobj
	 * @return
	 */
	public int addNews(NewsVo nvobj);
	
	/**
	 * 查询未读公告条数
	 * @param uid
	 * @return
	 */
	public int queryNotReadNews(String uid);

}
