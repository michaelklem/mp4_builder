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
 * This class represents the primary key of the paypal_ipn table.
 */
public class PaypalIpnPk implements Serializable
{
	protected long paypalIpnId;

	/** 
	 * This attribute represents whether the primitive attribute paypalIpnId is null.
	 */
	protected boolean paypalIpnIdNull;

	/** 
	 * Sets the value of paypalIpnId
	 */
	public void setPaypalIpnId(long paypalIpnId)
	{
		this.paypalIpnId = paypalIpnId;
	}

	/** 
	 * Gets the value of paypalIpnId
	 */
	public long getPaypalIpnId()
	{
		return paypalIpnId;
	}

	/**
	 * Method 'PaypalIpnPk'
	 * 
	 */
	public PaypalIpnPk()
	{
	}

	/**
	 * Method 'PaypalIpnPk'
	 * 
	 * @param paypalIpnId
	 */
	public PaypalIpnPk(final long paypalIpnId)
	{
		this.paypalIpnId = paypalIpnId;
	}

	/** 
	 * Sets the value of paypalIpnIdNull
	 */
	public void setPaypalIpnIdNull(boolean paypalIpnIdNull)
	{
		this.paypalIpnIdNull = paypalIpnIdNull;
	}

	/** 
	 * Gets the value of paypalIpnIdNull
	 */
	public boolean isPaypalIpnIdNull()
	{
		return paypalIpnIdNull;
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
		
		if (!(_other instanceof PaypalIpnPk)) {
			return false;
		}
		
		final PaypalIpnPk _cast = (PaypalIpnPk) _other;
		if (paypalIpnId != _cast.paypalIpnId) {
			return false;
		}
		
		if (paypalIpnIdNull != _cast.paypalIpnIdNull) {
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
		_hashCode = 29 * _hashCode + (int) (paypalIpnId ^ (paypalIpnId >>> 32));
		_hashCode = 29 * _hashCode + (paypalIpnIdNull ? 1 : 0);
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
		ret.append( "com.lbt.dto.PaypalIpnPk: " );
		ret.append( "paypalIpnId=" + paypalIpnId );
		return ret.toString();
	}

}
