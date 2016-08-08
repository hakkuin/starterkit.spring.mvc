package com.capgemini.chess.service;

import java.util.Collection;

import com.capgemini.chess.service.to.StatisticsTo;

/**
 * Interface for statistics service utility
 * 
 * @author PPATRONI
 *
 */
public interface StatisticsService {

	/**
	 * Reads statistics of user with given id
	 * 
	 * @param userId
	 * @return
	 */
	public StatisticsTo readUserStatistics(Long userId);

	/**
	 * Reads all statistics from database
	 * 
	 * @return
	 */
	public Collection<StatisticsTo> readAllStatistics();
}
