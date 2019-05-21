package com.imsystem.controller.promotion;

import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.imsystem.domain.GoodsVO;
import com.imsystem.domain.Goodsvalue;
import com.imsystem.domain.PromotionCondition;
import com.imsystem.domain.Promotiongoods;
import com.imsystem.domain.Promotionrulevalue;

public class StringFormula {

	public  List<PromotionCondition>  main(PromotionCondition condition,List<Promotionrulevalue> promotionrulevalue) {
		
		List<PromotionCondition> pclist = new ArrayList<PromotionCondition>();
		
		for(Promotionrulevalue prv:promotionrulevalue) {
			
			String [] conditionArray = prv.getPromotionrule().getCondition().split(":");
			
			String [] formulaArray = prv.getPromotionrule().getFormula().split(":");
			
			if(conditionArray.length >= 2) {
				
				pclist.add(getCondition(formulaArray,conditionArray,condition,prv));
				
			}
			
		}
		
		
		return pclist;
		
	}
	
	
	/**
	 * 判断条件
	 * @param script1
	 * @param script2
	 * @param condition
	 * @return
	 */
	private PromotionCondition getCondition(String [] formulaArray,String [] conditionArray,PromotionCondition condition,Promotionrulevalue prv) {
		PromotionCondition re = new PromotionCondition();
		
		if(conditionArray[0].indexOf("os") != -1) {
			//订单总额判断
			if( priceCondition(conditionArray[0],conditionArray[1],condition.getTotalprice())) {
				
				re.setPromotiontotalprice(getTotalPrice(formulaArray[0],formulaArray[1],condition.getTotalprice()));
				re.setPrv(prv);
				re.setTotalprice(condition.getTotalprice());
				
			}
			
		}else if(conditionArray[0].indexOf("gc") != -1) {
			
			if(formulaArray[0].indexOf("z") != -1) {
				
				//商品数量判断
				if(goodsTrueCondition(conditionArray[0],conditionArray[1],prv.getPromotion().getPromotiongoods(),condition.getGoodsvolist())) {
					
					re.setGvid(getGiveGoodsValue(Integer.valueOf(formulaArray[1]),condition.getGoodsvolist()));
					re.setPrv(prv);
					
				}
				
			}else if(formulaArray[0].indexOf("s") != -1) {
				
				//订单总额判断
				if( priceCondition(conditionArray[0],conditionArray[1],condition.getTotalprice())) {
					
					re.setPromotiontotalprice(getTotalPrice(formulaArray[0],formulaArray[1],condition.getTotalprice()));
					re.setPrv(prv);
					re.setTotalprice(condition.getTotalprice());
					
				}
				
			}
			
			
		}
		
		return re;
		
	}
	
	
	
	
	/**
	 * 商品数量判断
	 * @param script 条件脚本
	 * @return
	 */
	private boolean goodsTrueCondition(String script1,String script2,List<Promotiongoods> list,List<GoodsVO> gvolist) {
		
		if(gvolist == null) {
			return false;
		}
		
		//获取所有商品集合
		List <Goodsvalue> gvs = new ArrayList<Goodsvalue>();
		
		for (GoodsVO gvo : gvolist) {
			
			gvs.addAll(gvo.getGoodsValues());
			
		}
		
		
		Integer ct = 0;
		
		for(Promotiongoods pg:list) {
			
			for(Goodsvalue gv:gvs) {
				
				if(pg.getGid().equals(gv.getId())) {
					ct++;
				}
				
			}
			
		}
		
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        Compilable compilable = (Compilable) engine;
        Bindings bindings = engine.createBindings(); //Local级别的Binding
        CompiledScript JSFunction = null; //解析编译脚本函数
        try {
        	
            JSFunction = compilable.compile(script1+script2);
            bindings.put(script1, ct);
            Object result = JSFunction.eval(bindings);
           return (boolean) result; //返回结果
           
        } catch (ScriptException e) {
            e.printStackTrace();
        }
		
		
        return false;
        
	}
	
	
	/**
	 * 总价判断
	 * @param script 条件脚本
	 * @return
	 */
	private boolean priceCondition(String script1,String script2,Double totalprice) {
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        Compilable compilable = (Compilable) engine;
        Bindings bindings = engine.createBindings(); //Local级别的Binding
        CompiledScript JSFunction = null; //解析编译脚本函数
        try {
        	
            JSFunction = compilable.compile(script1+script2);
            bindings.put(script1, totalprice);
            Object result = JSFunction.eval(bindings);
           return (boolean) result; //返回结果
           
        } catch (ScriptException e) {
            e.printStackTrace();
        }
		
        return false;
        
	}
	
	/**
	 * 商品买X送X
	 * @param script
	 * @param gvolist
	 * @return
	 */
	private String [] getGiveGoodsValue(Integer script,List<GoodsVO> gvolist) {
		
		//商品排序
		for (int i = 0; i < gvolist.size()-1; i++) {
			
			for (int j = 0; j < gvolist.size()-1 -i; j++) {
				
				if(gvolist.get(j).getGoods().getPrice() > gvolist.get(j+1).getGoods().getPrice()) {
					
					GoodsVO temp = gvolist.get(j);
					
					gvolist.set(j,gvolist.get(j+1));
					
					gvolist.set(j+1,temp);
				}
				
			}
			
		}
		
		//获取所有商品集合
		List <Goodsvalue> gvs = new ArrayList<Goodsvalue>();
		
		for (GoodsVO gvo : gvolist) {
			
			gvs.addAll(gvo.getGoodsValues());
			
		}

		String [] gvids = new String[script];
		
		for (int i = 0; i < script; i++) {
			
			gvids[i] = gvs.get(i).getId();
			
		}
		
		return gvids;
	}
	
	/**
	 * 获取优惠价格or折扣价格
	 * @param script1
	 * @param script2
	 * @param totalprice
	 * @return
	 */
	private Double getTotalPrice(String script1,String script2,Double totalprice) {
		

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        Compilable compilable = (Compilable) engine;
        Bindings bindings = engine.createBindings(); //Local级别的Binding
        CompiledScript JSFunction = null; //解析编译脚本函数
        try {
        	
            JSFunction = compilable.compile(script1+script2);
            bindings.put(script1, totalprice);
            Object result = JSFunction.eval(bindings);
           return (Double) result; //返回结果
           
        } catch (ScriptException e) {
            e.printStackTrace();
        }
		
        return totalprice;
		
	}
	
	
	
}
