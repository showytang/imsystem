package com.imsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.imsystem.domain.Goods;

@Service
public class GoodsService {
	
	@Autowired
	MongoOperations mongoOperations;
	
	/**
     * 向mongodb中插入一条数据
     */
    public void insert(Goods Goods){
        mongoOperations.insert(Goods);
    }
 
    /**
     * 批量插入
     */
    public void batchInsert(List<Goods> GoodsList){
        mongoOperations.insertAll(GoodsList);
    }
 
    /**
     * 根据名字查询
     */
    public List<Goods> queryByName(String name){
        Criteria criteria = Criteria.where("name").is(name);
        Query query = new Query(criteria);
        return mongoOperations.find(query, Goods.class);
    }
 
    /**
     * 组合条件查询
     */
    public List<Goods> queryByNameAndAge(String name, String code){
        Criteria criteria = Criteria.where("name").is(name);
        criteria.and("code").is(code);
        Query query = new Query(criteria);
        return mongoOperations.find(query, Goods.class);
    }
 
    /**
     * 根据list里的数据查询
     */
    public List<Goods> queryByHobbyList(List<String> hobbyList){
        Criteria criteria = Criteria.where("id").in(hobbyList);
        Query query = new Query(criteria);
        return mongoOperations.find(query, Goods.class);
    }
 
    /**
     * 根据时间排序
     */
    public List<Goods> orderByCreateTime(){
        Query query = new Query().with(new Sort(Sort.Direction.DESC,"time"));
        return mongoOperations.find(query, Goods.class);
    }
 
    /**
     * 根据price区间查询
     */
    public List<Goods> queryByAgeRange(int min, int max){
        Criteria criteria = Criteria.where("price").gte(min).lte(max);
        Query query = new Query(criteria);
        return mongoOperations.find(query, Goods.class);
    }
 
    /**
     * 其余的条件删除与更新都是先拼好Query与查询类型
     * 只是换了最后调用的函数，这里不再演示
     */
    public void deleteAll(){
        mongoOperations.dropCollection(Goods.class);
    }
	
    /**
     * 分页排序
     * @param offset 页码
     * @param limit 每页条数
     */
    public List<Goods> queryByPage(int offset,int limit) {
    	Query query = new Query().with(new Sort(Sort.Direction.DESC,"time"));
    	Pageable pageable = new PageRequest(offset,limit);
    	query.with(pageable);
    	return mongoOperations.find(query, Goods.class);
    }
    
    public static void main(String[] args) {
		int x = (int)(Math.random()*24)+1;
		System.out.println(x);
	}
	
}
