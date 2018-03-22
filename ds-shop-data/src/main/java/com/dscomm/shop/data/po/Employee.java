package com.dscomm.shop.data.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "shop_employee")
public class Employee {

	@Id
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "sex", nullable = true)
	private int sex;
	
	@Column(name = "workno", nullable = true, length = 50)
	private String workno;
	
	@Column(name = "password", nullable = true, length = 50)
	private String password;
	
	@Column(name = "salary", nullable = true, length = 50)
	private double salary;
	
	@Column(name = "entry_date", nullable = true)
	private Date entry_date;
	
	@Column(name = "idcard_no", nullable = true, length = 200)
	private String idcard_no;
	
	@Column(name = "isvalid", nullable = true)
	private int isvalid;
	
}
