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

public class SessionParams implements Serializable
{
	/** 
	 * This attribute maps to the column session_param_id in the session_params table.
	 */
	protected long sessionParamId;

	/** 
	 * This attribute maps to the column session_id in the session_params table.
	 */
	protected long sessionId;

	/** 
	 * This attribute maps to the column param_name in the session_params table.
	 */
	protected String paramName;

	/** 
	 * This attribute maps to the column param_value in the session_params table.
	 */
	protected String paramValue;

	/**
	 * Method 'SessionParams'
	 * 
	 */
	public SessionParams()
	{
	}

	/**
	 * Method 'getSessionParamId'
	 * 
	 * @return long
	 */
	public long getSessionParamId()
	{
		return sessionParamId;
	}

	/**
	 * Method 'setSessionParamId'
	 * 
	 * @param sessionParamId
	 */
	public void setSessionParamId(long sessionParamId)
	{
		this.sessionParamId = sessionParamId;
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
	 * Method 'getParamName'
	 * 
	 * @return String
	 */
	public String getParamName()
	{
		return paramName;
	}

	/**
	 * Method 'setParamName'
	 * 
	 * @param paramName
	 */
	public void setParamName(String paramName)
	{
		this.paramName = paramName;
	}

	/**
	 * Method 'getParamValue'
	 * 
	 * @return String
	 */
	public String getParamValue()
	{
		return paramValue;
	}

	/**
	 * Method 'setParamValue'
	 * 
	 * @param paramValue
	 */
	public void setParamValue(String paramValue)
	{
		this.paramValue = paramValue;
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
		
		if (!(_other instanceof SessionParams)) {
			return false;
		}
		
		final SessionParams _cast = (SessionParams) _other;
		if (sessionParamId != _cast.sessionParamId) {
			return false;
		}
		
		if (sessionId != _cast.sessionId) {
			return false;
		}
		
		if (paramName == null ? _cast.paramName != paramName : !paramName.equals( _cast.paramName )) {
			return false;
		}
		
		if (paramValue == null ? _cast.paramValue != paramValue : !paramValue.equals( _cast.paramValue )) {
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
		_hashCode = 29 * _hashCode + (int) (sessionParamId ^ (sessionParamId >>> 32));
		_hashCode = 29 * _hashCode + (int) (sessionId ^ (sessionId >>> 32));
		if (paramName != null) {
			_hashCode = 29 * _hashCode + paramName.hashCode();
		}
		
		if (paramValue != null) {
			_hashCode = 29 * _hashCode + paramValue.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SessionParamsPk
	 */
	public SessionParamsPk createPk()
	{
		return new SessionParamsPk(sessionParamId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.lbt.dto.SessionParams: " );
		ret.append( "sessionParamId=" + sessionParamId );
		ret.append( ", sessionId=" + sessionId );
		ret.append( ", paramName=" + paramName );
		ret.append( ", paramValue=" + paramValue );
		return ret.toString();
	}

}