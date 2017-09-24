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

public class PaypalIpn implements Serializable
{
	/** 
	 * This attribute maps to the column paypal_ipn_id in the paypal_ipn table.
	 */
	protected long paypalIpnId;

	/** 
	 * This attribute maps to the column response in the paypal_ipn table.
	 */
	protected String response;

	/** 
	 * This attribute maps to the column txn_id in the paypal_ipn table.
	 */
	protected String txnId;

	/** 
	 * This attribute maps to the column txn_type in the paypal_ipn table.
	 */
	protected String txnType;

	/** 
	 * This attribute maps to the column payment_status in the paypal_ipn table.
	 */
	protected String paymentStatus;

	/** 
	 * This attribute maps to the column payment_amount in the paypal_ipn table.
	 */
	protected String paymentAmount;

	/** 
	 * This attribute maps to the column payer_email in the paypal_ipn table.
	 */
	protected String payerEmail;

	/** 
	 * This attribute maps to the column payment_date in the paypal_ipn table.
	 */
	protected Date paymentDate;

	/** 
	 * This attribute maps to the column ipn_date in the paypal_ipn table.
	 */
	protected Date ipnDate;

	/** 
	 * This attribute maps to the column keys in the paypal_ipn table.
	 */
	protected String keys;

	/** 
	 * This attribute maps to the column vals in the paypal_ipn table.
	 */
	protected String vals;

	/**
	 * Method 'PaypalIpn'
	 * 
	 */
	public PaypalIpn()
	{
	}

	/**
	 * Method 'getPaypalIpnId'
	 * 
	 * @return long
	 */
	public long getPaypalIpnId()
	{
		return paypalIpnId;
	}

	/**
	 * Method 'setPaypalIpnId'
	 * 
	 * @param paypalIpnId
	 */
	public void setPaypalIpnId(long paypalIpnId)
	{
		this.paypalIpnId = paypalIpnId;
	}

	/**
	 * Method 'getResponse'
	 * 
	 * @return String
	 */
	public String getResponse()
	{
		return response;
	}

	/**
	 * Method 'setResponse'
	 * 
	 * @param response
	 */
	public void setResponse(String response)
	{
		this.response = response;
	}

	/**
	 * Method 'getTxnId'
	 * 
	 * @return String
	 */
	public String getTxnId()
	{
		return txnId;
	}

	/**
	 * Method 'setTxnId'
	 * 
	 * @param txnId
	 */
	public void setTxnId(String txnId)
	{
		this.txnId = txnId;
	}

	/**
	 * Method 'getTxnType'
	 * 
	 * @return String
	 */
	public String getTxnType()
	{
		return txnType;
	}

	/**
	 * Method 'setTxnType'
	 * 
	 * @param txnType
	 */
	public void setTxnType(String txnType)
	{
		this.txnType = txnType;
	}

	/**
	 * Method 'getPaymentStatus'
	 * 
	 * @return String
	 */
	public String getPaymentStatus()
	{
		return paymentStatus;
	}

