package com.fer.librosViejos.client.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8779558128146955423L;
	
	private String id;
	private String name;
	private University university;
	private String email;
	private Date birth;
	private String gender;

	public User() {}
	
	public User init(String id, String name, String email, Date birth, String gender) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
				
		return this;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public University getUniversity() {
		return university;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}

	public void setUniversity(University univ) {
		this.university = univ;
	}
	
}
