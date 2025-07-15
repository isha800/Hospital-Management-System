package com.Hospital.Management.System.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
@Entity
@Table(name = "users")
public class User {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String email;
        private String name;
	    private String password;
	    private String role = "Admin";
	    private String phone;
	    private String gender;
	    private String address;

	    @CreationTimestamp
	    private LocalDateTime createdAt;

	    public User() {}

	    public User(Long id, String email, String name, String password, String role,
	                String phone, String gender, String address, LocalDateTime createdAt) {
	        this.id = id;
	        this.email = email;
	        this.name = name;
	        this.password = password;
	        this.role = role;
	        this.phone = phone;
	        this.gender = gender;
	        this.address = address;
	        this.createdAt = createdAt;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

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


