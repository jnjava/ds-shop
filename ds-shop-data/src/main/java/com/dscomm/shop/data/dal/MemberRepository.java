package com.dscomm.shop.data.dal;

import org.springframework.data.repository.CrudRepository;

import com.dscomm.shop.data.po.Member;

public interface MemberRepository extends CrudRepository<Member,String>{

}
