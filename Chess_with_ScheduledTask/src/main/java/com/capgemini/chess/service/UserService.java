package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTo;

/**
 * Interface for user profile service utility
 * 
 * @author PPATRONI
 *
 */
public interface UserService {
	
	/**
	 * Reads user profile by given id
	 * 
	 * @param id
	 * @return
	 */
	public UserProfileTo readUser(Long id);

	/**
	 * Creates new player profile with given basic info
	 * 
	 * @param login
	 * @param password
	 * @param email
	 * @return
	 */
	public UserProfileTo createUser(String login, String password, String email);
}
