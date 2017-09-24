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

public interface StoriesDao
{
	/** 
	 * Inserts a new row in the stories table.
	 */
	public StoriesPk insert(Stories dto) throws StoriesDaoException;

	/** 
	 * Updates a single row in the stories table.
	 */
	public void update(StoriesPk pk, Stories dto) throws StoriesDaoException;

	/** 
	 * Deletes a single row in the stories table.
	 */
	public void delete(StoriesPk pk) throws StoriesDaoException;

	/** 
	 * Returns the rows from the stories table that matches the specified primary-key value.
	 */
	public Stories findByPrimaryKey(StoriesPk pk) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'story_id = :storyId'.
	 */
	public Stories findByPrimaryKey(long storyId) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria ''.
	 */
	public Stories[] findAll() throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'user_id = :userId'.
	 */
	public Stories[] findByUsers(long userId) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'story_id = :storyId'.
	 */
	public Stories[] findWhereStoryIdEquals(long storyId) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'user_id = :userId'.
	 */
	public Stories[] findWhereUserIdEquals(long userId) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'title = :title'.
	 */
	public Stories[] findWhereTitleEquals(String title) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'author = :author'.
	 */
	public Stories[] findWhereAuthorEquals(String author) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'image_path = :imagePath'.
	 */
	public Stories[] findWhereImagePathEquals(String imagePath) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'image_path_med = :imagePathMed'.
	 */
	public Stories[] findWhereImagePathMedEquals(String imagePathMed) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'image_path_sml = :imagePathSml'.
	 */
	public Stories[] findWhereImagePathSmlEquals(String imagePathSml) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'public = :aPublic'.
	 */
	public Stories[] findWhereAPublicEquals(short aPublic) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'date_created = :dateCreated'.
	 */
	public Stories[] findWhereDateCreatedEquals(Date dateCreated) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'date_modified = :dateModified'.
	 */
	public Stories[] findWhereDateModifiedEquals(Date dateModified) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'contest_related = :contestRelated'.
	 */
	public Stories[] findWhereContestRelatedEquals(short contestRelated) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'featured = :featured'.
	 */
	public Stories[] findWhereFeaturedEquals(short featured) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'craft = :craft'.
	 */
	public Stories[] findWhereCraftEquals(short craft) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'unsaved = :unsaved'.
	 */
	public Stories[] findWhereUnsavedEquals(short unsaved) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'audio_path = :audioPath'.
	 */
	public Stories[] findWhereAudioPathEquals(String audioPath) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'is_processing = :isProcessing'.
	 */
	public Stories[] findWhereIsProcessingEquals(short isProcessing) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'is_complied = :isComplied'.
	 */
	public Stories[] findWhereIsCompliedEquals(short isComplied) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'is_error = :isError'.
	 */
	public Stories[] findWhereIsErrorEquals(short isError) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the criteria 'date_complied = :dateComplied'.
	 */
	public Stories[] findWhereDateCompliedEquals(Date dateComplied) throws StoriesDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the stories table that match the specified arbitrary SQL statement
	 */
	public Stories[] findByDynamicSelect(String sql, Object[] sqlParams) throws StoriesDaoException;

	/** 
	 * Returns all rows from the stories table that match the specified arbitrary SQL statement
	 */
	public Stories[] findByDynamicWhere(String sql, Object[] sqlParams) throws StoriesDaoException;

}
