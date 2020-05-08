package com.example.springjpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {
	@Id
	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer salary;
	@Column(name = "team_name")
	private String teamName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName="user_id")
	private List<UsersLog> usersLogs;
	
	
	public Users() {
		
	}
	
	public List<UsersLog> getUsersLogs() {
		return usersLogs;
	}

	public void setUsersLogs(List<UsersLog> usersLogs) {
		this.usersLogs = usersLogs;
	}

	
		
	public Users(Integer id, String name, Integer salary, String teamName) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.teamName = teamName;
	}



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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}

