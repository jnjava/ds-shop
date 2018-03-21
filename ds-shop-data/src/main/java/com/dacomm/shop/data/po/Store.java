package com.dacomm.shop.data.po;

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
@Table(name = "shop_store")
public class Store {

	@Id
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "YHID", nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "address", nullable = false, length = 200)
	private String address;
	
	@Column(name = "coordinate", nullable = true, length = 50)
	private String coordinate;
	
	@Column(name = "dutyer_name", nullable = true, length = 50)
	private String dutyer_name;
	
	@Column(name = "manager_name", nullable = true, length = 50)
	private String manager_name;
	
	@Column(name = "start_date", nullable = true)
	private Date start_date;
	
	@Column(name = "log_url", nullable = true, length = 200)
	private String log_url;
	
	@Column(name = "call_number", nullable = true, length = 50)
	private String call_number;
	
}
