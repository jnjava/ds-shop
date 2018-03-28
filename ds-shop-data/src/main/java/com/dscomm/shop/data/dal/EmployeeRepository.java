package com.dscomm.shop.data.dal;

import org.springframework.data.repository.CrudRepository;

import com.dscomm.shop.data.po.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,String>{

}
