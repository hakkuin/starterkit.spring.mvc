package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.UserDao;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.UserProfileTo;

/**
 * User profile management and life cycle coordination class
 * 
 * @author Pawel Patronik
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserProfileTo readUser(Long id) {

		return userDao.findUserById(id);
	}

	@Override
	public UserProfileTo createUser(String login, String password, String email) {
		return (UserProfileTo) userDao.createNewUser(new UserProfileTo(login, password, email));
	}
}
