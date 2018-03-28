package com.dscomm.shop.data.po;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "shop_member")
@GenericGenerator(name="system-uuid",strategy="uuid")
public class Member {

	@Id
	@GeneratedValue(generator="system-uuid")  	
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "grade", nullable = true)
	private int grade;
	
	@Column(name = "money", nullable = true, length = 50)
	private double money;
	
	@Column(name = "create_date", nullable = true)
	private Date create_date;
	
	@Column(name = "phone", nullable = true, length = 200)
	private String phone;
	
	@Column(name = "is_valid", nullable = true)
	private int isvalid;
	
	@JsonIgnoreProperties(value = { "store" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "store_id") 
	private Store store;
	
	
	@JsonIgnoreProperties(value = { "carts" })
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "member")
	private List<Cart> carts;
	

	@JsonIgnoreProperties(value = { "employee" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "employee_id") 
	private Employee employee;
}
