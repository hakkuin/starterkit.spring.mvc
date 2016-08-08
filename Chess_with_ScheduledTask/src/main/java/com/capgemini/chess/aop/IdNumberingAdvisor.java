package com.capgemini.chess.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.capgemini.chess.dataaccess.ChallengeDao;
import com.capgemini.chess.dataaccess.UserDao;
import com.capgemini.chess.service.to.IdAware;

/**
 * Advisor for generating new numbers for newly created entities
 * 
 * @author PPATRONI
 *
 */
@Aspect
public class IdNumberingAdvisor {

	/**
	 * Sets id of challenge being saved to the database. Id argument is a next free id in the database.
	 * 
	 * @param joinPoint
	 * @param idAware
	 */
	@Before("execution(* com.capgemini.chess.dataaccess.ChallengeDao.save(..)) && args(idAware)")
	public void setNewChallengeId(JoinPoint joinPoint, IdAware idAware) {
		ChallengeDao o = (ChallengeDao) joinPoint.getThis();
		idAware.setId(o.getNextId());
	}

	/**
	 * Sets id of user being saved to the database. Id argument is a next free id in the database.
	 * 
	 * @param joinPoint
	 * @param idAware
	 */
	@Before("execution(* com.capgemini.chess.dataaccess.UserDao.createNewUser(..)) && args(idAware))")
	public void setNewUserId(JoinPoint joinPoint, IdAware idAware) {
		UserDao o = (UserDao) joinPoint.getThis();
		idAware.setId(o.getNextId());
	}
}
