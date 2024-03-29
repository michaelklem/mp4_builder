/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.dao;

import java.util.Date;
import com.lbt.dto.*;
import com.lbt.exceptions.*;

public interface CouponUsageDao
{
	/** 
	 * Inserts a new row in the coupon_usage table.
	 */
	public CouponUsagePk insert(CouponUsage dto) throws CouponUsageDaoException;

	/** 
	 * Updates a single row in the coupon_usage table.
	 */
	public void update(CouponUsagePk pk, CouponUsage dto) throws CouponUsageDaoException;

	/** 
	 * Deletes a single row in the coupon_usage table.
	 */
	public void delete(CouponUsagePk pk) throws CouponUsageDaoException;

	/** 
	 * Returns the rows from the coupon_usage table that matches the specified primary-key value.
	 */
	public CouponUsage findByPrimaryKey(CouponUsagePk pk) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'usage_id = :usageId'.
	 */
	public CouponUsage findByPrimaryKey(long usageId) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria ''.
	 */
	public CouponUsage[] findAll() throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'user_id = :userId'.
	 */
	public CouponUsage[] findByUsers(long userId) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'coupon_id = :couponId'.
	 */
	public CouponUsage[] findByCoupons(long couponId) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'usage_id = :usageId'.
	 */
	public CouponUsage[] findWhereUsageIdEquals(long usageId) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'user_id = :userId'.
	 */
	public CouponUsage[] findWhereUserIdEquals(long userId) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'coupon_id = :couponId'.
	 */
	public CouponUsage[] findWhereCouponIdEquals(long couponId) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the criteria 'date_used = :dateUsed'.
	 */
	public CouponUsage[] findWhereDateUsedEquals(Date dateUsed) throws CouponUsageDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the coupon_usage table that match the specified arbitrary SQL statement
	 */
	public CouponUsage[] findByDynamicSelect(String sql, Object[] sqlParams) throws CouponUsageDaoException;

	/** 
	 * Returns all rows from the coupon_usage table that match the specified arbitrary SQL statement
	 */
	public CouponUsage[] findByDynamicWhere(String sql, Object[] sqlParams) throws CouponUsageDaoException;

}
