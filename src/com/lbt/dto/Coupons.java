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

public class Coupons implements Serializable
{
	/** 
	 * This attribute maps to the column coupon_id in the coupons table.
	 */
	protected long couponId;

	/** 
	 * This attribute maps to the column code in the coupons table.
	 */
	protected String code;

	/** 
	 * This attribute maps to the column paypal_url in the coupons table.
	 */
	protected String paypalUrl;

	/** 
	 * This attribute maps to the column description in the coupons table.
	 */
	protected String description;

	/** 
	 * This attribute maps to the column active in the coupons table.
	 */
	protected short active;

	/** 
	 * This attribute represents whether the primitive attribute active is null.
	 */
	protected boolean activeNull = true;

	/** 
	 * This attribute maps to the column from_date in the coupons table.
	 */
	protected Date fromDate;

	/** 
	 * This attribute maps to the column to_date in the coupons table.
	 */
	protected Date toDate;

	/** 
	 * This attribute maps to the column notes in the coupons table.
	 */
	protected String notes;

	/** 
	 * This attribute maps to the column subscription_years in the coupons table.
	 */
	protected short subscriptionYears;

	/** 
	 * This attribute represents whether the primitive attribute subscriptionYears is null.
	 */
	protected boolean subscriptionYearsNull = true;

	/**
	 * Method 'Coupons'
	 * 
	 */
	public Coupons()
	{
	}

	/**
	 * Method 'getCouponId'
	 * 
	 * @return long
	 */
	public long getCouponId()
	{
		return couponId;
	}

	/**
	 * Method 'setCouponId'
	 * 
	 * @param couponId
	 */
	public void setCouponId(long couponId)
	{
		this.couponId = couponId;
	}

	/**
	 * Method 'getCode'
	 * 
	 * @return String
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Method 'setCode'
	 * 
	 * @param code
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * Method 'getPaypalUrl'
	 * 
	 * @return String
	 */
	public String getPaypalUrl()
	{
		return paypalUrl;
	}

	/**
	 * Method 'setPaypalUrl'
	 * 
	 * @param paypalUrl
	 */
	public void setPaypalUrl(String paypalUrl)
	{
		this.paypalUrl = paypalUrl;
	}

	/**
	 * Method 'getDescription'
	 * 
	 * @return String
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Method 'setDescription'
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Method 'getActive'
	 * 
	 * @return short
	 */
	public short getActive()
	{
		return active;
	}

	/**
	 * Method 'setActive'
	 * 
	 * @param active
	 */
	public void setActive(short active)
	{
		this.active = active;
		this.activeNull = false;
	}

	/**
	 * Method 'setActiveNull'
	 * 
	 * @param value
	 */
	public void setActiveNull(boolean value)
	{
		this.activeNull = value;
	}

	/**
	 * Method 'isActiveNull'
	 * 
	 * @return boolean
	 */
	public boolean isActiveNull()
	{
		return activeNull;
	}

	/**
	 * Method 'getFromDate'
	 * 
	 * @return Date
	 */
	public Date getFromDate()
	{
		return fromDate;
	}

	/**
	 * Method 'setFromDate'
	 * 
	 * @param fromDate
	 */
	public void setFromDate(Date fromDate)
	{
		this.fromDate = fromDate;
	}

	/**
	 * Method 'getToDate'
	 * 
	 * @return Date
	 */
	public Date getToDate()
	{
		return toDate;
	}

	/**
	 * Method 'setToDate'
	 * 
	 * @param toDate
	 */
	public void setToDate(Date toDate)
	{
		this.toDate = toDate;
	}

	/**
	 * Method 'getNotes'
	 * 
	 * @return String
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * Method 'setNotes'
	 * 
	 * @param notes
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	/**
	 * Method 'getSubscriptionYears'
	 * 
	 * @return short
	 */
	public short getSubscriptionYears()
	{
		return subscriptionYears;
	}

	/**
	 * Method 'setSubscriptionYears'
	 * 
	 * @param subscriptionYears
	 */
	public void setSubscriptionYears(short subscriptionYears)
	{
		this.subscriptionYears = subscriptionYears;
		this.subscriptionYearsNull = false;
	}

	/**
	 * Method 'setSubscriptionYearsNull'
	 * 
	 * @param value
	 */
	public void setSubscriptionYearsNull(boolean value)
	{
		this.subscriptionYearsNull = value;
	}

	/**
	 * Method 'isSubscriptionYearsNull'
	 * 
	 * @return boolean
	 */
	public boolean isSubscriptionYearsNull()
	{
		return subscriptionYearsNull;
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
		
		if (!(_other instanceof Coupons)) {
			return false;
		}
		
		final Coupons _cast = (Coupons) _other;
		if (couponId != _cast.couponId) {
			return false;
		}
		
		if (code == null ? _cast.code != code : !code.equals( _cast.code )) {
			return false;
		}
		
		if (paypalUrl == null ? _cast.paypalUrl != paypalUrl : !paypalUrl.equals( _cast.paypalUrl )) {
			return false;
		}
		
		if (description == null ? _cast.description != description : !description.equals( _cast.description )) {
			return false;
		}
		
		if (active != _cast.active) {
			return false;
		}
		
		if (activeNull != _cast.activeNull) {
			return false;
		}
		
		if (fromDate == null ? _cast.fromDate != fromDate : !fromDate.equals( _cast.fromDate )) {
			return false;
		}
		
		if (toDate == null ? _cast.toDate != toDate : !toDate.equals( _cast.toDate )) {
			return false;
		}
		
		if (notes == null ? _cast.notes != notes : !notes.equals( _cast.notes )) {
			return false;
		}
		
		if (subscriptionYears != _cast.subscriptionYears) {
			return false;
		}
		
		if (subscriptionYearsNull != _cast.subscriptionYearsNull) {
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
		_hashCode = 29 * _hashCode + (int) (couponId ^ (couponId >>> 32));
		if (code != null) {
			_hashCode = 29 * _hashCode + code.hashCode();
		}
		
		if (paypalUrl != null) {
			_hashCode = 29 * _hashCode + paypalUrl.hashCode();
		}
		
		if (description != null) {
			_hashCode = 29 * _hashCode + description.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) active;
		_hashCode = 29 * _hashCode + (activeNull ? 1 : 0);
		if (fromDate != null) {
			_hashCode = 29 * _hashCode + fromDate.hashCode();
		}
		
		if (toDate != null) {
			_hashCode = 29 * _hashCode + toDate.hashCode();
		}
		
		if (notes != null) {
			_hashCode = 29 * _hashCode + notes.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) subscriptionYears;
		_hashCode = 29 * _hashCode + (subscriptionYearsNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return CouponsPk
	 */
	public CouponsPk createPk()
	{
		return new CouponsPk(couponId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.lbt.dto.Coupons: " );
		ret.append( "couponId=" + couponId );
		ret.append( ", code=" + code );
		ret.append( ", paypalUrl=" + paypalUrl );
		ret.append( ", description=" + description );
		ret.append( ", active=" + active );
		ret.append( ", fromDate=" + fromDate );
		ret.append( ", toDate=" + toDate );
		ret.append( ", notes=" + notes );
		ret.append( ", subscriptionYears=" + subscriptionYears );
		return ret.toString();
	}

}
