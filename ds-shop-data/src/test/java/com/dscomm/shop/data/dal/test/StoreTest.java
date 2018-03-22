package com.dscomm.shop.data.dal.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dscomm.shop.data.dal.StoreRepository;
import com.dscomm.shop.data.po.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-shop-*.xml")
@TestExecutionListeners(listeners={
		 DependencyInjectionTestExecutionListener.class,
		 TransactionalTestExecutionListener.class
		})
public class StoreTest {

	private static final Log logger = LogFactory.getLog(StoreTest.class);
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Test
	@Transactional
	public void SaveStore()
	{
		Store store = new Store();
		store.setName("1号店");
		store.setAddress("乌鲁木齐北京路40号");
		store.setCall_number("18654214230");
		store.setManager_name("经理");
		store.setStart_date(new Date());
		store.setDutyer_name("负责人");
		store.setCoordinate("100000000,20000000");
		store = storeRepo.save(store);
		System.out.print(JSON.toJSONString(store));
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
