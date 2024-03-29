/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import com.lbt.dao.SessionParamsDao;
import com.lbt.dto.SessionParams;
import com.lbt.exceptions.SessionParamsDaoException;
import com.lbt.factory.SessionParamsDaoFactory;

public class SessionParamsDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findBySession(0);
		// findWhereSessionParamIdEquals(0);
		// findWhereSessionIdEquals(0);
		// findWhereParamNameEquals("");
		// findWhereParamValueEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			SessionParamsDao _dao = getSessionParamsDao();
			SessionParams _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findBySession'
	 * 
	 * @param sessionId
	 */
	public static void findBySession(long sessionId)
	{
		try {
			SessionParamsDao _dao = getSessionParamsDao();
			SessionParams _result[] = _dao.findBySession(sessionId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSessionParamIdEquals'
	 * 
	 * @param sessionParamId
	 */
	public static void findWhereSessionParamIdEquals(long sessionParamId)
	{
		try {
			SessionParamsDao _dao = getSessionParamsDao();
			SessionParams _result[] = _dao.findWhereSessionParamIdEquals(sessionParamId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSessionIdEquals'
	 * 
	 * @param sessionId
	 */
	public static void findWhereSessionIdEquals(long sessionId)
	{
		try {
			SessionParamsDao _dao = getSessionParamsDao();
			SessionParams _result[] = _dao.findWhereSessionIdEquals(sessionId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereParamNameEquals'
	 * 
	 * @param paramName
	 */
	public static void findWhereParamNameEquals(String paramName)
	{
		try {
			SessionParamsDao _dao = getSessionParamsDao();
			SessionParams _result[] = _dao.findWhereParamNameEquals(paramName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereParamValueEquals'
	 * 
	 * @param paramValue
	 */
	public static void findWhereParamValueEquals(String paramValue)
	{
		try {
			SessionParamsDao _dao = getSessionParamsDao();
			SessionParams _result[] = _dao.findWhereParamValueEquals(paramValue);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getSessionParamsDao'
	 * 
	 * @return SessionParamsDao
	 */
	public static SessionParamsDao getSessionParamsDao()
	{
		return SessionParamsDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(SessionParams dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getSessionParamId() );
		buf.append( ", " );
		buf.append( dto.getSessionId() );
		buf.append( ", " );
		buf.append( dto.getParamName() );
		buf.append( ", " );
		buf.append( dto.getParamValue() );
		System.out.println( buf.toString() );
	}

}
