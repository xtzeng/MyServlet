package com.xt.model;

public class User { 
    private int id; 
    private String username; 
    private String password; 
     
    /*-- 三个属性的setter和getter略 --*/ 
     
    public User(){} 
     
    public User(int id, String username, String password) { 
        this.id = id; 
        this.username = username; 
        this.password = password; 
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
    
    
} 
