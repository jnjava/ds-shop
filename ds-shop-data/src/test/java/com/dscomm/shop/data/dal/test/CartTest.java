package com.dscomm.shop.data.dal.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.dscomm.shop.data.dal.CartRepository;
import com.dscomm.shop.data.dal.EmployeeRepository;
import com.dscomm.shop.data.dal.GoodsRepository;
import com.dscomm.shop.data.dal.MemberRepository;
import com.dscomm.shop.data.dal.StoreRepository;
import com.dscomm.shop.data.po.Cart;
import com.dscomm.shop.data.po.CartGoods;
import com.dscomm.shop.data.po.Employee;
import com.dscomm.shop.data.po.Goods;
import com.dscomm.shop.data.po.Member;
import com.dscomm.shop.data.po.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-shop-*.xml")
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
public class CartTest {
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private GoodsRepository goodsRepo;
	

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/*
	 * 一次购物行为
	 */
	@Test
	public void SaveShopping(){
		Store store = storeRepo.findByName("1号店");
		
		
		Employee employee = employeeRepo.findOne("402881ea6273f6c7016273f6cb2d0000");
		
		Member member = memberRepo.findOne("402881ea62791a000162791a05be0000");
	
		
		
		Cart cart = new Cart();
		cart.setShopping_date(new Date());
		cart.setStore(store);
		cart.setMember(member);
		cart.setEmployee(employee);
		
		
		Goods goods = goodsRepo.findOne("402881ea6278e747016278e74b090000");
		
		
		
		CartGoods cartgoods = new CartGoods();
		cartgoods.setCart(cart);
		cartgoods.setTotal_price(200);
		cartgoods.setUnit_price(10);
		cartgoods.setGoods(goods);
		
		
		
		List<CartGoods> cartgoodsList = new ArrayList<CartGoods>();
		cartgoodsList.add(cartgoods);
		cart.setCartgoods(cartgoodsList);
		cartRepo.save(cart);
		
		/*goods.setCartgoods(cartgoodsList);
		goodsRepo.save(goods);*/
	}

}
