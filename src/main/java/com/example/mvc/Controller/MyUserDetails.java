package com.example.mvc.Controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.mvc.Model.Users;

public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	
	

	public MyUserDetails(Users user) {
		this.username=user.getUsername();
		System.out.println(username);
		this.password=user.getPassword();
		System.out.println(password);
		String activeAsString=user.getActive();
		if(activeAsString.equals("Y")) {
			this.active=true;
		}
		this.authorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
	
		return username;
	}
	
	  @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return active;
	    }

}
