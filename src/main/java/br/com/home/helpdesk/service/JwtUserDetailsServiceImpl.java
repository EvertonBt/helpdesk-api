package br.com.home.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.home.helpdesk.entity.User;
import br.com.home.helpdesk.security.JwtUserFactory;

//classe para manipular a interface do User Detail
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	 @Autowired
	    private UserService userService;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	    		User user = userService.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
	        } else {
	            return JwtUserFactory.create(user);
	        }
	    }
	
}
