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
import com.lbt.dao.ContactsDao;
import com.lbt.dto.Contacts;
import com.lbt.exceptions.ContactsDaoException;
import com.lbt.factory.ContactsDaoFactory;

public class ContactsDaoSample
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
		// findByUsers(0);
		// findWhereContactIdEquals(0);
		// findWhereUserIdEquals(0);
		// findWhereNameEquals("");
		// findWhereEmailEquals("");
		// findWhereImagePathEquals("");
		// findWhereDateCreatedEquals(null);
		// findWhereDateModifiedEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByUsers'
	 * 
	 * @param userId
	 */
	public static void findByUsers(long userId)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findByUsers(userId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereContactIdEquals'
	 * 
	 * @param contactId
	 */
	public static void findWhereContactIdEquals(long contactId)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereContactIdEquals(contactId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserIdEquals'
	 * 
	 * @param userId
	 */
	public static void findWhereUserIdEquals(long userId)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereUserIdEquals(userId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNameEquals'
	 * 
	 * @param name
	 */
	public static void findWhereNameEquals(String name)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereNameEquals(name);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereEmailEquals'
	 * 
	 * @param email
	 */
	public static void findWhereEmailEquals(String email)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereEmailEquals(email);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereImagePathEquals'
	 * 
	 * @param imagePath
	 */
	public static void findWhereImagePathEquals(String imagePath)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereImagePathEquals(imagePath);
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
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereDateCreatedEquals(dateCreated);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateModifiedEquals'
	 * 
	 * @param dateModified
	 */
	public static void findWhereDateModifiedEquals(Date dateModified)
	{
		try {
			ContactsDao _dao = getContactsDao();
			Contacts _result[] = _dao.findWhereDateModifiedEquals(dateModified);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getContactsDao'
	 * 
	 * @return ContactsDao
	 */
	public static ContactsDao getContactsDao()
	{
		return ContactsDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Contacts dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getContactId() );
		buf.append( ", " );
		buf.append( dto.getUserId() );
		buf.append( ", " );
		buf.append( dto.getName() );
		buf.append( ", " );
		buf.append( dto.getEmail() );
		buf.append( ", " );
		buf.append( dto.getImagePath() );
		buf.append( ", " );
		buf.append( dto.getDateCreated() );
		buf.append( ", " );
		buf.append( dto.getDateModified() );
		System.out.println( buf.toString() );
	}

}