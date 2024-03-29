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

public class StoryPagesDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return StoryPagesDao
	 */
	public static StoryPagesDao create()
	{
		return new StoryPagesDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return StoryPagesDao
	 */
	public static StoryPagesDao create(Connection conn)
	{
		return new StoryPagesDaoImpl( conn );
	}

}
