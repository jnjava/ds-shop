package com.dscomm.shop.data.dal.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.alibaba.fastjson.JSON;
import com.dscomm.shop.data.dal.CategoryRepository;
import com.dscomm.shop.data.po.Category;
import com.dscomm.shop.data.po.Goods;
import com.dscomm.shop.data.po.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-shop-*.xml")
@TestExecutionListeners(listeners={
		 DependencyInjectionTestExecutionListener.class,
		 TransactionalTestExecutionListener.class
		})
public class GategoryTest {

	private static final Log logger = LogFactory.getLog(GategoryTest.class);
	
	@Autowired
	private CategoryRepository gategoryRepo;
	
	@Test	
	public void SaveGategory()
	{
		Store store = new Store();
		store.setName("1号店");
		store.setAddress("乌鲁木齐北京路40号");
		store.setCall_number("18654214230");
		store.setManager_name("经理");
		store.setStart_date(new Date());
		store.setDutyer_name("负责人");
		store.setCoordinate("100000000,20000000");
		
		Category category = new Category();
		
		
		category.setIcon_url("/category/icon");
		category.setName("蔬菜");
		category.setSort_order(1);
		
		
		
		gategoryRepo.save(category);
		 
		System.out.print(JSON.toJSONString(category));
	}
	
	@Test
	public void GetGoodsOne()
	{
		Iterable<Category> categoryList = gategoryRepo.findAll();
		System.out.print(JSON.toJSONString(categoryList));
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
