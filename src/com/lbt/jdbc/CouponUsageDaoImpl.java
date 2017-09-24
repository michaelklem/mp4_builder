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

public class CouponUsageDaoImpl extends AbstractDAO implements CouponUsageDao
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
	protected final String SQL_SELECT = "SELECT usage_id, user_id, coupon_id, date_used FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( usage_id, user_id, coupon_id, date_used ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET usage_id = ?, user_id = ?, coupon_id = ?, date_used = ? WHERE usage_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE usage_id = ?";

	/** 
	 * Index of column usage_id
	 */
	protected static final int COLUMN_USAGE_ID = 1;

	/** 
	 * Index of column user_id
	 */
	protected static final int COLUMN_USER_ID = 2;

	/** 
	 * Index of column coupon_id
	 */
	protected static final int COLUMN_COUPON_ID = 3;

	/** 
	 * Index of column date_used
	 */
	protected static final int COLUMN_DATE_USED = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column usage_id
	 */
	protected static final int PK_COLUMN_USAGE_ID = 1;

	/** 
	 * Inserts a new row in the coupon_usage table.
	 */
	public CouponUsagePk insert(CouponUsage dto) throws CouponUsageDaoException
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
			stmt.setLong( index++, dto.getUsageId() );
			stmt.setLong( index++, dto.getUserId() );
			stmt.setLong( index++, dto.getCouponId() );
			stmt.setTimestamp(index++, dto.getDateUsed()==null ? null : new java.sql.Timestamp( dto.getDateUsed().getTime() ) );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setUsageId( rs.getLong( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CouponUsageDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the coupon_usage table.
	 */
	public void update(CouponUsagePk pk, CouponUsage dto) throws CouponUsageDaoException
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
			stmt.setLong( index++, dto.getUsageId() );
			stmt.setLong( index++, dto.getUserId() );
			stmt.setLong( index++, dto.getCouponId() );
			stmt.setTimestamp(index++, dto.getDateUsed()==null ? null : new java.sql.Timestamp( dto.getDateUsed().getTime() ) );
			stmt.setLong( 5, pk.getUsageId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CouponUsageDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the coupon_usage table.
	 */
	public void delete(CouponUsagePk pk) throws CouponUsageDaoException
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
			stmt.setLong( 1, pk.getUsageId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CouponUsageDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the coupon_usage table that matches the specified primary-key value.
	 */
	public CouponUsage findByPrimaryKey(CouponUsagePk pk) throws CouponUsageDaoException
	{
		return findByPrimaryKey( pk.getUsageId() );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'usage_id = :usageId'.
	 */
	public CouponUsage findByPrimaryKey(long usageId) throws CouponUsageDaoException
	{
		CouponUsage ret[] = findByDynamicSelect( SQL_SELECT + " WHERE usage_id = ?", new Object[] {  new Long(usageId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria ''.
	 */
	public CouponUsage[] findAll() throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY usage_id", null );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'user_id = :userId'.
	 */
	public CouponUsage[] findByUsers(long userId) throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE user_id = ?", new Object[] {  new Long(userId) } );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'coupon_id = :couponId'.
	 */
	public CouponUsage[] findByCoupons(long couponId) throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE coupon_id = ?", new Object[] {  new Long(couponId) } );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'usage_id = :usageId'.
	 */
	public CouponUsage[] findWhereUsageIdEquals(long usageId) throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE usage_id = ? ORDER BY usage_id", new Object[] {  new Long(usageId) } );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'user_id = :userId'.
	 */
	public CouponUsage[] findWhereUserIdEquals(long userId) throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE user_id = ? ORDER BY user_id", new Object[] {  new Long(userId) } );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'coupon_id = :couponId'.
	 */
	public CouponUsage[] findWhereCouponIdEquals(long couponId) throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE coupon_id = ? ORDER BY coupon_id", new Object[] {  new Long(couponId) } );
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'date_used = :dateUsed'.
	 */
	public CouponUsage[] findWhereDateUsedEquals(Date dateUsed) throws CouponUsageDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE date_used = ? ORDER BY date_used", new Object[] { dateUsed==null ? null : new java.sql.Timestamp( dateUsed.getTime() ) } );
	}

	/**
	 * Method 'CouponUsageDaoImpl'
	 * 
	 */
	public CouponUsageDaoImpl()
	{
	}

	/**
	 * Method 'CouponUsageDaoImpl'
	 * 
	 * @param userConn
	 */
	public CouponUsageDaoImpl(final java.sql.Connection userConn)
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
		return "little_bird_tales.coupon_usage";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected CouponUsage fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			CouponUsage dto = new CouponUsage();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected CouponUsage[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			CouponUsage dto = new CouponUsage();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		CouponUsage ret[] = new CouponUsage[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(CouponUsage dto, ResultSet rs) throws SQLException
	{
		dto.setUsageId( rs.getLong( COLUMN_USAGE_ID ) );
		dto.setUserId( rs.getLong( COLUMN_USER_ID ) );
		dto.setCouponId( rs.getLong( COLUMN_COUPON_ID ) );
		dto.setDateUsed( rs.getTimestamp(COLUMN_DATE_USED ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(CouponUsage dto)
	{
	}

	/** 
	 * Returns all rows from the coupon_usage table that match the specified arbitrary SQL statement
	 */
	public CouponUsage[] findByDynamicSelect(String sql, Object[] sqlParams) throws CouponUsageDaoException
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
			throw new CouponUsageDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the coupon_usage table that match the specified arbitrary SQL statement
	 */
	public CouponUsage[] findByDynamicWhere(String sql, Object[] sqlParams) throws CouponUsageDaoException
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
			throw new CouponUsageDaoException( "Exception: " + _e.getMessage(), _e );
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