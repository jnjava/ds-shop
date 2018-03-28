package com.dscomm.shop.data.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shop_cart_goods")
public class CartGoods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1141437366078532986L;

	@Id
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "goods_id")
	private Goods goods;	
	
	@Column(name = "unit_price", nullable = true, length = 50)
	private double unit_price;
	
	@Column(name = "total_price", nullable = true, length = 50)
	private double total_price;
}
