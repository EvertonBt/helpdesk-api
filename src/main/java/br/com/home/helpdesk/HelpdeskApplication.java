package br.com.home.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.home.helpdesk.entity.ProfileEnum;
import br.com.home.helpdesk.entity.User;
import br.com.home.helpdesk.repository.UserRepository;

@SpringBootApplication
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}
	
	//esses dois métodos abaixo criam um usuário no banco logo na inicialicação
	 @Bean
	    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        return args -> {
	            initUsers(userRepository, passwordEncoder);
	        };

	    }
	    
		private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        User admin = new User();
	        admin.setEmail("admin@helpdesk.com");
	        admin.setPassword(passwordEncoder.encode("123456"));
	        admin.setProfile(ProfileEnum.ROLE_ADMIN);

	        User find = userRepository.findByEmail("admin@helpdesk.com");
	        if (find == null) {
	            userRepository.save(admin);
	        }
	    }
	
}
