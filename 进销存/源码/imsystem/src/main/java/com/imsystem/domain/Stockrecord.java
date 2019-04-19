package com.imsystem.domain;

import java.util.Vector;

public class Stockrecord {
	private String id;

	private String aftersdid;

	private String beforesdid;

	private String aftersid;

	private String beforesid;

	private String column1;

	private String column2;

	private String column3;

	private String column4;

	private String column5;

	private Stockdetails stockdetails;

	public Stockdetails getStockdetails() {
		return stockdetails;
	}

	public void setStockdetails(Stockdetails stockdetails) {
		this.stockdetails = stockdetails;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAftersdid() {
		return aftersdid;
	}

	public void setAftersdid(String aftersdid) {
		this.aftersdid = aftersdid;
	}

	public String getBeforesdid() {
		return beforesdid;
	}

	public void setBeforesdid(String beforesdid) {
		this.beforesdid = beforesdid;
	}

	public String getAftersid() {
		return aftersid;
	}

	public void setAftersid(String aftersid) {
		this.aftersid = aftersid;
	}

	public String getBeforesid() {
		return beforesid;
	}

	public void setBeforesid(String beforesid) {
		this.beforesid = beforesid;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	public String getColumn5() {
		return column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}
}