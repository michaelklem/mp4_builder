/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.factory;

import java.sql.Connection;
import com.lbt.dao.*;
import com.lbt.jdbc.*;

public class CouponUsageDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return CouponUsageDao
	 */
	public static CouponUsageDao create()
	{
		return new CouponUsageDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return CouponUsageDao
	 */
	public static CouponUsageDao create(Connection conn)
	{
		return new CouponUsageDaoImpl( conn );
	}

}
