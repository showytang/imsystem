package com.imsystem.domain;

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
	
	

}
