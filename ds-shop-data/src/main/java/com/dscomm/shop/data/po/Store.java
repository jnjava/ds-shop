package com.dscomm.shop.data.po;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "shop_store")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class Store {

	@Id
	@GeneratedValue(generator = "system-uuid")	
	@Column(name = "id", nullable = false)
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

	// 一对多:集合Set
	/**
	 * OneToMany:一对多的配置 mappedBy="order":指定由多的一方的order属性维护关联关系
	 * 
	 */
	@JsonIgnoreProperties(value = { "goods" })
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "store")
	private List<Goods> goods;
	
	@JsonIgnoreProperties(value = { "employees" })
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "store")
	private List<Employee> employees;

}
