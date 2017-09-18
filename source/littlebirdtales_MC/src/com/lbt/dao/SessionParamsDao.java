/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.lbt.dao;

import com.lbt.dto.*;
import com.lbt.exceptions.*;

public interface SessionParamsDao
{
	/** 
	 * Inserts a new row in the session_params table.
	 */
	public SessionParamsPk insert(SessionParams dto) throws SessionParamsDaoException;

	/** 
	 * Updates a single row in the session_params table.
	 */
	public void update(SessionParamsPk pk, SessionParams dto) throws SessionParamsDaoException;

	/** 
	 * Deletes a single row in the session_params table.
	 */
	public void delete(SessionParamsPk pk) throws SessionParamsDaoException;

	/** 
	 * Returns the rows from the session_params table that matches the specified primary-key value.
	 */
	public SessionParams findByPrimaryKey(SessionParamsPk pk) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria 'session_param_id = :sessionParamId'.
	 */
	public SessionParams findByPrimaryKey(long sessionParamId) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria ''.
	 */
	public SessionParams[] findAll() throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria 'session_id = :sessionId'.
	 */
	public SessionParams[] findBySession(long sessionId) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria 'session_param_id = :sessionParamId'.
	 */
	public SessionParams[] findWhereSessionParamIdEquals(long sessionParamId) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria 'session_id = :sessionId'.
	 */
	public SessionParams[] findWhereSessionIdEquals(long sessionId) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria 'param_name = :paramName'.
	 */
	public SessionParams[] findWhereParamNameEquals(String paramName) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the criteria 'param_value = :paramValue'.
	 */
	public SessionParams[] findWhereParamValueEquals(String paramValue) throws SessionParamsDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the session_params table that match the specified arbitrary SQL statement
	 */
	public SessionParams[] findByDynamicSelect(String sql, Object[] sqlParams) throws SessionParamsDaoException;

	/** 
	 * Returns all rows from the session_params table that match the specified arbitrary SQL statement
	 */
	public SessionParams[] findByDynamicWhere(String sql, Object[] sqlParams) throws SessionParamsDaoException;

}
