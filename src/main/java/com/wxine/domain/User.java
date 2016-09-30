package com.wxine.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String id;

	private char account;
	private String location;
	private char sax;
	private Integer age;
	private boolean isfriend;
	public User() {
	}
	public User(String id, char account, String location, char sax, Integer age, boolean isfriend) {
		this.id = id;
		this.account = account;
		this.location = location;
		this.sax = sax;
		this.age = age;
		this.isfriend = isfriend;
	}

	public boolean isIsfriend() {
		return isfriend;
	}
	public void setIsfriend(boolean isfriend) {
		this.isfriend = isfriend;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getAccount() {
		return account;
	}

	public void setAccount(char c) {
		this.account = c;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public char getSax() {
		return sax;
	}

	public void setSax(char c) {
		this.sax = c;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
