package com.imsystem.service.promotion;

import java.util.List;

import com.imsystem.domain.Customer;
import com.imsystem.domain.Khshortmessage;
import com.imsystem.domain.Message;

public interface ShortMessageService {

	List<Customer> queryAllCustomer();
	
	int inertshortMessage(Khshortmessage shortmessage);
	
	List<Khshortmessage> queryAllkh();
	
	List<Message> queryMessage(String khid);
	
	int inertMessage(List<Message> m);
	
}
