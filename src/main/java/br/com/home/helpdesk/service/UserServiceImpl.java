package br.com.home.helpdesk.service;

	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.home.helpdesk.entity.User;
import br.com.home.helpdesk.repository.UserRepository;

	@Service
	public class UserServiceImpl implements UserService {

		@Autowired
		private UserRepository userRepository;

		public User findByEmail(String email) {
			return this.userRepository.findByEmail(email);
		}

		public User createOrUpdate(User user) {
			return this.userRepository.save(user);
		}

		public Optional<User>findById(String id) {
			return this.userRepository.findById(id);
		}

		public void delete(String id) {
			this.userRepository.deleteById(id);
		}

		public Page<User> findAll(int page, int count) {
			Pageable pages = PageRequest.of(page, count);
			return this.userRepository.findAll(pages);
		}
	}

