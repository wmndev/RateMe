package com.eyooya.app.platform.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eyooya.app.platform.db.model.security.UserSecurity;
import com.eyooya.app.platform.db.repository.UserSecurityRepository;

@Component
public class MongoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserSecurityRepository userSecurityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        UserSecurity userSecurity = getUserDetail(username);
        
        return new User(userSecurity.getUsername(), 
        		userSecurity.getPassword(),
 			   enabled,
 			   accountNonExpired,
 			   credentialsNonExpired,
 			   accountNonLocked,
 			   getAuthorities(userSecurity.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(
			List<Integer> roles) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		
		for (int role : roles)
	       if (role == 1) {
	            authList.add(new SimpleGrantedAuthority("ROLE_BASIC"));

	        } else if (role == 2) {
	            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	        }
	        System.out.println(authList);
	        return authList;
	}

	private UserSecurity getUserDetail(String username) {
		return userSecurityRepository.findByUsername(username);
	}

}
