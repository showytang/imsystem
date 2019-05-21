package com.imsystem.service.promotion.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imsystem.domain.Customer;
import com.imsystem.domain.CustomerExample;
import com.imsystem.domain.Khshortmessage;
import com.imsystem.domain.Khshortmessagevalue;
import com.imsystem.domain.Message;
import com.imsystem.domain.MessageExample;
import com.imsystem.mapper.CustomerMapper;
import com.imsystem.mapper.KhshortmessageMapper;
import com.imsystem.mapper.KhshortmessagevalueMapper;
import com.imsystem.mapper.MessageMapper;
import com.imsystem.service.promotion.ShortMessageService;

@Service
@Transactional
public class ShortMessageImpl implements ShortMessageService {

	@Autowired
	private CustomerMapper cusMap;
	@Autowired
	private KhshortmessageMapper khsmMap;
	@Autowired
	private KhshortmessagevalueMapper khvsMap;
	@Autowired
	private MessageMapper meMap;
	
	@Override
	public List<Customer> queryAllCustomer() {
		// TODO Auto-generated method stub
		CustomerExample example = new CustomerExample();
		example.createCriteria().andStateEqualTo(0);
		return cusMap.selectByExample(example);
	}

	@Override
	public synchronized int inertshortMessage(Khshortmessage shortmessage) {
		// TODO Auto-generated method stub
		String smid = new Date().getTime()+"";
		shortmessage.setId(smid);
		shortmessage.setTime(new Date());
		
		for(Khshortmessagevalue v:shortmessage.getCustomerlist()) {
			v.setKhid(smid);
			v.setTime(new Date());
			v.setId(new Date().getTime()+"");
			khvsMap.insertSelective(v);
		}
		
		return khsmMap.insertSelective(shortmessage);
	}

	@Override
	public List<Khshortmessage> queryAllkh() {
		// TODO Auto-generated method stub
		return khsmMap.queryAllkh();
	}

	@Override
	public List<Message> queryMessage(String khid) {
		// TODO Auto-generated method stub
		
		MessageExample example = new MessageExample();
		example.createCriteria().andKhidEqualTo(khid);
		
		return meMap.selectByExample(example);
	}

}
