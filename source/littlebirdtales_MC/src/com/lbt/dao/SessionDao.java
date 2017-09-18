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

public interface SessionDao
{
	/** 
	 * Inserts a new row in the session table.
	 */
	public SessionPk insert(Session dto) throws SessionDaoException;

	/** 
	 * Updates a single row in the session table.
	 */
	public void update(SessionPk pk, Session dto) throws SessionDaoException;

	/** 
	 * Deletes a single row in the session table.
	 */
	public void delete(SessionPk pk) throws SessionDaoException;

	/** 
	 * Returns the rows from the session table that matches the specified primary-key value.
	 */
	public Session findByPrimaryKey(SessionPk pk) throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the criteria 'session_id = :sessionId'.
	 */
	public Session findByPrimaryKey(long sessionId) throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the criteria ''.
	 */
	public Session[] findAll() throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the criteria 'session_id = :sessionId'.
	 */
	public Session[] findWhereSessionIdEquals(long sessionId) throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the criteria 'php_session_id = :phpSessionId'.
	 */
	public Session[] findWherePhpSessionIdEquals(String phpSessionId) throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the criteria 'date_created = :dateCreated'.
	 */
	public Session[] findWhereDateCreatedEquals(Date dateCreated) throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the criteria 'date_modified = :dateModified'.
	 */
	public Session[] findWhereDateModifiedEquals(Date dateModified) throws SessionDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the session table that match the specified arbitrary SQL statement
	 */
	public Session[] findByDynamicSelect(String sql, Object[] sqlParams) throws SessionDaoException;

	/** 
	 * Returns all rows from the session table that match the specified arbitrary SQL statement
	 */
	public Session[] findByDynamicWhere(String sql, Object[] sqlParams) throws SessionDaoException;

}
