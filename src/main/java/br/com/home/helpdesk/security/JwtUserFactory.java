package br.com.home.helpdesk.security;
	
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.home.helpdesk.entity.ProfileEnum;
import br.com.home.helpdesk.entity.User;
	
// converte nosso usuário num usuário reconhecido pelo spring secutiry
public class JwtUserFactory {
		 private JwtUserFactory() {
		    }

		 
		 //gerar um jwt user com base nos dados do usuário
		    public static JwtUser create(User user) {
		        return new JwtUser(
		                user.getId(),
		                user.getEmail(),
		                user.getPassword(),
		                mapToGrantedAuthorities(user.getProfile())
		        );
		    }

		    //converte o perfil do usuário para um formato utilizado pelo spring security
		    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		    		authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
		    		return   authorities ;
		    }

}