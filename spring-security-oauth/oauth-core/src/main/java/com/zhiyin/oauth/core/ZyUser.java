package com.zhiyin.oauth.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
public class ZyUser extends User {

	private Long userId;


	public ZyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}


	public ZyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId ) {
		super(username, password,authorities);
		this.userId= userId;
	}

}
