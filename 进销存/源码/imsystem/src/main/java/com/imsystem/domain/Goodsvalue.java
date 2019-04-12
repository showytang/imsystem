package com.imsystem.domain;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Goodsvalue {
    private String id;

    private String name;

    private String gid;

    private Double jprice;

    private Date time;

    private Date updatetime;

    private String uid;

    private Integer state;

    private Integer defaultvalue;

    private String enname;
    
    /**
     * 商品实例图片路径
     */
    private String column1;

    private String column2;

    private String column3;

    private String column4;

    private String column5;
    
    private MultipartFile img;
    
    /**
     * 商品实例规格集合
     */
    private List<Goodsstandardvalue> goodsstandardvalues;
    
    
    /**
	 * 商品价格集合
	 */
	private List<Goodsprice> goodsPrices;

	
	private Stockdetails stockDetails;
	
    
	
	
    public Stockdetails getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(Stockdetails stockDetails) {
		this.stockDetails = stockDetails;
	}

	public List<Goodsprice> getGoodsPrices() {
		return goodsPrices;
	}

	public void setGoodsPrices(List<Goodsprice> goodsPrices) {
		this.goodsPrices = goodsPrices;
	}

	
    public List<Goodsstandardvalue> getGoodsstandardvalues() {
		return goodsstandardvalues;
	}

	public void setGoodsstandardvalues(List<Goodsstandardvalue> goodsstandardvalues) {
		this.goodsstandardvalues = goodsstandardvalues;
	}

	public MultipartFile getImg() {
		return img;
	}
    
    public void setImg(MultipartFile img) {
		this.img = img;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Double getJprice() {
        return jprice;
    }

    public void setJprice(Double jprice) {
        this.jprice = jprice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(Integer defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
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