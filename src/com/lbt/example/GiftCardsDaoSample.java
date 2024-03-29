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
import com.lbt.dao.GiftCardsDao;
import com.lbt.dto.GiftCards;
import com.lbt.exceptions.GiftCardsDaoException;
import com.lbt.factory.GiftCardsDaoFactory;

public class GiftCardsDaoSample
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
		// findWhereGiftCardIdEquals(0);
		// findWhereOrderIdEquals("");
		// findWhereBuyerEmailEquals("");
		// findWhereDateCreatedEquals(null);
		// findWhereRedemptionCodeEquals("");
		// findWherePaidEquals(0);
		// findWhereDateExpiresEquals(null);
		// findWhereDateRedeemedEquals(null);
		// findWhereRedeemedByEquals(0);
		// findWhereGiftReceiverEquals("");
		// findWhereGiftSenderEquals("");
		// findWhereGiftMessageEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findAll();
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
	 * @param redeemedBy
	 */
	public static void findByUsers(long redeemedBy)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findByUsers(redeemedBy);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereGiftCardIdEquals'
	 * 
	 * @param giftCardId
	 */
	public static void findWhereGiftCardIdEquals(long giftCardId)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereGiftCardIdEquals(giftCardId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereOrderIdEquals'
	 * 
	 * @param orderId
	 */
	public static void findWhereOrderIdEquals(String orderId)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereOrderIdEquals(orderId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereBuyerEmailEquals'
	 * 
	 * @param buyerEmail
	 */
	public static void findWhereBuyerEmailEquals(String buyerEmail)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereBuyerEmailEquals(buyerEmail);
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
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereDateCreatedEquals(dateCreated);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereRedemptionCodeEquals'
	 * 
	 * @param redemptionCode
	 */
	public static void findWhereRedemptionCodeEquals(String redemptionCode)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereRedemptionCodeEquals(redemptionCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWherePaidEquals'
	 * 
	 * @param paid
	 */
	public static void findWherePaidEquals(short paid)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWherePaidEquals(paid);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateExpiresEquals'
	 * 
	 * @param dateExpires
	 */
	public static void findWhereDateExpiresEquals(Date dateExpires)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereDateExpiresEquals(dateExpires);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateRedeemedEquals'
	 * 
	 * @param dateRedeemed
	 */
	public static void findWhereDateRedeemedEquals(Date dateRedeemed)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereDateRedeemedEquals(dateRedeemed);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereRedeemedByEquals'
	 * 
	 * @param redeemedBy
	 */
	public static void findWhereRedeemedByEquals(long redeemedBy)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereRedeemedByEquals(redeemedBy);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereGiftReceiverEquals'
	 * 
	 * @param giftReceiver
	 */
	public static void findWhereGiftReceiverEquals(String giftReceiver)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereGiftReceiverEquals(giftReceiver);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereGiftSenderEquals'
	 * 
	 * @param giftSender
	 */
	public static void findWhereGiftSenderEquals(String giftSender)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereGiftSenderEquals(giftSender);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereGiftMessageEquals'
	 * 
	 * @param giftMessage
	 */
	public static void findWhereGiftMessageEquals(String giftMessage)
	{
		try {
			GiftCardsDao _dao = getGiftCardsDao();
			GiftCards _result[] = _dao.findWhereGiftMessageEquals(giftMessage);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getGiftCardsDao'
	 * 
	 * @return GiftCardsDao
	 */
	public static GiftCardsDao getGiftCardsDao()
	{
		return GiftCardsDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(GiftCards dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getGiftCardId() );
		buf.append( ", " );
		buf.append( dto.getOrderId() );
		buf.append( ", " );
		buf.append( dto.getBuyerEmail() );
		buf.append( ", " );
		buf.append( dto.getDateCreated() );
		buf.append( ", " );
		buf.append( dto.getRedemptionCode() );
		buf.append( ", " );
		buf.append( dto.getPaid() );
		buf.append( ", " );
		buf.append( dto.getDateExpires() );
		buf.append( ", " );
		buf.append( dto.getDateRedeemed() );
		buf.append( ", " );
		buf.append( dto.getRedeemedBy() );
		buf.append( ", " );
		buf.append( dto.getGiftReceiver() );
		buf.append( ", " );
		buf.append( dto.getGiftSender() );
		buf.append( ", " );
		buf.append( dto.getGiftMessage() );
		System.out.println( buf.toString() );
	}

}
