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

public class History implements Serializable
{
	/** 
	 * This attribute maps to the column history_id in the history table.
	 */
	protected long historyId;

	/** 
	 * This attribute maps to the column session_id in the history table.
	 */
	protected long sessionId;

	/** 
	 * This attribute maps to the column page_controller in the history table.
	 */
	protected String pageController;

	/** 
	 * This attribute maps to the column page_action in the history table.
	 */
	protected String pageAction;

	/** 
	 * This attribute maps to the column page_params in the history table.
	 */
	protected String pageParams;

	/** 
	 * This attribute maps to the column page_title in the history table.
	 */
	protected String pageTitle;

	/** 
	 * This attribute maps to the column page_type in the history table.
	 */
	protected short pageType;

	/** 
	 * This attribute maps to the column referer in the history table.
	 */
	protected String referer;

	/** 
	 * This attribute maps to the column user_ip in the history table.
	 */
	protected String userIp;

	/** 
	 * This attribute maps to the column user_agent in the history table.
	 */
	protected String userAgent;

	/** 
	 * This attribute maps to the column date in the history table.
	 */
	protected Date date;

	/**
	 * Method 'History'
	 * 
	 */
	public History()
	{
	}

	/**
	 * Method 'getHistoryId'
	 * 
	 * @return long
	 */
	public long getHistoryId()
	{
		return historyId;
	}

	/**
	 * Method 'setHistoryId'
	 * 
	 * @param historyId
	 */
	public void setHistoryId(long historyId)
	{
		this.historyId = historyId;
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
	 * Method 'getPageController'
	 * 
	 * @return String
	 */
	public String getPageController()
	{
		return pageController;
	}

	/**
	 * Method 'setPageController'
	 * 
	 * @param pageController
	 */
	public void setPageController(String pageController)
	{
		this.pageController = pageController;
	}

	/**
	 * Method 'getPageAction'
	 * 
	 * @return String
	 */
	public String getPageAction()
	{
		return pageAction;
	}

	/**
	 * Method 'setPageAction'
	 * 
	 * @param pageAction
	 */
	public void setPageAction(String pageAction)
	{
		this.pageAction = pageAction;
	}

	/**
	 * Method 'getPageParams'
	 * 
	 * @return String
	 */
	public String getPageParams()
	{
		return pageParams;
	}

	/**
	 * Method 'setPageParams'
	 * 
	 * @param pageParams
	 */
	public void setPageParams(String pageParams)
	{
		this.pageParams = pageParams;
	}

	/**
	 * Method 'getPageTitle'
	 * 
	 * @return String
	 */
	public String getPageTitle()
	{
		return pageTitle;
	}

	/**
	 * Method 'setPageTitle'
	 * 
	 * @param pageTitle
	 */
	public void setPageTitle(String pageTitle)
	{
		this.pageTitle = pageTitle;
	}

	/**
	 * Method 'getPageType'
	 * 
	 * @return short
	 */
	public short getPageType()
	{
		return pageType;
	}

	/**
	 * Method 'setPageType'
	 * 
	 * @param pageType
	 */
	public void setPageType(short pageType)
	{
		this.pageType = pageType;
	}

	/**
	 * Method 'getReferer'
	 * 
	 * @return String
	 */
	public String getReferer()
	{
		return referer;
	}

	/**
	 * Method 'setReferer'
	 * 
	 * @param referer
	 */
	public void setReferer(String referer)
	{
		this.referer = referer;
	}

	/**
	 * Method 'getUserIp'
	 * 
	 * @return String
	 */
	public String getUserIp()
	{
		return userIp;
	}

	/**
	 * Method 'setUserIp'
	 * 
	 * @param userIp
	 */
	public void setUserIp(String userIp)
	{
		this.userIp = userIp;
	}

	/**
	 * Method 'getUserAgent'
	 * 
	 * @return String
	 */
	public String getUserAgent()
	{
		return userAgent;
	}

	/**
	 * Method 'setUserAgent'
	 * 
	 * @param userAgent
	 */
	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}

	/**
	 * Method 'getDate'
	 * 
	 * @return Date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * Method 'setDate'
	 * 
	 * @param date
	 */
	public void setDate(Date date)
	{
		this.date = date;
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
		
		if (!(_other instanceof History)) {
			return false;
		}
		
		final History _cast = (History) _other;
		if (historyId != _cast.historyId) {
			return false;
		}
		
		if (sessionId != _cast.sessionId) {
			return false;
		}
		
		if (pageController == null ? _cast.pageController != pageController : !pageController.equals( _cast.pageController )) {
			return false;
		}
		
		if (pageAction == null ? _cast.pageAction != pageAction : !pageAction.equals( _cast.pageAction )) {
			return false;
		}
		
		if (pageParams == null ? _cast.pageParams != pageParams : !pageParams.equals( _cast.pageParams )) {
			return false;
		}
		
		if (pageTitle == null ? _cast.pageTitle != pageTitle : !pageTitle.equals( _cast.pageTitle )) {
			return false;
		}
		
		if (pageType != _cast.pageType) {
			return false;
		}
		
		if (referer == null ? _cast.referer != referer : !referer.equals( _cast.referer )) {
			return false;
		}
		
		if (userIp == null ? _cast.userIp != userIp : !userIp.equals( _cast.userIp )) {
			return false;
		}
		
		if (userAgent == null ? _cast.userAgent != userAgent : !userAgent.equals( _cast.userAgent )) {
			return false;
		}
		
		if (date == null ? _cast.date != date : !date.equals( _cast.date )) {
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
		_hashCode = 29 * _hashCode + (int) (historyId ^ (historyId >>> 32));
		_hashCode = 29 * _hashCode + (int) (sessionId ^ (sessionId >>> 32));
		if (pageController != null) {
			_hashCode = 29 * _hashCode + pageController.hashCode();
		}
		
		if (pageAction != null) {
			_hashCode = 29 * _hashCode + pageAction.hashCode();
		}
		
		if (pageParams != null) {
			_hashCode = 29 * _hashCode + pageParams.hashCode();
		}
		
		if (pageTitle != null) {
			_hashCode = 29 * _hashCode + pageTitle.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) pageType;
		if (referer != null) {
			_hashCode = 29 * _hashCode + referer.hashCode();
		}
		
		if (userIp != null) {
			_hashCode = 29 * _hashCode + userIp.hashCode();
		}
		
		if (userAgent != null) {
			_hashCode = 29 * _hashCode + userAgent.hashCode();
		}
		
		if (date != null) {
			_hashCode = 29 * _hashCode + date.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return HistoryPk
	 */
	public HistoryPk createPk()
	{
		return new HistoryPk(historyId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.lbt.dto.History: " );
		ret.append( "historyId=" + historyId );
		ret.append( ", sessionId=" + sessionId );
		ret.append( ", pageController=" + pageController );
		ret.append( ", pageAction=" + pageAction );
		ret.append( ", pageParams=" + pageParams );
		ret.append( ", pageTitle=" + pageTitle );
		ret.append( ", pageType=" + pageType );
		ret.append( ", referer=" + referer );
		ret.append( ", userIp=" + userIp );
		ret.append( ", userAgent=" + userAgent );
		ret.append( ", date=" + date );
		return ret.toString();
	}

}