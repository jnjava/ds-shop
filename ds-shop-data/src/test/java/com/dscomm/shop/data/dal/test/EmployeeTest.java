package com.dscomm.shop.data.dal.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.dscomm.shop.data.dal.EmployeeRepository;
import com.dscomm.shop.data.po.Employee;
import com.dscomm.shop.data.po.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-shop-*.xml")
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
public class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void SaveEmployee(){
		Store store = new Store();
		store.setName("3号店");
		store.setAddress("乌鲁木齐北京路41号");
		store.setCall_number("18654214230");
		store.setManager_name("经理1");
		store.setStart_date(new Date());
		store.setDutyer_name("负责人1");
		store.setCoordinate("100000000,20000000");
		
		Employee employee = new Employee();
		employee.setIdcard_no("ID:1234567");
		employee.setName("张三");
		employee.setSalary(3000);
		employee.setSex(1);
		employee.setWorkno("NO:12345");
		employee.setStore(store);
		
		employeeRepo.save(employee);
	}

}
