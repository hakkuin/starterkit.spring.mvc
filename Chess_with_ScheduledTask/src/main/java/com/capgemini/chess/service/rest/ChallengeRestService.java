package com.capgemini.chess.service.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTo;

/**
 * Representational state transfer service for chess challenge
 * 
 * @author PPATRONI
 *
 */
@Controller
@ResponseBody
public class ChallengeRestService {
	
	@Autowired
	private ChallengeService challengeService;
	
	@RequestMapping(value = "/rest/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ChallengeTo>> test() {
		Collection<ChallengeTo> challengeTo = challengeService.readAllChallenges();
		return new ResponseEntity<Collection<ChallengeTo>>(challengeTo, HttpStatus.OK);
	}
	
	/**
	 * Get service for single challenge searched by challenge id 
	 * 
	 * @param challengeId
	 * @return challenge info
	 */
	@RequestMapping(value = "/rest/by-id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChallengeTo> getChallengeById(@RequestParam long challengeId) {
		ChallengeTo challengeTo = challengeService.readChallengeById(challengeId);
		return new ResponseEntity<ChallengeTo>(challengeTo, HttpStatus.OK);
	}
	
	/**
	 * Get service for challenges searched by one of players' id
	 * 
	 * @param playerId
	 * @return challenge list
	 */
	@RequestMapping(value = "/rest/by-one-player", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ChallengeTo>> getChallengeByOnePlayerId(@RequestParam long playerId) {
		Collection<ChallengeTo> challengeTo = challengeService.readChallengesByPlayerId(playerId);
		return new ResponseEntity<Collection<ChallengeTo>>(challengeTo, HttpStatus.OK);
	}
	
	/**
	 * Get service for challenges searched by both players' ids
	 * 
	 * @param firstPlayerId
	 * @param secondPlayerId
	 * @return challenge list
	 */
	@RequestMapping(value = "/rest/by-two-players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ChallengeTo>> getChallengeByTwoPlayersId(@RequestParam Long firstPlayerId, @RequestParam Long secondPlayerId) {
		Collection<ChallengeTo> challengeTo = challengeService.readChallengesByPlayersId(firstPlayerId, secondPlayerId);
		return new ResponseEntity<Collection<ChallengeTo>>(challengeTo, HttpStatus.OK);
	}
	
	/**
	 * Delete service for challenge searched by challenge id
	 * 
	 * @param challengeId
	 * @return http status confirmation
	 */
	@RequestMapping(value = "/rest/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus deleteChallenge(@RequestParam long challengeId) {
		if (challengeService.readChallengeById(challengeId) == null) {
			return HttpStatus.NOT_FOUND;
		}
		challengeService.deleteChallenge(challengeId);
		return HttpStatus.OK;
	}
	
	/**
	 * Add service for challenge /get
	 * 
	 * @param firstPlayerId
	 * @param secondPlayerId
	 * @return added challenge info with http confirmation
	 */
	@RequestMapping(value = "/rest/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChallengeTo> addNewChallengeForm() {
		return new ResponseEntity<ChallengeTo>(new ChallengeTo(), HttpStatus.OK);
	}
	
	/**
	 * Add service for challenge /post
	 * 
	 * @param firstPlayerId
	 * @param secondPlayerId
	 * @return added challenge info with http confirmation
	 */
	@RequestMapping(value = "/rest/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChallengeTo> addNewChallengePost(@RequestParam long firstPlayerId, @RequestParam long secondPlayerId) {
		ChallengeTo challengeTo = challengeService.createChallenge(firstPlayerId, secondPlayerId);
		return new ResponseEntity<ChallengeTo>(challengeTo, HttpStatus.OK);
	}
	
	/**
	 * Update service for challenge status
	 * 
	 * @param firstPlayerId
	 * @param secondPlayerId
	 * @return httpstatus
	 */
	@RequestMapping(value = "/rest/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChallengeTo> updateChallengeStatus(@RequestParam long challengeId, @RequestParam ChallengeStatus status) {
/*		if (challengeService.readChallengeById(challengeId) == null) {
			return HttpStatus.NOT_FOUND;
		}*/
		ChallengeTo challengeTo = challengeService.readChallengeById(challengeId);
		challengeTo.setStatus(status);
		return new ResponseEntity<ChallengeTo>(challengeTo, HttpStatus.OK);
	}
}
