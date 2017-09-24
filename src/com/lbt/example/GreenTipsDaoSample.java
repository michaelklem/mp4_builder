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
import com.lbt.dao.GreenTipsDao;
import com.lbt.dto.GreenTips;
import com.lbt.exceptions.GreenTipsDaoException;
import com.lbt.factory.GreenTipsDaoFactory;

public class GreenTipsDaoSample
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
		// findWhereTipIdEquals(0);
		// findWhereTipTextEquals("");
		// findWhereDateCreatedEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			GreenTipsDao _dao = getGreenTipsDao();
			GreenTips _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereTipIdEquals'
	 * 
	 * @param tipId
	 */
	public static void findWhereTipIdEquals(long tipId)
	{
		try {
			GreenTipsDao _dao = getGreenTipsDao();
			GreenTips _result[] = _dao.findWhereTipIdEquals(tipId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereTipTextEquals'
	 * 
	 * @param tipText
	 */
	public static void findWhereTipTextEquals(String tipText)
	{
		try {
			GreenTipsDao _dao = getGreenTipsDao();
			GreenTips _result[] = _dao.findWhereTipTextEquals(tipText);
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
			GreenTipsDao _dao = getGreenTipsDao();
			GreenTips _result[] = _dao.findWhereDateCreatedEquals(dateCreated);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getGreenTipsDao'
	 * 
	 * @return GreenTipsDao
	 */
	public static GreenTipsDao getGreenTipsDao()
	{
		return GreenTipsDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(GreenTips dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getTipId() );
		buf.append( ", " );
		buf.append( dto.getTipText() );
		buf.append( ", " );
		buf.append( dto.getDateCreated() );
		System.out.println( buf.toString() );
	}

}