package com.sandhi.user.model;

public class User 
{
	private Integer id;
	private String name;
	private String email;
	private String phone;
	
	public User(int id,String name, String email, String phone) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	

	public User(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public User() 
	{
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
}
