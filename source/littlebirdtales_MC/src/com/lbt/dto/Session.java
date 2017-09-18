/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.dto;

import com.lbt.dao.*;
import com.lbt.factory.*;
import com.lbt.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class Session implements Serializable
{
	/** 
	 * This attribute maps to the column session_id in the session table.
	 */
	protected long sessionId;

	/** 
	 * This attribute maps to the column php_session_id in the session table.
	 */
	protected String phpSessionId;

	/** 
	 * This attribute maps to the column date_created in the session table.
	 */
	protected Date dateCreated;

	/** 
	 * This attribute maps to the column date_modified in the session table.
	 */
	protected Date dateModified;

	/**
	 * Method 'Session'
	 * 
	 */
	public Session()
	{
	}

	/**
	 * Method 'getSessionId'
	 * 
	 * @return long
	 */
	public long getSessionId()
	{
		return sessionId;
	}

	/**
	 * Method 'setSessionId'
	 * 
	 * @param sessionId
	 */
	public void setSessionId(long sessionId)
	{
		this.sessionId = sessionId;
	}

	/**
	 * Method 'getPhpSessionId'
	 * 
	 * @return String
	 */
	public String getPhpSessionId()
	{
		return phpSessionId;
	}

	/**
	 * Method 'setPhpSessionId'
	 * 
	 * @param phpSessionId
	 */
	public void setPhpSessionId(String phpSessionId)
	{
		this.phpSessionId = phpSessionId;
	}

	/**
	 * Method 'getDateCreated'
	 * 
	 * @return Date
	 */
	public Date getDateCreated()
	{
		return dateCreated;
	}

	/**
	 * Method 'setDateCreated'
	 * 
	 * @param dateCreated
	 */
	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	/**
	 * Method 'getDateModified'
	 * 
	 * @return Date
	 */
	public Date getDateModified()
	{
		return dateModified;
	}

	/**
	 * Method 'setDateModified'
	 * 
	 * @param dateModified
	 */
	public void setDateModified(Date dateModified)
	{
		this.dateModified = dateModified;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof Session)) {
			return false;
		}
		
		final Session _cast = (Session) _other;
		if (sessionId != _cast.sessionId) {
			return false;
		}
		
		if (phpSessionId == null ? _cast.phpSessionId != phpSessionId : !phpSessionId.equals( _cast.phpSessionId )) {
			return false;
		}
		
		if (dateCreated == null ? _cast.dateCreated != dateCreated : !dateCreated.equals( _cast.dateCreated )) {
			return false;
		}
		
		if (dateModified == null ? _cast.dateModified != dateModified : !dateModified.equals( _cast.dateModified )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + (int) (sessionId ^ (sessionId >>> 32));
		if (phpSessionId != null) {
			_hashCode = 29 * _hashCode + phpSessionId.hashCode();
		}
		
		if (dateCreated != null) {
			_hashCode = 29 * _hashCode + dateCreated.hashCode();
		}
		
		if (dateModified != null) {
			_hashCode = 29 * _hashCode + dateModified.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SessionPk
	 */
	public SessionPk createPk()
	{
		return new SessionPk(sessionId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.lbt.dto.Session: " );
		ret.append( "sessionId=" + sessionId );
		ret.append( ", phpSessionId=" + phpSessionId );
		ret.append( ", dateCreated=" + dateCreated );
		ret.append( ", dateModified=" + dateModified );
		return ret.toString();
	}

}
