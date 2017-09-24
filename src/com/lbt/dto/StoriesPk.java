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
 * This class represents the primary key of the stories table.
 */
public class StoriesPk implements Serializable
{
	protected long storyId;

	/** 
	 * This attribute represents whether the primitive attribute storyId is null.
	 */
	protected boolean storyIdNull;

	/** 
	 * Sets the value of storyId
	 */
	public void setStoryId(long storyId)
	{
		this.storyId = storyId;
	}

	/** 
	 * Gets the value of storyId
	 */
	public long getStoryId()
	{
		return storyId;
	}

	/**
	 * Method 'StoriesPk'
	 * 
	 */
	public StoriesPk()
	{
	}

	/**
	 * Method 'StoriesPk'
	 * 
	 * @param storyId
	 */
	public StoriesPk(final long storyId)
	{
		this.storyId = storyId;
	}

	/** 
	 * Sets the value of storyIdNull
	 */
	public void setStoryIdNull(boolean storyIdNull)
	{
		this.storyIdNull = storyIdNull;
	}

	/** 
	 * Gets the value of storyIdNull
	 */
	public boolean isStoryIdNull()
	{
		return storyIdNull;
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
		
		if (!(_other instanceof StoriesPk)) {
			return false;
		}
		
		final StoriesPk _cast = (StoriesPk) _other;
		if (storyId != _cast.storyId) {
			return false;
		}
		
		if (storyIdNull != _cast.storyIdNull) {
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
		_hashCode = 29 * _hashCode + (int) (storyId ^ (storyId >>> 32));
		_hashCode = 29 * _hashCode + (storyIdNull ? 1 : 0);
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
		ret.append( "com.lbt.dto.StoriesPk: " );
		ret.append( "storyId=" + storyId );
		return ret.toString();
	}

}