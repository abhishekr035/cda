package org.jsp.cda.serviceImpl;

import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionClasses.InvalidCredentialsException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.jsp.cda.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	
	@Override
	public ResponseEntity<?> login(AuthUser authUser) 
	{
		Optional<User> optional = userDao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());
		if (optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invalid username or password..").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Verification Successful.....").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> saveUser(User user) 
	{
		user.setStatus(UserStatus.IN_ACTIVE);		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User saved Successfully...!").body(userDao.saveUser(user)).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> optional = userDao.findUserById(id);
		if (optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invalid User Id..Unable to found.. ").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Found Successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Users Found Successfully...").body(userDao.findAllUsers()).build());
	}
}


