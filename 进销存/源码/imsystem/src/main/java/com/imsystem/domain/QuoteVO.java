package com.imsystem.domain;

import java.util.List;

public class QuoteVO {
	
	private Goodsvalue gvobj;
	
	private Goods gobj;
	
	public Goods getGobj() {
		return gobj;
	}

	public void setGobj(Goods gobj) {
		this.gobj = gobj;
	}

	private Customer cobj;
	
	private Quotedprice qpobj;

	public Goodsvalue getGvobj() {
		return gvobj;
	}

	public void setGvobj(Goodsvalue gvobj) {
		this.gvobj = gvobj;
	}

	public Customer getCobj() {
		return cobj;
	}

	public void setCobj(Customer cobj) {
		this.cobj = cobj;
	}

	public Quotedprice getQpobj() {
		return qpobj;
	}

	public void setQpobj(Quotedprice qpobj) {
		this.qpobj = qpobj;
	}
	
	
	private List<Quotedprice> qplist;
	
	private List<Customer> clist;
	
	private List<Goods> glist;
	
	private List<Goodsvalue> gvlist;

	public List<Goodsvalue> getGvlist() {
		return gvlist;
	}

	public void setGvlist(List<Goodsvalue> gvlist) {
		this.gvlist = gvlist;
	}

	public List<Quotedprice> getQplist() {
		return qplist;
	}

	public void setQplist(List<Quotedprice> qplist) {
		this.qplist = qplist;
	}

	public List<Customer> getClist() {
		return clist;
	}

	public void setClist(List<Customer> clist) {
		this.clist = clist;
	}

	public List<Goods> getGlist() {
		return glist;
	}

	public void setGlist(List<Goods> glist) {
		this.glist = glist;
	}
	
	
	
	

}
