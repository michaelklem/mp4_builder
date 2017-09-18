/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the shared_stories table.
 */
public class SharedStoriesPk implements Serializable
{
	protected long sharedStoryId;

	/** 
	 * This attribute represents whether the primitive attribute sharedStoryId is null.
	 */
	protected boolean sharedStoryIdNull;

	/** 
	 * Sets the value of sharedStoryId
	 */
	public void setSharedStoryId(long sharedStoryId)
	{
		this.sharedStoryId = sharedStoryId;
	}

	/** 
	 * Gets the value of sharedStoryId
	 */
	public long getSharedStoryId()
	{
		return sharedStoryId;
	}

	/**
	 * Method 'SharedStoriesPk'
	 * 
	 */
	public SharedStoriesPk()
	{
	}

	/**
	 * Method 'SharedStoriesPk'
	 * 
	 * @param sharedStoryId
	 */
	public SharedStoriesPk(final long sharedStoryId)
	{
		this.sharedStoryId = sharedStoryId;
	}

	/** 
	 * Sets the value of sharedStoryIdNull
	 */
	public void setSharedStoryIdNull(boolean sharedStoryIdNull)
	{
		this.sharedStoryIdNull = sharedStoryIdNull;
	}

	/** 
	 * Gets the value of sharedStoryIdNull
	 */
	public boolean isSharedStoryIdNull()
	{
		return sharedStoryIdNull;
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
		
		if (!(_other instanceof SharedStoriesPk)) {
			return false;
		}
		
		final SharedStoriesPk _cast = (SharedStoriesPk) _other;
		if (sharedStoryId != _cast.sharedStoryId) {
			return false;
		}
		
		if (sharedStoryIdNull != _cast.sharedStoryIdNull) {
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
		_hashCode = 29 * _hashCode + (int) (sharedStoryId ^ (sharedStoryId >>> 32));
		_hashCode = 29 * _hashCode + (sharedStoryIdNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.lbt.dto.SharedStoriesPk: " );
		ret.append( "sharedStoryId=" + sharedStoryId );
		return ret.toString();
	}

}
