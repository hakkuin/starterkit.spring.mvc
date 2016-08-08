package com.capgemini.chess.dataaccess;

import java.util.Collection;

import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTo;
import com.capgemini.chess.service.to.IdAware;

/**
 * Challenge data access object interface
 * 
 * @author PPATRONI
 *
 */
public interface ChallengeDao {

	/**
	 * Finds all challenges from the database
	 * 
	 * @return
	 */
	public Collection<ChallengeTo> findAll();

    /**
     * Finds challenge with given id from the database
     * 
     * @param id
     * @return
     */
    public ChallengeTo findChallengeById(long id);
    
    /**
     * Finds all challenges with given player from the database
     * 
     * @param playerId
     * @return
     */
    public Collection<ChallengeTo> findChallengesByPlayerId(long playerId);
    
    /**
     * Finds all challenges with given two players from the database
     * 
     * @param firstPlayerId
     * @param secondPlayerId
     * @return
     */
    public Collection<ChallengeTo> findChallengesByPlayersId(long firstPlayerId, long secondPlayerId);

    /**
     * Saves a given id-aware challenge from the database
     * In case of null id, next id is provided by aspect before save
     * 
     * @param idAware
     * @return
     */
    public IdAware save(IdAware idAware);

    /**
     * Removes challenge of given id from the database
     * 
     * @param id
     */
    public void delete(long id);
    
    /**
     * Updates challenge of given id with given status
     * 
     * @param id
     * @param status
     */
    public void update(long id, ChallengeStatus status);
    
    /**
     * Id counter; provides next free id in the database 
     * 
     * @return 
     */
    public Long getNextId();
}
