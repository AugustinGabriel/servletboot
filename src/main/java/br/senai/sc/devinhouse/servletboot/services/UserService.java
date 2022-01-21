package br.senai.sc.devinhouse.servletboot.services;

import br.senai.sc.devinhouse.servletboot.models.User;
import br.senai.sc.devinhouse.servletboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

	List<User> getAllUsers();
	
	User getUserById(int id) throws Exception;

	User create(User user);

	User update(int id, User updatedUser) throws Exception;

	void remove(int id) throws Exception;

}
