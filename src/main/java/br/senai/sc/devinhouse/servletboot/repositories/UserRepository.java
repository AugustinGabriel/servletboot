package br.senai.sc.devinhouse.servletboot.repositories;

import br.senai.sc.devinhouse.servletboot.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {

	private int maxId = 1;

	private List<User> users = new ArrayList<>();

	public List<User> getAllUsers() {
		return this.users;
	}
	
	public User getUserById(int id) throws Exception {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new Exception("Usuário com id " + id + " não encontrado");
	}

	public User create(User user) {
		user.setId(maxId++);
		this.users.add(user);
		return user;
	}

	public User update(int id, User updatedUser) throws Exception {
		User currentUser = this.getUserById(id);
		currentUser.setName(updatedUser.getName());
		currentUser.setAge(updatedUser.getAge());
		return currentUser;
		
	}

	public void remove(int id) throws Exception {
		User currentUser = this.getUserById(id);
		users.remove(currentUser);
	}

}