	/**
	 * Method 'setPaymentStatus'
	 * 
	 * @param paymentStatus
	 */
	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus = paymentStatus;
	}

	/**
	 * Method 'getPaymentAmount'
	 * 
	 * @return String
	 */
	public String getPaymentAmount()
	{
		return paymentAmount;
	}

	/**
	 * Method 'setPaymentAmount'
	 * 
	 * @param paymentAmount
	 */
	public void setPaymentAmount(String paymentAmount)
	{
		this.paymentAmount = paymentAmount;
	}

	/**
	 * Method 'getPayerEmail'
	 * 
	 * @return String
	 */
	public String getPayerEmail()
	{
		return payerEmail;
	}

	/**
	 * Method 'setPayerEmail'
	 * 
	 * @param payerEmail
	 */
	public void setPayerEmail(String payerEmail)
	{
		this.payerEmail = payerEmail;
	}

	/**
	 * Method 'getPaymentDate'
	 * 
	 * @return Date
	 */
	public Date getPaymentDate()
	{
		return paymentDate;
	}

	/**
	 * Method 'setPaymentDate'
	 * 
	 * @param paymentDate
	 */
	public void setPaymentDate(Date paymentDate)
	{
		this.paymentDate = paymentDate;
	}

	/**
	 * Method 'getIpnDate'
	 * 
	 * @return Date
	 */
	public Date getIpnDate()
	{
		return ipnDate;
	}

	/**
	 * Method 'setIpnDate'
	 * 
	 * @param ipnDate
	 */
	public void setIpnDate(Date ipnDate)
	{
		this.ipnDate = ipnDate;
	}

	/**
	 * Method 'getKeys'
	 * 
	 * @return String
	 */
	public String getKeys()
	{
		return keys;
	}

	/**
	 * Method 'setKeys'
	 * 
	 * @param keys
	 */
	public void setKeys(String keys)
	{
		this.keys = keys;
	}

	/**
	 * Method 'getVals'
	 * 
	 * @return String
	 */
	public String getVals()
	{
		return vals;
	}

	/**
	 * Method 'setVals'
	 * 
	 * @param vals
	 */
	public void setVals(String vals)
	{
		this.vals = vals;
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
		
		if (!(_other instanceof PaypalIpn)) {
			return false;
		}
		
		final PaypalIpn _cast = (PaypalIpn) _other;
		if (paypalIpnId != _cast.paypalIpnId) {
			return false;
		}
		
		if (response == null ? _cast.response != response : !response.equals( _cast.response )) {
			return false;
		}
		
		if (txnId == null ? _cast.txnId != txnId : !txnId.equals( _cast.txnId )) {
			return false;
		}
		
		if (txnType == null ? _cast.txnType != txnType : !txnType.equals( _cast.txnType )) {
			return false;
		}
		
		if (paymentStatus == null ? _cast.paymentStatus != paymentStatus : !paymentStatus.equals( _cast.paymentStatus )) {
			return false;
		}
		
		if (paymentAmount == null ? _cast.paymentAmount != paymentAmount : !paymentAmount.equals( _cast.paymentAmount )) {
			return false;
		}
		
		if (payerEmail == null ? _cast.payerEmail != payerEmail : !payerEmail.equals( _cast.payerEmail )) {
			return false;
		}
		
		if (paymentDate == null ? _cast.paymentDate != paymentDate : !paymentDate.equals( _cast.paymentDate )) {
			return false;
		}
		
		if (ipnDate == null ? _cast.ipnDate != ipnDate : !ipnDate.equals( _cast.ipnDate )) {
			return false;
		}
		
		if (keys == null ? _cast.keys != keys : !keys.equals( _cast.keys )) {
			return false;
		}
		
		if (vals == null ? _cast.vals != vals : !vals.equals( _cast.vals )) {
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
		if (response != null) {
			_hashCode = 29 * _hashCode + response.hashCode();
		}
		
		if (txnId != null) {
			_hashCode = 29 * _hashCode + txnId.hashCode();
		}
		
		if (txnType != null) {
			_hashCode = 29 * _hashCode + txnType.hashCode();
		}
		
		if (paymentStatus != null) {
			_hashCode = 29 * _hashCode + paymentStatus.hashCode();
		}
		
		if (paymentAmount != null) {
			_hashCode = 29 * _hashCode + paymentAmount.hashCode();
		}
		
		if (payerEmail != null) {
			_hashCode = 29 * _hashCode + payerEmail.hashCode();
		}
		
		if (paymentDate != null) {
			_hashCode = 29 * _hashCode + paymentDate.hashCode();
		}
		
		if (ipnDate != null) {
			_hashCode = 29 * _hashCode + ipnDate.hashCode();
		}
		
		if (keys != null) {
			_hashCode = 29 * _hashCode + keys.hashCode();
		}
		
		if (vals != null) {
			_hashCode = 29 * _hashCode + vals.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PaypalIpnPk
	 */
	public PaypalIpnPk createPk()
	{
		return new PaypalIpnPk(paypalIpnId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.lbt.dto.PaypalIpn: " );
		ret.append( "paypalIpnId=" + paypalIpnId );
		ret.append( ", response=" + response );
		ret.append( ", txnId=" + txnId );
		ret.append( ", txnType=" + txnType );
		ret.append( ", paymentStatus=" + paymentStatus );
		ret.append( ", paymentAmount=" + paymentAmount );
		ret.append( ", payerEmail=" + payerEmail );
		ret.append( ", paymentDate=" + paymentDate );
		ret.append( ", ipnDate=" + ipnDate );
		ret.append( ", keys=" + keys );
		ret.append( ", vals=" + vals );
		return ret.toString();
	}

}