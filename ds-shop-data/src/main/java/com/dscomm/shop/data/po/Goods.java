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

	@Column(name = "is_vaild", nullable = true)
	private int isvalid;

	@Column(name = "score", nullable = true)
	private int score;

	@Column(name = "mark", nullable = true)
	private int mark;


	/** 
     * ManyToOne：多对一的配置 
     * cascade(级联)：all(所有)，merge(更新)，refresh(查询)，persistence(保存)，remove(删除) 
     * fetch: eager:立即加载  one的一方默认是立即加载 
     *            lazy:懒加载    many的一方默认是懒加载 
     * optional:是否可选,外键是否允许为空 
     * 
     * JoinColumn:指定外键名 
     * 
     */
	@JsonIgnoreProperties(value = { "category" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "goods_category_id") 
	private Category category;
	

	@JsonIgnoreProperties(value = { "store" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "store_id") 
	private Store store;
	
	
	@JsonIgnoreProperties(value = { "cartgoods" })
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "goods")
	private List<CartGoods> cartgoods;
	
}
