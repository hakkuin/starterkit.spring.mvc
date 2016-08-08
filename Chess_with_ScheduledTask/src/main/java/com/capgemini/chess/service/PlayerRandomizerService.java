package com.capgemini.chess.service;

import java.util.List;

import starterkit.chess.statistics.enums.Level;

/**
 * Randomizes player drawing for chess games
 * 
 * @author PPATRONI
 *
 */
public interface PlayerRandomizerService {
	
	/**
	 * Draws five players at random from list of all players who match given criteria:
	 * level-2 < level(player) < level+2
	 * 
	 * @param level
	 * @return
	 */
	public List<Long> drawFiveRandomPlayersAccordingToPlayerLevel(Level level);
	
}