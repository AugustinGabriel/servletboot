package br.senai.sc.devinhouse.servletboot.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senai.sc.devinhouse.servletboot.models.Company;
import br.senai.sc.devinhouse.servletboot.models.User;
import br.senai.sc.devinhouse.servletboot.repositories.CompanyRepository;
import br.senai.sc.devinhouse.servletboot.repositories.UserRepository;
import br.senai.sc.devinhouse.servletboot.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private CompanyRepository companyRepository;

	UserServiceImpl(UserRepository userRepository, CompanyRepository companyRepository) {
		this.userRepository = userRepository;
		this.companyRepository = companyRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(int id) throws Exception {
		return userRepository.findById(id);
	}

	public User create(User user) {
		try {
			Company company = companyRepository.findById(user.getCompany().getId());
			user.setCompany(company);
		} catch (Exception e) {
			user.setCompany(null);
		}
		return userRepository.save(user);
	}

	public User update(int id, User updatedUser) throws Exception {
		return userRepository.save(id, updatedUser);
	}

	public void remove(int id) throws Exception {
		userRepository.delete(id);
	}

}
