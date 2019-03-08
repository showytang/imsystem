package com.imsystem;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imsystem.domain.Goods;
import com.imsystem.service.GoodsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsystemApplicationTests {

	@Autowired
	GoodsService goodsRepository;

	@Test
	public void contextLoads() {
			
		List<Goods> list = goodsRepository.queryByPage(0, 2);
		System.out.println(list);

	}

}
