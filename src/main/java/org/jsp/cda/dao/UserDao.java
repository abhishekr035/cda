package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.User;

public interface UserDao 
{
	Optional<User> findByUsernameAndPassword(String username, String password);

	User saveUser(User user);

	List<User> findAllUsers();

	Optional<User> findUserById(int id);


}
