package br.senai.sc.devinhouse.servletboot.repositories;

import br.senai.sc.devinhouse.servletboot.models.User;

import java.util.List;

public interface UserRepository {

	List<User> findAll();

	User findById(int id) throws Exception;

	User save(User user);

	User save(int id, User updatedUser) throws Exception;

	void delete(int id) throws Exception;

}
