package com.dscomm.shop.data.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

@Data
@Entity
@Table(name = "shop_goods_category")
public class Category {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
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
	@OneToMany(mappedBy = "goods_category_id", orphanRemoval = true)
	private Set<Goods> goods = new HashSet<Goods>();

}
