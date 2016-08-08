package com.capgemini.chess.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.StatisticsDao;
import com.capgemini.chess.service.StatisticsService;
import com.capgemini.chess.service.to.StatisticsTo;

/**
 * Statistics management and life cycle coordination class
 * 
 * @author Pawel Patronik
 *
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	private StatisticsDao statisticsDao;
	
	@Override
	public StatisticsTo readUserStatistics(Long userId) {
		return statisticsDao.findStatisticsByUserId(userId);
	}
	
	@Override
	public Collection<StatisticsTo> readAllStatistics() {
		return statisticsDao.findAllStatistics();
	}
}
