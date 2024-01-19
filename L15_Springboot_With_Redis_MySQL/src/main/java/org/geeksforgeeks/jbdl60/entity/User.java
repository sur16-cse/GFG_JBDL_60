package org.geeksforgeeks.jbdl60.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User  implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String followers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFollowers() {
		return followers;
	}
	public void setFollowers(String followers) {
		this.followers = followers;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", followers=" + followers + "]";
	}
	public User(int id, String name, String followers) {
		super();
		this.id = id;
		this.name = name;
		this.followers = followers;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
