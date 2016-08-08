package com.capgemini.chess.service;

import java.util.Collection;
import java.util.List;

import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTo;

/**
 * Interface for challenge service utility
 * 
 * @author PPATRONI
 *
 */
public interface ChallengeService {

	/**
	 * Service creates new challenge
	 * 
	 * @param firstPlayerId
	 * @param secondPlayerId
	 * @return transport object of newly created challenge 
	 */
	public ChallengeTo createChallenge(long firstPlayerId, long secondPlayerId);

	/**
	 * Service reads existing challenge from database by challenge id
	 * 
	 * @param id
	 * @return transport object of existing challenge
	 */
	public ChallengeTo readChallengeById(long id);

	/**
	 * Service reads existing challenges by player id
	 * 
	 * @param playerId
	 * @return collection of transport objects of challenges existing in database
	 */
	public Collection<ChallengeTo> readChallengesByPlayerId(long playerId);

	/**
	 * Service reads existing challenges by two players id
	 * 
	 * @param firstPlayerId
	 * @param secondPlayerId
	 * @return collection of transport objects of challenges existing in database
	 */
	public Collection<ChallengeTo> readChallengesByPlayersId(long firstPlayerId, long secondPlayerId);

	/**
	 * Service reads all challenges from database
	 * 
	 * @return collection of transport object of all challenges existing in database
	 */
	public Collection<ChallengeTo> readAllChallenges();
	
	/**
	 * Service reads all challenges older than given date
	 * 
	 * @param timeInMs
	 * @return
	 */
	public List<ChallengeTo> readAllChallengesOlderThan(int timeInMs);

	/**
	 * Service deletes a challenge of given id
	 * 
	 * @param id
	 */
	public void deleteChallenge(long id);

	/**
	 * Service updates challenge of given id with given status
	 * 
	 * @param id
	 * @param status
	 */
	public void updateChallenge(long id, ChallengeStatus status);

	/**
	 * Service clears the database
	 * 
	 * @param ids
	 */
	public void deleteAllChallenges(List<Long> ids);
}