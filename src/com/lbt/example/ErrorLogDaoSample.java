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
import com.lbt.dao.ErrorLogDao;
import com.lbt.dto.ErrorLog;
import com.lbt.exceptions.ErrorLogDaoException;
import com.lbt.factory.ErrorLogDaoFactory;

public class ErrorLogDaoSample
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
		// findWhereIdEquals(0);
		// findWhereDescriptionEquals("");
		// findWhereStoryIdEquals(0);
		// findWhereDateCreatedEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			ErrorLogDao _dao = getErrorLogDao();
			ErrorLog _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdEquals'
	 * 
	 * @param id
	 */
	public static void findWhereIdEquals(long id)
	{
		try {
			ErrorLogDao _dao = getErrorLogDao();
			ErrorLog _result[] = _dao.findWhereIdEquals(id);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDescriptionEquals'
	 * 
	 * @param description
	 */
	public static void findWhereDescriptionEquals(String description)
	{
		try {
			ErrorLogDao _dao = getErrorLogDao();
			ErrorLog _result[] = _dao.findWhereDescriptionEquals(description);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStoryIdEquals'
	 * 
	 * @param storyId
	 */
	public static void findWhereStoryIdEquals(long storyId)
	{
		try {
			ErrorLogDao _dao = getErrorLogDao();
			ErrorLog _result[] = _dao.findWhereStoryIdEquals(storyId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateCreatedEquals'
	 * 
	 * @param dateCreated
	 */
	public static void findWhereDateCreatedEquals(Date dateCreated)
	{
		try {
			ErrorLogDao _dao = getErrorLogDao();
			ErrorLog _result[] = _dao.findWhereDateCreatedEquals(dateCreated);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getErrorLogDao'
	 * 
	 * @return ErrorLogDao
	 */
	public static ErrorLogDao getErrorLogDao()
	{
		return ErrorLogDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(ErrorLog dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getId() );
		buf.append( ", " );
		buf.append( dto.getDescription() );
		buf.append( ", " );
		buf.append( dto.getStoryId() );
		buf.append( ", " );
		buf.append( dto.getDateCreated() );
		System.out.println( buf.toString() );
	}

}
