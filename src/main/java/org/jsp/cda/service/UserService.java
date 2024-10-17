package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService 
{

	ResponseEntity<?> login(AuthUser authUser);

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> findAllUsers();

}
