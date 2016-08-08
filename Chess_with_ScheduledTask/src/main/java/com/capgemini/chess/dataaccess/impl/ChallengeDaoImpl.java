package com.capgemini.chess.dataaccess.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.ChallengeDao;
import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTo;
import com.capgemini.chess.service.to.IdAware;

/**
 * Implementation of challenge data access object
 * 
 * @author PPATRONI
 *
 */
@Service
public class ChallengeDaoImpl implements ChallengeDao {

	static Long challengeIds = new Long(0L);

	HashSet<ChallengeTo> challengeSet = new HashSet<ChallengeTo>();
	
	@Override
	public Collection<ChallengeTo> findAll() {
		return challengeSet;
	}

	@Override
	public ChallengeTo findChallengeById(long id) throws NoSuchElementException {
		for (ChallengeTo challengeTo : challengeSet) {
			if (challengeTo.getId() == id) {
				return challengeTo;
			}
		}
		return null;
	}

	@Override
	public Collection<ChallengeTo> findChallengesByPlayerId(long playerId) {
		return challengeSet
				.stream()
				.filter(p ->
					p.getFirstPlayerId() == playerId
					||
					p.getSecondPlayerId() == playerId)
				.collect(Collectors.toSet());
	}

	@Override
	public Collection<ChallengeTo> findChallengesByPlayersId(long firstPlayerId, long secondPlayerId) {
		return challengeSet
				.stream()
				.filter(p -> 
					(p.getFirstPlayerId() == firstPlayerId && p.getSecondPlayerId() == secondPlayerId) 
					|| 
					(p.getFirstPlayerId() == secondPlayerId && p.getSecondPlayerId() == firstPlayerId))
				.collect(Collectors.toSet());
	}

	@Override
	public IdAware save(IdAware idAware) {
		challengeSet.add((ChallengeTo)idAware);
		return idAware;
	}

	@Override
	public void delete(long id) {
		challengeSet.remove(findChallengeById(id));
	}
	
	@Override
	public void update(long id, ChallengeStatus status) {
		findChallengeById(id).setStatus(status);
	}

	@Override
	public Long getNextId() {
		return ++challengeIds;
	}

}
