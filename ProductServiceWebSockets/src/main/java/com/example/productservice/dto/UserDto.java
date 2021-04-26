package com.example.productservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
	
	private Integer id;
	private String name;
	private Integer balance;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}