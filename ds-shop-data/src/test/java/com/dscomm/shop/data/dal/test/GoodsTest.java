package com.dscomm.shop.data.dal.test;

import static org.junit.Assert.*;

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
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dscomm.shop.data.dal.CategoryRepository;
import com.dscomm.shop.data.dal.GoodsRepository;
import com.dscomm.shop.data.po.Category;
import com.dscomm.shop.data.po.Goods;
import com.dscomm.shop.data.po.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-shop-*.xml")
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
public class GoodsTest {

	private static final Log logger = LogFactory.getLog(GoodsTest.class);

	@Autowired
	private GoodsRepository goodsRepo;

	@Autowired
	private CategoryRepository gategoryRepo;

	@Test
	public void SaveGoods() {
		Store store = new Store();
		store.setName("1号店");
		store.setAddress("乌鲁木齐北京路40号");
		store.setCall_number("18654214230");
		store.setManager_name("经理");
		store.setStart_date(new Date());
		store.setDutyer_name("负责人");
		store.setCoordinate("100000000,20000000");

		Category category = gategoryRepo.findOne("402881ea6256e8e8016256e8ee2e0000");
		Goods goods = new Goods();
		goods.setGoods_sn("SN-00000000-1111");
		goods.setAverage_price(12.50);
		goods.setIsvalid(1);
		goods.setMember_price(12.00);
		goods.setName("白菜");
		goods.setProduce_date(new Date());
		goods.setReserve_price(12.40);
		goods.setShelflife(10);
		goods.setMark(1);
		goods.setRemark("备注");
		goods.setRetail_price(12.00);
		goods.setScore(100);
		goods.setCategory(category);

		category.setIcon_url("/category/icon");
		category.setName("蔬菜");
		category.setSort_order(1);

		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(goods);
		category.setGoods(goodsList);
		goodsRepo.save(goods);

		System.out.print(JSON.toJSONString(store));
	}

	@Test
	public void SaveGategoryAndGoodsList() {

		Category category = new Category();
		category.setIcon_url("/category/icon");
		category.setName("水果");
		category.setSort_order(1);

		List<Goods> goodsList = new ArrayList<Goods>();

		Goods goods = new Goods();
		goods.setGoods_sn("SN-00000000-1111" );
		goods.setAverage_price(12.50);
		goods.setIsvalid(1);
		goods.setMember_price(12.00);
		goods.setName("苹果" );
		goods.setProduce_date(new Date());
		goods.setReserve_price(12.40);
		goods.setShelflife(10);
		goods.setMark(1);
		goods.setRemark("备注");
		goods.setRetail_price(12.00);
		goods.setScore(100);
		goods.setCategory(category);

		goodsList.add(goods);
		

		category.setGoods(goodsList);
		gategoryRepo.save(category);
		goodsRepo.save(goods);
		// goodsRepo.save(goods);

		Category category1= gategoryRepo.findOne(category.getId());
		System.out.print(JSON.toJSONString(category1));
	}

	@Test
	public void GetGoodsOne() {
		// Iterable<Goods> goodsList = goodsRepo.findAll();
		// System.out.print(JSON.toJSONString(goodsList));
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
