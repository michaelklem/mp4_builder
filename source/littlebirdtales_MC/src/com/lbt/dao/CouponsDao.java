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

public interface CouponsDao
{
	/** 
	 * Inserts a new row in the coupons table.
	 */
	public CouponsPk insert(Coupons dto) throws CouponsDaoException;

	/** 
	 * Updates a single row in the coupons table.
	 */
	public void update(CouponsPk pk, Coupons dto) throws CouponsDaoException;

	/** 
	 * Deletes a single row in the coupons table.
	 */
	public void delete(CouponsPk pk) throws CouponsDaoException;

	/** 
	 * Returns the rows from the coupons table that matches the specified primary-key value.
	 */
	public Coupons findByPrimaryKey(CouponsPk pk) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'coupon_id = :couponId'.
	 */
	public Coupons findByPrimaryKey(long couponId) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria ''.
	 */
	public Coupons[] findAll() throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'coupon_id = :couponId'.
	 */
	public Coupons[] findWhereCouponIdEquals(long couponId) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'code = :code'.
	 */
	public Coupons[] findWhereCodeEquals(String code) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'paypal_url = :paypalUrl'.
	 */
	public Coupons[] findWherePaypalUrlEquals(String paypalUrl) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'description = :description'.
	 */
	public Coupons[] findWhereDescriptionEquals(String description) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'active = :active'.
	 */
	public Coupons[] findWhereActiveEquals(short active) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'from_date = :fromDate'.
	 */
	public Coupons[] findWhereFromDateEquals(Date fromDate) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'to_date = :toDate'.
	 */
	public Coupons[] findWhereToDateEquals(Date toDate) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'notes = :notes'.
	 */
	public Coupons[] findWhereNotesEquals(String notes) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the criteria 'subscription_years = :subscriptionYears'.
	 */
	public Coupons[] findWhereSubscriptionYearsEquals(short subscriptionYears) throws CouponsDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the coupons table that match the specified arbitrary SQL statement
	 */
	public Coupons[] findByDynamicSelect(String sql, Object[] sqlParams) throws CouponsDaoException;

	/** 
	 * Returns all rows from the coupons table that match the specified arbitrary SQL statement
	 */
	public Coupons[] findByDynamicWhere(String sql, Object[] sqlParams) throws CouponsDaoException;

}
