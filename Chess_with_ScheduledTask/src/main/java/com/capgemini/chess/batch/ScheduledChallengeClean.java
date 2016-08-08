package com.capgemini.chess.batch;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.ChallengeService;

/**
 * Periodic cleaning of out dated challenges
 * 
 * @author PPATRONI
 *
 */
@Service
public class ScheduledChallengeClean {
	
	@Autowired
	private ChallengeService challengeService;
	
	private static final int SEVEN_DAYS_IN_MS = 604800000;
	private static final int SIX_HOURS_IN_MS = 21600000;
	
	/**
	 * Periodically removes out dated challenges from the database.
	 */
	@Scheduled(fixedRate = SIX_HOURS_IN_MS)
	public void removeOutdatedChallenges() {
		challengeService
				.deleteAllChallenges(challengeService
						.readAllChallengesOlderThan(SEVEN_DAYS_IN_MS)
								.stream()
								.map(w -> w.getId())
								.collect(Collectors.toList()));
	}
}