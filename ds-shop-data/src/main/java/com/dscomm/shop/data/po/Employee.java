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
@Table(name = "shop_employee")
@GenericGenerator(name="system-uuid",strategy="uuid")
public class Employee {

	@Id
	@GeneratedValue(generator="system-uuid")  	
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "sex", nullable = true)
	private int sex;
	
	@Column(name = "workno", nullable = true, length = 50)
	private String workno;
	
	@Column(name = "password", nullable = true, length = 50)
	private String password;
	
	@Column(name = "salary", nullable = true, length = 50)
	private double salary;
	
	@Column(name = "entry_date", nullable = true)
	private Date entry_date;
	
	@Column(name = "idcard_no", nullable = true, length = 200)
	private String idcard_no;
	
	@Column(name = "is_valid", nullable = true)
	private int isvalid;
	
	@JsonIgnoreProperties(value = { "store" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "store_id") 
	private Store store;
	
	@JsonIgnoreProperties(value = { "members" })
	@OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "employee")
	private List<Member> members;;
	
}
