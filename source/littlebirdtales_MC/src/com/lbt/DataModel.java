/**
 * 
 */
package com.lbt;

import java.awt.Stroke;
import java.util.Date;

import com.lbt.dao.ErrorLogDao;
import com.lbt.dao.StoriesDao;
import com.lbt.dao.StoryPagesDao;
import com.lbt.dto.ErrorLog;
import com.lbt.dto.Stories;
import com.lbt.dto.StoryPages;
import com.lbt.exceptions.ErrorLogDaoException;
import com.lbt.exceptions.StoriesDaoException;
import com.lbt.factory.ErrorLogDaoFactory;
import com.lbt.factory.StoriesDaoFactory;
import com.lbt.factory.StoryPagesDaoFactory;

/**
 * @author adil
 *
 */
public class DataModel {

	
	/**
	 * Method 'findWhereStoryIdEquals'
	 * 
	 * @param storyId
	 */
	public StoryPages[] findWhereStoryIdEquals(long storyId)
	{
		StoryPages _storyPages[] = null;
		try {
			StoryPagesDao _dao = getStoryPagesDao();
			StoryPages _result[] = _dao.findByDynamicWhere("story_id="+storyId + " ORDER BY page_num", null);
			for (int i=0; i<_result.length; i++ ) {
				displayStoryPages( _result[i] );
				
			}
			_storyPages = _result;
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		return _storyPages;
		
	}
	/**
	 * Method 'getStoryPagesDao'
	 * 
	 * @return StoryPagesDao
	 */
	public StoryPagesDao getStoryPagesDao()
	{
		return StoryPagesDaoFactory.create();
	}
	/**
	 * Method 'getNextStory'
	 * 
	 * @param dto
	 */
	public Stories getNextStory()
	{
			Stories _story = null;
			try {
				
				StoriesDao _dao = getStoriesDao();
				
				Stories _result[] = _dao.findByDynamicWhere("is_complied = 0 AND is_processing = 0 AND is_error=0 LIMIT 1", null);
				if (_result.length>0) {
					for (int i = 0; i < 1; i++) {
						displayStories(_result[i]);
						_story = _result[i];
					}
				}
			
			}
			catch (Exception _e) {
				_e.printStackTrace();
			
			
		}
		return _story;
			
	}
	/**
	 * Method 'findByUsers'
	 * 
	 * @param userId
	 */
	public Stories[] findByUsers(long userId)
	{
		Stories _result[] = null;
		try {
			StoriesDao _dao = getStoriesDao();
			_result = _dao.findByUsers(userId);
			for (int i=0; i<_result.length; i++ ) {
				displayStories( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		return _result;
	}
	/**
	 * Method 'findWhereStoryIdEquals'
	 * 
	 * @param storyId
	 */
	public Stories[] findByStoryId(long storyId)
	{
		Stories _result[] = null;
		try {
			StoriesDao _dao = getStoriesDao();
			_result = _dao.findWhereStoryIdEquals(storyId);
			for (int i=0; i<_result.length; i++ ) {
				displayStories( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		return _result;
	}
	public void startProcessing(Stories story)
	{
		StoriesDao _dao = StoriesDaoFactory.create();
		story.setIsProcessing((short)1);
		try {
			_dao.update(story.createPk(), story);
		} catch (StoriesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void videoCompiled(Stories story)
	{
		StoriesDao _dao = StoriesDaoFactory.create();
		story.setIsProcessing((short)0);
		story.setIsComplied((short)1);
		story.setDateComplied(new Date());
		try {
			_dao.update(story.createPk(), story);
		} catch (StoriesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void videoHasError(Stories story, String description)
	{
		ErrorLogDao _daoError = ErrorLogDaoFactory.create();
		StoriesDao _dao = StoriesDaoFactory.create();
		ErrorLog errorLog = new ErrorLog();
		story.setIsProcessing((short)0);
		story.setIsComplied((short)0);
		story.setIsError((short)1);
		errorLog.setDescription(description);
		errorLog.setStoryId(story.getStoryId());
		errorLog.setDateCreated(new Date());
		try {
		_dao.update(story.createPk(), story);
		} catch (StoriesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			_daoError.insert(errorLog);
		} catch (ErrorLogDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Method 'getStoriesDao'
	 * 
	 * @return StoriesDao
	 */
	public StoriesDao getStoriesDao()
	{
		return StoriesDaoFactory.create();
	}
	/**
	 * Method 'getErrorLogDao'
	 * 
	 * @return ErrorLogDao
	 */
	public static ErrorLogDao getErrorLogDao()
	{
		return ErrorLogDaoFactory.create();
	}
	/**
	 * Method 'displayStories'
	 * 
	 * @param dto
	 */
	public void displayStories(Stories dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getStoryId() );
		buf.append( ", " );
		buf.append( dto.getUserId() );
		buf.append( ", " );
		buf.append( dto.getTitle() );
		buf.append( ", " );
		buf.append( dto.getAuthor() );
		buf.append( ", " );
		buf.append( dto.getImagePath() );
		buf.append( ", " );
		buf.append( dto.getImagePathMed() );
		buf.append( ", " );
		buf.append( dto.getImagePathSml() );
		buf.append( ", " );
		buf.append( dto.getAPublic() );
		buf.append( ", " );
		buf.append( dto.getDateCreated() );
		buf.append( ", " );
		buf.append( dto.getDateModified() );
		buf.append( ", " );
		buf.append( dto.getContestRelated() );
		buf.append( ", " );
		buf.append( dto.getFeatured() );
		buf.append( ", " );
		buf.append( dto.getCraft() );
		buf.append( ", " );
		buf.append( dto.getUnsaved() );
		buf.append( ", " );
		buf.append( dto.getAudioPath() );
		buf.append( ", " );
		buf.append( dto.getIsProcessing() );
		buf.append( ", " );
		buf.append( dto.getIsComplied() );
		buf.append( ", " );
		buf.append( dto.getDateComplied() );
		buf.append( ", " );
		buf.append( dto.getIsError() );
		System.out.println( buf.toString() );
	}

	/**
	 * Method 'displayStoryPages'
	 * 
	 * @param dto
	 */
	public void displayStoryPages(StoryPages dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getStoryPageId() );
		buf.append( ", " );
		buf.append( dto.getStoryId() );
		buf.append( ", " );
		buf.append( dto.getBody() );
		buf.append( ", " );
		buf.append( dto.getPageNum() );
		buf.append( ", " );
		buf.append( dto.getImagePath() );
		buf.append( ", " );
		buf.append( dto.getImagePathMed() );
		buf.append( ", " );
		buf.append( dto.getImagePathSml() );
		buf.append( ", " );
		buf.append( dto.getAudioPath() );
		buf.append( ", " );
		buf.append( dto.getDateCreated() );
		buf.append( ", " );
		buf.append( dto.getDateModified() );
		buf.append( ", " );
		buf.append( dto.getUnsaved() );
		System.out.println( buf.toString() );
	}



}
