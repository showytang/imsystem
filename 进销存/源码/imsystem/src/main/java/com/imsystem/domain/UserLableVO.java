package com.imsystem.domain;

import java.util.List;

public class UserLableVO {
	
	/**
	 * 用户标签对象
	 */
	private Userlable ulobj;
	
	/**
	 * 用户和标签关联对象
	 */
	private Userandlable ualobj;

	public Userlable getUlobj() {
		return ulobj;
	}

	public void setUlobj(Userlable ulobj) {
		this.ulobj = ulobj;
	}

	public Userandlable getUalobj() {
		return ualobj;
	}

	public void setUalobj(Userandlable ualobj) {
		this.ualobj = ualobj;
	}
	
	public List<Userlable> ullist;

	public List<Userlable> getUllist() {
		return ullist;
	}

	public void setUllist(List<Userlable> ullist) {
		this.ullist = ullist;
	}
	
	
	

}
