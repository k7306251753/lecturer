 package com.lectures.demo.serviceImpl;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lectures.demo.exception.LecturerDublicateException;
import com.lectures.demo.model.LecturersE;
import com.lectures.demo.model.RolesE;
import com.lectures.demo.repositry.LectUserRepository;
import com.lectures.demo.service.NewLecturerService;





@Service
public class NewLecturerServiceImpl implements UserDetailsService {
@Autowired
private LectUserRepository lectUserRepository;
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException  {
		LecturersE user = null;
		try {
			user = lectUserRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        if(user==null) {
	        	throw new LecturerDublicateException("User not found with username or email:" + usernameOrEmail);
	        }
			
			 return new org.springframework.security.core.userdetails.User(user.getEmail(),
		                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
		}
	private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<RolesE> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}
