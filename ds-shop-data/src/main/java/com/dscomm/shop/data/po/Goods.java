package com.dscomm.shop.data.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

@Data
@Entity
@Table(name = "shop_goods")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class Goods {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "goods_sn", nullable = true)
	private String goods_sn;

	@Column(name = "goods_category_id", nullable = true, length = 50)
	private String goods_category_id;

	@Column(name = "average_price", nullable = true)
	private double average_price;

	@Column(name = "retail_price", nullable = true)
	private double retail_price;

	@Column(name = "member_price", nullable = true)
	private double member_price;

	@Column(name = "reserve_price", nullable = true)
	private double reserve_price;

	@Column(name = "repertory", nullable = true)
	private int repertory;

	@Column(name = "goods_status", nullable = true)
	private int goods_status;

	@Column(name = "sort_index", nullable = true)
	private int sort_index;

	@Column(name = "shelflife", nullable = true)
	private int shelflife;

	@Column(name = "produce_date", nullable = true)
	private Date produce_date;

	@Column(name = "goods_pic", nullable = true)
	private String goods_pic;

	@Column(name = "remark", nullable = true)
	private String remark;

	@Column(name = "isvalid", nullable = true)
	private int isvalid;

	@Column(name = "score", nullable = true)
	private int score;

	@Column(name = "mark", nullable = true)
	private int mark;

	@Column(name = "store_id", nullable = true)
	private int store_id;

	@ManyToOne(optional = true)
	@JoinColumn(name = "goods_category_id")
	private Category category;
	
}
