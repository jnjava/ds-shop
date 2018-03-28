package com.dscomm.shop.data.dal.test;

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

import com.dscomm.shop.data.dal.EmployeeRepository;
import com.dscomm.shop.data.dal.MemberRepository;
import com.dscomm.shop.data.dal.StoreRepository;
import com.dscomm.shop.data.po.Employee;
import com.dscomm.shop.data.po.Member;
import com.dscomm.shop.data.po.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-shop-*.xml")
@TestExecutionListeners(listeners={
		 DependencyInjectionTestExecutionListener.class,
		 TransactionalTestExecutionListener.class
		})
public class MemberTest {

	private static final Log logger = LogFactory.getLog(MemberTest.class);
	
	@Autowired
	private MemberRepository memberRepo;	
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Test	
	public void SaveMember()
	{
		Member member = new Member();
		member.setIsvalid(1);
		member.setName("小明");
		member.setGrade(1);
		member.setMoney(3000);
		member.setPhone("18625433312");
		member.setCreate_date(new Date());
		
		Store store = storeRepo.findByName("1号店");
		
		Employee employee = employeeRepo.findOne("402881ea6273f6c7016273f6cb2d0000");
		
		member.setStore(store);
		member.setEmployee(employee);
		
		memberRepo.save(member);
		 
		//System.out.print(JSON.toJSONString(member));
	}
	
	

}
