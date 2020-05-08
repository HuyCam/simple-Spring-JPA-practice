package com.example.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_log")
public class UsersLog {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "log_id")
	private Integer id;
	
	private String log;
	
	@Column(name="user_id")
	private Integer userId;
	
	public UsersLog() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	
}
