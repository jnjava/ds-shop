package com.dscomm.shop.data.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name = "shop_goods_category")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class Category {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "icon_url", nullable = false, length = 200)
	private String icon_url;

	@Column(name = "parent_id", nullable = true, length = 50)
	private String parent_id;

	@Column(name = "sort_order", nullable = true)
	private int sort_order;

	@Column(name = "is_valid", nullable = true)
	private String is_valid;

	@Column(name = "store_id", nullable = true)
	private String store_id;

	// 一对多:集合Set
	/** 
     * OneToMany:一对多的配置 
     * mappedBy="order":指定由多的一方的order属性维护关联关系 
     * 
     */  
	@JsonIgnoreProperties(value = { "goods" })
	@OneToMany(cascade = { CascadeType.ALL},fetch=FetchType.LAZY,mappedBy = "category")
	private List<Goods> goods;

}
