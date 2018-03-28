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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "shop_cart")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class Cart {

	@Id
	@GeneratedValue(generator = "system-uuid")	
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "shopping_date", nullable = true)
	private Date shopping_date;


	@JsonIgnoreProperties(value = { "store" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "store_id") 
	private Store store;
	
	@JsonIgnoreProperties(value = { "employee" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "employee_id") 
	private Employee employee;
	
	@JsonIgnoreProperties(value = { "member" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "member_id") 
	private Member member;
	
	@JsonIgnoreProperties(value = { "cartgoods" })
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "cart")
	private List<CartGoods> cartgoods;
}
