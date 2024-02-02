package com.example.hiberspring.payload.request;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {
@NotBlank
@Size(min=3, max=20)
	private String username;
	
private Set<String> role;

@NotBlank
 @Size(min = 6, max = 40)
 private String password;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public Set<String> getRole() {
	return role;
}

public void setRole(Set<String> role) {
	this.role = role;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
	
	
	
}
