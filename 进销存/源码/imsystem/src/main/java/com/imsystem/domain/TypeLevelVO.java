package com.imsystem.domain;

import java.util.List;

public class TypeLevelVO {
	
	private List<QueryCustomerTypeVO> ctlist;
	
	private List<QueryCustomerLevelVO> cllist;
	
	private List slist;
	

	public List getSlist() {
		return slist;
	}

	public void setSlist(List slist) {
		this.slist = slist;
	}

	public List<QueryCustomerTypeVO> getCtlist() {
		return ctlist;
	}

	public void setCtlist(List<QueryCustomerTypeVO> ctlist) {
		this.ctlist = ctlist;
	}

	public List<QueryCustomerLevelVO> getCllist() {
		return cllist;
	}

	public void setCllist(List<QueryCustomerLevelVO> cllist) {
		this.cllist = cllist;
	}
	

}
