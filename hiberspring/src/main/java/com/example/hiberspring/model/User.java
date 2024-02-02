package com.example.hiberspring.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "app_user")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name = "password")
    @JsonIgnore
    @Getter
    private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable( name = "user_roles",
	 joinColumns = @JoinColumn(name = "user_id"),
	 inverseJoinColumns = @JoinColumn(name = "role_id"))
	 private Set<Role> roles = new HashSet<>();

	public User() {
		
	}

	public User(String username, String password, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	
	
}
