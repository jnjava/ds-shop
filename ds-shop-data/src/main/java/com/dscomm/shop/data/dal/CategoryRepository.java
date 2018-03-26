package com.dscomm.shop.data.dal;

import org.springframework.data.repository.CrudRepository;

import com.dscomm.shop.data.po.Category;

public interface CategoryRepository extends CrudRepository<Category,String>{

}
