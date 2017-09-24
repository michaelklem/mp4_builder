/**
 * 
 */
package com.lbt;

import java.awt.Stroke;
import java.util.Date;

import com.lbt.dao.ErrorLogDao;
import com.lbt.dao.MP4FilesDao;
import com.lbt.dao.StoriesDao;
import com.lbt.dao.StoryPagesDao;
import com.lbt.dao.UsersDao;
import com.lbt.dto.ErrorLog;
import com.lbt.dto.MP4FilesPk;
import com.lbt.dto.Stories;
import com.lbt.dto.MP4Files;
import com.lbt.dto.StoryPages;
import com.lbt.exceptions.ErrorLogDaoException;
import com.lbt.exceptions.StoriesDaoException;
import com.lbt.exceptions.MP4FilesDaoException;
import com.lbt.factory.ErrorLogDaoFactory;
import com.lbt.factory.StoriesDaoFactory;
import com.lbt.factory.MP4FilesDaoFactory;
import com.lbt.factory.StoryPagesDaoFactory;
import com.lbt.factory.UsersDaoFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.List;


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
			StoryPages _result[] = _dao.findByDynamicWhere("story_id="+storyId + " and page_num > 0 ORDER BY page_num", null);
			System.out.println("XXXX story pages found " + _result);
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
	 * We are looking for the next story with these conditions:
	 * return first record where 
	 * process_as_mp4 = 1
	 * ordered by mp4_job_requested_date ascending
	 * 
	 * if is_processing = 1 then exit
	 * 
	 * @param dto
	 */
	public MP4Files getNextStory()
	{
		System.out.println("getNextStory");
		MP4Files _story = null;
			try {
				String bucket_name = "lbt.com";
				final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
				ObjectListing ol = s3.listObjects(bucket_name);
				List<S3ObjectSummary> objects = ol.getObjectSummaries();
				for (S3ObjectSummary os: objects) {
				    System.out.println("* " + os.getKey());
				}

				
				
				MP4FilesDao _dao = getMP4FilesDao();
				MP4Files _result[] = _dao.findByDynamicWhere("process_as_mp4 = 1 order by mp4_job_requested_date asc LIMIT 1", null);
				if (_result.length > 0) {
					// only processing 1 story then exiting
					MP4Files mp4File = (MP4Files)_result[0];

					StoriesDao _storyDao = getStoriesDao();
					Stories _storyResult[] = _storyDao.findWhereStoryIdEquals(mp4File.getStoryId());
					
					Stories story = null;
					if (_storyResult.length > 0)
					{
						story =(Stories)_storyResult[0];
						System.out.println("XXX story " + story);
						displayStories(story);
						mp4File.setStory(story);
						_story = mp4File;
					}
					else
					{
						// delete the bogus mp4 record
						MP4FilesPk pk = new MP4FilesPk(mp4File.getMp4Id());
						_dao.delete(pk);
					}
				}
			}
			catch (Exception _e) {
				System.out.println("FAIL" + _e.getMessage());
				_e.printStackTrace();
			}
		return _story;
	}

	public Stories getNextStory_orig()
	{
			Stories _story = null;
			try {
				
				StoriesDao _dao = getStoriesDao();
				Stories _result[] = _dao.findByDynamicWhere("process_as_mp4 = 1 order by mp4_job_requested_date asc LIMIT 1", null);
				if (_result.length>0) {
					// only processing 1 story then exiting
					Stories story = (Stories)_result[0];
					displayStories(story);
					_story = story;
				}
			}
			catch (Exception _e) {
				_e.printStackTrace();
			}
		return _story;
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
	public void videoCompiled(MP4Files story)
	{
		MP4FilesDao _dao = MP4FilesDaoFactory.create();
		story.setIsProcessing((short)0);
		story.setIsComplied((short)1);
		story.setDateComplied(new Date());
		story.setProcessAsMp4((short)0);
		story.setDateComplied(new Date());
		story.setMp4JobCompletedDate(new Date());
		
		Stories nextStory = story.getStory();
		story.setFilename(nextStory.getFilename());
		try {
			_dao.update(story.createPk(), story);
		} catch (MP4FilesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// if buyer_user_id == story->user_id
		// then set the process_as_mp4 flag for the story
		// this will prevent the user from re-issuing a story to be processed
		if (story.getBuyerUserId() == story.getStory().getUserId())
		{
			updateStoryRecord(story.getStory());
		}
	}

	private void updateStoryRecord(Stories story)
	{
		StoriesDao _dao = StoriesDaoFactory.create();
//		story.setIsProcessing((short)0);
//		story.setIsComplied((short)1);
//		story.setDateComplied(new Date());
		story.setProcessAsMp4((short)0);
//		story.setDateComplied(new Date());
		story.setMp4JobCompletedDate(new Date());
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
		story.setProcessAsMp4((short)0);
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

	public MP4FilesDao getMP4FilesDao()
	{
		return MP4FilesDaoFactory.create();
	}

	public UsersDao getUsersDao()
	{
		return UsersDaoFactory.create();
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
		buf.append( ", muted: " );
		buf.append( dto.getIsAudioMuted() );
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
		buf.append( ", muted:" );
		buf.append( dto.getIsAudioMuted() );
		System.out.println( buf.toString() );
	}



}
