/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.jdbc;

import com.lbt.dao.*;
import com.lbt.factory.*;
import java.util.Date;
import com.lbt.dto.*;
import com.lbt.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class GiftCardsDaoImpl extends AbstractDAO implements GiftCardsDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT gift_card_id, order_id, buyer_email, date_created, redemption_code, paid, date_expires, date_redeemed, redeemed_by, gift_receiver, gift_sender, gift_message FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( gift_card_id, order_id, buyer_email, date_created, redemption_code, paid, date_expires, date_redeemed, redeemed_by, gift_receiver, gift_sender, gift_message ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET gift_card_id = ?, order_id = ?, buyer_email = ?, date_created = ?, redemption_code = ?, paid = ?, date_expires = ?, date_redeemed = ?, redeemed_by = ?, gift_receiver = ?, gift_sender = ?, gift_message = ? WHERE gift_card_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE gift_card_id = ?";

	/** 
	 * Index of column gift_card_id
	 */
	protected static final int COLUMN_GIFT_CARD_ID = 1;

	/** 
	 * Index of column order_id
	 */
	protected static final int COLUMN_ORDER_ID = 2;

	/** 
	 * Index of column buyer_email
	 */
	protected static final int COLUMN_BUYER_EMAIL = 3;

	/** 
	 * Index of column date_created
	 */
	protected static final int COLUMN_DATE_CREATED = 4;

	/** 
	 * Index of column redemption_code
	 */
	protected static final int COLUMN_REDEMPTION_CODE = 5;

	/** 
	 * Index of column paid
	 */
	protected static final int COLUMN_PAID = 6;

	/** 
	 * Index of column date_expires
	 */
	protected static final int COLUMN_DATE_EXPIRES = 7;

	/** 
	 * Index of column date_redeemed
	 */
	protected static final int COLUMN_DATE_REDEEMED = 8;

	/** 
	 * Index of column redeemed_by
	 */
	protected static final int COLUMN_REDEEMED_BY = 9;

	/** 
	 * Index of column gift_receiver
	 */
	protected static final int COLUMN_GIFT_RECEIVER = 10;

	/** 
	 * Index of column gift_sender
	 */
	protected static final int COLUMN_GIFT_SENDER = 11;

	/** 
	 * Index of column gift_message
	 */
	protected static final int COLUMN_GIFT_MESSAGE = 12;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 12;

	/** 
	 * Index of primary-key column gift_card_id
	 */
	protected static final int PK_COLUMN_GIFT_CARD_ID = 1;

	/** 
	 * Inserts a new row in the gift_cards table.
	 */
	public GiftCardsPk insert(GiftCards dto) throws GiftCardsDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setLong( index++, dto.getGiftCardId() );
			stmt.setString( index++, dto.getOrderId() );
			stmt.setString( index++, dto.getBuyerEmail() );
			stmt.setTimestamp(index++, dto.getDateCreated()==null ? null : new java.sql.Timestamp( dto.getDateCreated().getTime() ) );
			stmt.setString( index++, dto.getRedemptionCode() );
			stmt.setShort( index++, dto.getPaid() );
			stmt.setTimestamp(index++, dto.getDateExpires()==null ? null : new java.sql.Timestamp( dto.getDateExpires().getTime() ) );
			stmt.setTimestamp(index++, dto.getDateRedeemed()==null ? null : new java.sql.Timestamp( dto.getDateRedeemed().getTime() ) );
			if (dto.isRedeemedByNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setLong( index++, dto.getRedeemedBy() );
			}
		
			stmt.setString( index++, dto.getGiftReceiver() );
			stmt.setString( index++, dto.getGiftSender() );
			stmt.setString( index++, dto.getGiftMessage() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setGiftCardId( rs.getLong( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new GiftCardsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the gift_cards table.
	 */
	public void update(GiftCardsPk pk, GiftCards dto) throws GiftCardsDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setLong( index++, dto.getGiftCardId() );
			stmt.setString( index++, dto.getOrderId() );
			stmt.setString( index++, dto.getBuyerEmail() );
			stmt.setTimestamp(index++, dto.getDateCreated()==null ? null : new java.sql.Timestamp( dto.getDateCreated().getTime() ) );
			stmt.setString( index++, dto.getRedemptionCode() );
			stmt.setShort( index++, dto.getPaid() );
			stmt.setTimestamp(index++, dto.getDateExpires()==null ? null : new java.sql.Timestamp( dto.getDateExpires().getTime() ) );
			stmt.setTimestamp(index++, dto.getDateRedeemed()==null ? null : new java.sql.Timestamp( dto.getDateRedeemed().getTime() ) );
			if (dto.isRedeemedByNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setLong( index++, dto.getRedeemedBy() );
			}
		
			stmt.setString( index++, dto.getGiftReceiver() );
			stmt.setString( index++, dto.getGiftSender() );
			stmt.setString( index++, dto.getGiftMessage() );
			stmt.setLong( 13, pk.getGiftCardId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new GiftCardsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the gift_cards table.
	 */
	public void delete(GiftCardsPk pk) throws GiftCardsDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setLong( 1, pk.getGiftCardId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new GiftCardsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the gift_cards table that matches the specified primary-key value.
	 */
	public GiftCards findByPrimaryKey(GiftCardsPk pk) throws GiftCardsDaoException
	{
		return findByPrimaryKey( pk.getGiftCardId() );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'gift_card_id = :giftCardId'.
	 */
	public GiftCards findByPrimaryKey(long giftCardId) throws GiftCardsDaoException
	{
		GiftCards ret[] = findByDynamicSelect( SQL_SELECT + " WHERE gift_card_id = ?", new Object[] {  new Long(giftCardId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria ''.
	 */
	public GiftCards[] findAll() throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY gift_card_id", null );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'redeemed_by = :redeemedBy'.
	 */
	public GiftCards[] findByUsers(long redeemedBy) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE redeemed_by = ?", new Object[] {  new Long(redeemedBy) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'gift_card_id = :giftCardId'.
	 */
	public GiftCards[] findWhereGiftCardIdEquals(long giftCardId) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE gift_card_id = ? ORDER BY gift_card_id", new Object[] {  new Long(giftCardId) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'order_id = :orderId'.
	 */
	public GiftCards[] findWhereOrderIdEquals(String orderId) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE order_id = ? ORDER BY order_id", new Object[] { orderId } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'buyer_email = :buyerEmail'.
	 */
	public GiftCards[] findWhereBuyerEmailEquals(String buyerEmail) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE buyer_email = ? ORDER BY buyer_email", new Object[] { buyerEmail } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'date_created = :dateCreated'.
	 */
	public GiftCards[] findWhereDateCreatedEquals(Date dateCreated) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE date_created = ? ORDER BY date_created", new Object[] { dateCreated==null ? null : new java.sql.Timestamp( dateCreated.getTime() ) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'redemption_code = :redemptionCode'.
	 */
	public GiftCards[] findWhereRedemptionCodeEquals(String redemptionCode) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE redemption_code = ? ORDER BY redemption_code", new Object[] { redemptionCode } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'paid = :paid'.
	 */
	public GiftCards[] findWherePaidEquals(short paid) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE paid = ? ORDER BY paid", new Object[] {  new Short(paid) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'date_expires = :dateExpires'.
	 */
	public GiftCards[] findWhereDateExpiresEquals(Date dateExpires) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE date_expires = ? ORDER BY date_expires", new Object[] { dateExpires==null ? null : new java.sql.Timestamp( dateExpires.getTime() ) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'date_redeemed = :dateRedeemed'.
	 */
	public GiftCards[] findWhereDateRedeemedEquals(Date dateRedeemed) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE date_redeemed = ? ORDER BY date_redeemed", new Object[] { dateRedeemed==null ? null : new java.sql.Timestamp( dateRedeemed.getTime() ) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'redeemed_by = :redeemedBy'.
	 */
	public GiftCards[] findWhereRedeemedByEquals(long redeemedBy) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE redeemed_by = ? ORDER BY redeemed_by", new Object[] {  new Long(redeemedBy) } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'gift_receiver = :giftReceiver'.
	 */
	public GiftCards[] findWhereGiftReceiverEquals(String giftReceiver) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE gift_receiver = ? ORDER BY gift_receiver", new Object[] { giftReceiver } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'gift_sender = :giftSender'.
	 */
	public GiftCards[] findWhereGiftSenderEquals(String giftSender) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE gift_sender = ? ORDER BY gift_sender", new Object[] { giftSender } );
	}

	/** 
	 * Returns all rows from the gift_cards table that match the criteria 'gift_message = :giftMessage'.
	 */
	public GiftCards[] findWhereGiftMessageEquals(String giftMessage) throws GiftCardsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE gift_message = ? ORDER BY gift_message", new Object[] { giftMessage } );
	}

	/**
	 * Method 'GiftCardsDaoImpl'
	 * 
	 */
	public GiftCardsDaoImpl()
	{
	}

	/**
	 * Method 'GiftCardsDaoImpl'
	 * 
	 * @param userConn
	 */
	public GiftCardsDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "little_bird_tales.gift_cards";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected GiftCards fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			GiftCards dto = new GiftCards();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected GiftCards[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			GiftCards dto = new GiftCards();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		GiftCards ret[] = new GiftCards[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(GiftCards dto, ResultSet rs) throws SQLException
	{
		dto.setGiftCardId( rs.getLong( COLUMN_GIFT_CARD_ID ) );
		dto.setOrderId( rs.getString( COLUMN_ORDER_ID ) );
		dto.setBuyerEmail( rs.getString( COLUMN_BUYER_EMAIL ) );
		dto.setDateCreated( rs.getTimestamp(COLUMN_DATE_CREATED ) );
		dto.setRedemptionCode( rs.getString( COLUMN_REDEMPTION_CODE ) );
		dto.setPaid( rs.getShort( COLUMN_PAID ) );
		dto.setDateExpires( rs.getTimestamp(COLUMN_DATE_EXPIRES ) );
		dto.setDateRedeemed( rs.getTimestamp(COLUMN_DATE_REDEEMED ) );
		dto.setRedeemedBy( rs.getLong( COLUMN_REDEEMED_BY ) );
		if (rs.wasNull()) {
			dto.setRedeemedByNull( true );
		}
		
		dto.setGiftReceiver( rs.getString( COLUMN_GIFT_RECEIVER ) );
		dto.setGiftSender( rs.getString( COLUMN_GIFT_SENDER ) );
		dto.setGiftMessage( rs.getString( COLUMN_GIFT_MESSAGE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(GiftCards dto)
	{
	}

	/** 
	 * Returns all rows from the gift_cards table that match the specified arbitrary SQL statement
	 */
	public GiftCards[] findByDynamicSelect(String sql, Object[] sqlParams) throws GiftCardsDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new GiftCardsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the gift_cards table that match the specified arbitrary SQL statement
	 */
	public GiftCards[] findByDynamicWhere(String sql, Object[] sqlParams) throws GiftCardsDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new GiftCardsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
