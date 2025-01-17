package Invincibles.gestionrh.service;

import Invincibles.gestionrh.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Invincibles.gestionrh.model.Employe;
import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    EmployeRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Employe user = userRepository.findByUsername(username)
	      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	  return UserDetailsImpl.build(user);
	}
}
