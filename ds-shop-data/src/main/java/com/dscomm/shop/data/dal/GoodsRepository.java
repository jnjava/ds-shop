package com.dscomm.shop.data.dal;

import org.springframework.data.repository.CrudRepository;

import com.dscomm.shop.data.po.Goods;

public interface GoodsRepository extends CrudRepository<Goods,String>{

}
