package com.dscomm.shop.data.dal;

import org.springframework.data.repository.CrudRepository;

import com.dscomm.shop.data.po.Cart;

public interface CartRepository extends CrudRepository<Cart,String>{

}
