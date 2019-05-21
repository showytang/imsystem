package com.imsystem.domain;

import java.util.List;

public class NewsVo {
	
	/**
	 * 用户对象
	 */
	private User uobj;
	
	/**
	 * 公告对象
	 */
	private Notice nobj;
	
	private Noticefiles nfobj;
	
	/**
	 * 公告接收者对象
	 */
	private Noticestore nsobj;
	
	/**
	 * 用户集合
	 */
	private List<User> ulist;
	
	
	public List<User> getUlist() {
		return ulist;
	}

	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}

	/**
	 * 门店集合
	 */
	private List<Store> clist;
	
	
	public List<Store> getClist() {
		return clist;
	}

	public void setClist(List<Store> clist) {
		this.clist = clist;
	}

	/**
	 * 公告附件集合
	 */
	private List<Noticefiles> nflist;

	public List<Noticefiles> getNflist() {
		return nflist;
	}

	public void setNflist(List<Noticefiles> nflist) {
		this.nflist = nflist;
	}

	public User getUobj() {
		return uobj;
	}

	public void setUobj(User uobj) {
		this.uobj = uobj;
	}

	public Notice getNobj() {
		return nobj;
	}

	public void setNobj(Notice nobj) {
		this.nobj = nobj;
	}

	public Noticefiles getNfobj() {
		return nfobj;
	}

	public void setNfobj(Noticefiles nfobj) {
		this.nfobj = nfobj;
	}

	public Noticestore getNsobj() {
		return nsobj;
	}

	public void setNsobj(Noticestore nsobj) {
		this.nsobj = nsobj;
	}
	
	

}
