package com.capgemini.chess.dataaccess.impl;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.StatisticsDao;
import com.capgemini.chess.service.to.StatisticsTo;

/**
 * Implementation of statistics data access object
 * 
 * @author PPATRONI
 *
 */
@Service
public class StatisticsDaoImpl implements StatisticsDao {

	HashSet<StatisticsTo> statisticsSet = new HashSet<StatisticsTo>();
	
	public Collection<StatisticsTo> findAllStatistics() {
		return statisticsSet;
	}
    
    public StatisticsTo findStatisticsByUserId(long id) {
    	return new StatisticsTo();
    }

    public StatisticsTo updateUserStatistics(StatisticsTo updatedStatistics) {
    	return new StatisticsTo();
    }
}
