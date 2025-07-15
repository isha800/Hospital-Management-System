package com.Hospital.Management.System.dto;
import com.Hospital.Management.System.entity.User;

import java.time.LocalDateTime;
public class UserResponse {
	   private String name;
	    private String email;
	    private String role;
	    private String phone;
	    private String gender;
	    private String address;
	    private LocalDateTime createdAt;

	    public UserResponse(User user) {
	        this.name = user.getName();
	        this.email = user.getEmail();
	        this.role = user.getRole();
	        this.phone = user.getPhone();
	        this.gender = user.getGender();
	        this.address = user.getAddress();
	        this.createdAt = user.getCreatedAt();
	    }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getRole() { return role; }
	    public void setRole(String role) { this.role = role; }

	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }

	    public String getGender() { return gender; }
	    public void setGender(String gender) { this.gender = gender; }

	    public String getAddress() { return address; }
	    public void setAddress(String address) { this.address = address; }

	    public LocalDateTime getCreatedAt() { return createdAt; }
	    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
	}
	

