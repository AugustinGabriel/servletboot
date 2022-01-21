package br.senai.sc.devinhouse.servletboot.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sc.devinhouse.servletboot.models.User;
import br.senai.sc.devinhouse.servletboot.repositories.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private int maxId = 1;

	private List<User> users = new ArrayList<>();

	public List<User> findAll() {
		return this.users;
	}
	
	public User findById(int id) throws Exception {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new Exception("Usuário com id " + id + " não encontrado");
	}

	public User save(User user) {
		user.setId(maxId++);
		this.users.add(user);
		return user;
	}

	public User save(int id, User updatedUser) throws Exception {
		User currentUser = this.findById(id);
		currentUser.setName(updatedUser.getName());
		currentUser.setAge(updatedUser.getAge());
		currentUser.setCompany(updatedUser.getCompany());
		return currentUser;
	}

	public void delete(int id) throws Exception {
		User currentUser = this.findById(id);
		users.remove(currentUser);
	}

}
