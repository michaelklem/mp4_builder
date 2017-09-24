/**
 * 
 */
package com.lbt;

import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.red5.io.flv.impl.FLVReader;

import com.lbt.dto.MP4Files;
import com.lbt.dto.Stories;
import com.lbt.dto.StoryPages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author adil
 *
 */
public class Program {

	public static String directoryPrefix = "";
	public static String emptyAudio = "";
	public static String tempDirectoryPrefix = "";
	private static String storyDirectoryPrefix = "";
	private static String storyImagesDirectoryPrefix = "";
	private static String storyAudioDirectoryPrefix = "";
	private static String storyVideoDirectoryPrefix = "";
	public static String tempStoryDirectoryPrefix = "";
	public static String tempImagesDirectoryPrefix = "";
	public static String tempAudioDirectoryPrefix = "";
	public static String tempVideoDirectoryPrefix = "";
	public static String tempUserDirectoryPrefix = "";
	public static String firstImagePath = "";
	public static String lastImagePath = "";
	public static String textBG = "";
	public static String ffmpegPath = "";
	public static String ffmpegMergeCommandLine = "";
	public static String ffmpegBuildCommandLine = "";
	public static String defaultImagePath = "";
	public static ArrayList<String> audioFiles = new ArrayList<String>(); 
	
	// keeps track of all the image and audio files that have been merged
	public static ArrayList<String> combineMPGFiles = new ArrayList<String>();
	
	public static int imageCount = 0;
	public static int pageCounter = 0;
	public static boolean isProcessing = false;
	static DataModel dm = new DataModel();
	static ImageModel mm = new ImageModel();
	public static String propertiesFileName = "";
	public static String hostname = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
/*
		// Font info is obtained from the current graphics environment.
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		//--- Get an array of font names (smaller than the number of fonts)
		String[] fontNames = ge.getAvailableFontFamilyNames();
		for ( int a = 0; a< fontNames.length; a++)
		{
			
			System.out.println(fontNames[a]);
		}
*/
		if(args != null && args.length >1)
		{
			System.out.println(args[0]);
			if(args[0].equals("property_file"))
			{
				propertiesFileName = args[1];
			}
		}
		else	// default value if not specified
		{
			propertiesFileName = "littlebirdtale_en_US.properties";
		}
		System.out.println("XXX propertiesFileName " + propertiesFileName);
		CompileVideo();
	}

	public static void loadConfiguration()
	{
		File file = new File(Program.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println(file.getParent());
		Properties properties = new Properties() ;
		try {
			properties.load(new FileInputStream(file.getParent() + "/" + propertiesFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ffmpegPath = properties.getProperty("com.lbt.ffmpegpath");
		directoryPrefix = properties.getProperty("com.lbt.userdirectory");
		emptyAudio = properties.getProperty("com.lbt.emptyaudio");
		defaultImagePath = properties.getProperty("com.lbt.defaultimagepath");
		textBG = properties.getProperty("com.lbt.textbg");
		firstImagePath = properties.getProperty("com.lbt.firstimage");
		lastImagePath = properties.getProperty("com.lbt.lastimage");
		tempDirectoryPrefix = properties.getProperty("com.lbt.tempdirectory");
		com.lbt.jdbc.ResourceManager.JDBC_DRIVER = properties.getProperty("com.lbt.JDBC_DRIVER");
		com.lbt.jdbc.ResourceManager.JDBC_URL = properties.getProperty("com.lbt.JDBC_URL");
		com.lbt.jdbc.ResourceManager.JDBC_USER = properties.getProperty("com.lbt.JDBC_USER");
		com.lbt.jdbc.ResourceManager.JDBC_PASSWORD = properties.getProperty("com.lbt.JDBC_PASSWORD");
		hostname = properties.getProperty("com.lbt.host.name");
		ffmpegMergeCommandLine = properties.getProperty("ffmpeg.merge.commandline");
		ffmpegBuildCommandLine = properties.getProperty("ffmpeg.build.commandline");
	}
	public static void CompileVideo()
	{
		if (!isProcessing) {
			isProcessing = true;
			loadConfiguration();
			audioFiles.clear();
			imageCount = 0;
			pageCounter = 0;
			
			MP4Files mp4Files = dm.getNextStory();
			if (mp4Files == null) return;
			Stories nextStory = mp4Files.getStory();
			if (nextStory!=null) {
				try {
					System.out.println("xxxxxxxx Start MP4 compilation for " + nextStory.getStoryId() + " at " + new Date());
					dm.startProcessing(nextStory);
					String storyID = String.valueOf(nextStory.getStoryId());
					String userID = String.valueOf(nextStory.getUserId());
					setStoryDirectories(nextStory.getFullBucketPath());
					
					createDirectories(storyID, userID);

					// cover page + audio
					String image_file_name = tempImagesDirectoryPrefix + pageCounter + ".png";
					String audio_file_name = tempAudioDirectoryPrefix + pageCounter + ".flv";
					
					createImage(
							HTMLUtil.removeHTML(HtmlEntities.decode(nextStory.getTitle())),
							tempImagesDirectoryPrefix + "text" + pageCounter + ".png",
							storyImagesDirectoryPrefix + nextStory.getImagePath(),
							image_file_name);
					createAudioFile(
							storyAudioDirectoryPrefix + nextStory.getAudioPath(),
							audio_file_name);
					combineImageAndAudio(image_file_name, audio_file_name);


					StoryPages _storyPages[] = null;
					if (nextStory != null) {
						_storyPages = dm.findWhereStoryIdEquals(nextStory.getStoryId());
						
						if (_storyPages != null && _storyPages.length > 0){
							for (int i = 0; i < _storyPages.length; i++) {
								++pageCounter;
								
								image_file_name = tempImagesDirectoryPrefix + pageCounter + ".png";
								audio_file_name = tempAudioDirectoryPrefix + pageCounter + ".flv";

								createImage(
									HTMLUtil.removeHTML(_storyPages[i].getBody()),
									tempImagesDirectoryPrefix + "text" + pageCounter + ".png", 
									storyImagesDirectoryPrefix + _storyPages[i].getImagePath(),
									image_file_name);
								System.out.println("XXX page audio " + _storyPages[i].getAudioPath());
								createAudioFile(
									storyAudioDirectoryPrefix + _storyPages[i].getAudioPath(),
									audio_file_name);
								combineImageAndAudio(image_file_name, audio_file_name);	
							}
						}
						if ((new File(lastImagePath).exists())) {
							++pageCounter;
							audio_file_name = tempAudioDirectoryPrefix + pageCounter + ".flv";
							createAudioFile(null, audio_file_name);
							combineImageAndAudio(lastImagePath, audio_file_name);	
						}
					}

					// concatenate all image and audio mpg files into a single mpg file
					buildMP4( concatenateFiles(), nextStory );
					
					dm.videoCompiled(mp4Files);
					System.out.println("xxxxxxxx Completed MP4 compilation for " + nextStory.getStoryId() + " at " + new Date());
				} catch (Exception e) {
					dm.videoHasError(nextStory, getStackTrace(e));
				}
				
				// tell the web site that we are done
				sendMessageToWebSite(mp4Files.getMp4Id());
//				deleteDirectory(new File(tempUserDirectoryPrefix));
			}
		}
	}
	
	// creates an image of the story image and page text rendered as an image
	public static void createImage(String text,String textImage, String taleImage, String combineImage) throws IOException
	{
			mm.text = text;
			mm.textImage = textImage;
			mm.taleImage = taleImage;
			mm.textBG = textBG;
			mm.combineImage = combineImage;
			mm.TextOverlay();
			mm.CreateImage();
			System.out.println("createImage: text: " + text);
			System.out.println("createImage: textImage: " + textImage);
			System.out.println("createImage: taleImage: " + taleImage);
			System.out.println("createImage: combineImage: " + combineImage);
			
	}
	public static void createDirectories(String storyID,String userID)
	{
		tempUserDirectoryPrefix = tempDirectoryPrefix + userID +"/";
		tempStoryDirectoryPrefix = tempDirectoryPrefix + userID +"/" + storyID + "/";
		tempImagesDirectoryPrefix = tempStoryDirectoryPrefix + "images/";
		tempAudioDirectoryPrefix = tempStoryDirectoryPrefix + "audio/";
		tempVideoDirectoryPrefix = tempStoryDirectoryPrefix + "video/";
		deleteDirectory(new File(tempStoryDirectoryPrefix));
		boolean success = (new File(tempUserDirectoryPrefix)).mkdir();
		if (success) {
			System.out.println("Directory: " + tempUserDirectoryPrefix + " created");
		}
		success = (new File(tempStoryDirectoryPrefix)).mkdir();
		if (success) {
			System.out.println("Directory: " + tempStoryDirectoryPrefix + " created");
		}
		success = (new File(tempImagesDirectoryPrefix)).mkdir();
		if (success) {
			System.out.println("Directory: " + tempImagesDirectoryPrefix + " created");
		}
		success = (new File(tempAudioDirectoryPrefix)).mkdir();
		if (success) {
			System.out.println("Directory: " + tempAudioDirectoryPrefix + " created");
		}
		success = (new File(tempVideoDirectoryPrefix)).mkdir();
		if (success) {
			System.out.println("Directory: " + tempVideoDirectoryPrefix + " created");
		}
	}
	
	// expected to contain the user's directory bucket path + "/" + user id
	// example /a/b/c/e/12345
	public static void setStoryDirectories(String userBucketPath)
	{
		storyDirectoryPrefix = directoryPrefix + userBucketPath + "/";
		storyImagesDirectoryPrefix = storyDirectoryPrefix + "images/";
		storyAudioDirectoryPrefix = storyDirectoryPrefix + "audio/";
		storyVideoDirectoryPrefix = directoryPrefix + "video/"; // where the final output is stored
		boolean success = (new File(storyVideoDirectoryPrefix)).mkdir();
	    if (success) {
	      System.out.println("Directory: " + storyVideoDirectoryPrefix + " created");
	    }
	}
	public static void copyFile(File sourceFile, File destFile) throws IOException {
		
		 if(!destFile.exists()) {
		  destFile.createNewFile();
		 }
		 
		 FileChannel source = null;
		 FileChannel destination = null;
		 try {
		  source = new FileInputStream(sourceFile).getChannel();
		  destination = new FileOutputStream(destFile).getChannel();
		  destination.transferFrom(source, 0, source.size());
		 }
		 finally {
		  if(source != null) {
		   source.close();
		  }
		  if(destination != null) {
		   destination.close();
		  }
		}
	}

	/*
	 * calls ffmpeg and runs this command and stores the resulting file in tempVideoDirectoryPrefix
	 * ffmpeg -loop 1 -shortest -y -i image_file -i audio_file video/X.mpg
	 */
	public static void combineImageAndAudio(String image_file,String audio_file) throws IOException
	{
		System.out.println("combineImageAndAudio image "+ image_file);
		System.out.println("combineImageAndAudio audio "+ audio_file);
		String output_file = tempVideoDirectoryPrefix + pageCounter +".mpg";
		String command = ffmpegMergeCommandLine.replace("%image_file%", image_file);
		command = command.replace("%audio_file%", audio_file);
		command = ffmpegPath + " " + command.replace("%output_file%", output_file);

		try {
			System.out.println ("FFMPEG combineImageAndAudio ================ " + command);
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command );
			System.out.println(convertStreamToString(proc.getErrorStream()));
			combineMPGFiles.add(output_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	// iterate over all files in combineMPGFiles and cat them together
	public static String concatenateFiles() throws Exception
	{
		String output_filename = tempVideoDirectoryPrefix + "combined.mpg";

		StringBuffer buffer = new StringBuffer();
		for (int i=0; i < combineMPGFiles.size(); i++)
		{
			System.out.println("combining file " + combineMPGFiles.get(i));
			buffer.append(combineMPGFiles.get(i) + " ");
		}

		// http://www.linglom.com/2007/06/06/how-to-run-command-line-or-execute-external-application-from-java/
		String command = "/bin/cat " + buffer.toString() + " > " + output_filename;
		String[] cmd = {"/bin/bash","-c",command};

		try {
			System.out.println ("concatenateFiles command: " + command);
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmd);
			System.out.println(convertStreamToString(proc.getErrorStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return output_filename;
	}

	public static void buildMP4(String combined_mpg_files, Stories story) throws Exception
	{
		String filename = cleanFileName(story.getTitle());
		story.setFilename(filename);

		String output_file = storyVideoDirectoryPrefix + filename +".mp4 "; //tempVideoDirectoryPrefix + "final.mp4";
		String command = ffmpegBuildCommandLine.replace("%combined_mpg_files%", combined_mpg_files);
		command = ffmpegPath + " " + command.replace("%output_file%", output_file);

		try {
			System.out.println ("FFMPEG ================ " + command);
			System.out.println ("MP4 file can be found here ================ " + output_file);
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);
			System.out.println(convertStreamToString(proc.getErrorStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	// copies the audio file from its source to destination and renames with 
	// with a numeric name like '00001.flv'
	public static void createAudioFile(String sourcePath,String destPath) throws IOException
	{
		String destFileName = "";
		System.out.println("XXXXX createAudioFile " + sourcePath);		
		System.out.println("XXXXXX destPath " + destPath);		
		try {
			if (sourcePath == null 
				|| sourcePath == "" 
				|| sourcePath.endsWith("null") 
				|| ! sourcePath.endsWith(".flv"))
			{
				System.out.println("xxx emptyAudio: " + sourcePath);
				sourcePath = emptyAudio;
			}

			File srcFile = new File(sourcePath);
			File destFile = new File(destPath);
			copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public static String convertStreamToString(InputStream is)	throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
					}
			} 
			finally {
				is.close();
			}
			return writer.toString();
			} else {        
			return "";
		}
	}
	static public boolean deleteDirectory(File path) {
		if( path.exists() ) {
			File[] files = path.listFiles();
			for(int i=0; i<files.length; i++) {
				 if(files[i].isDirectory()) {
					 deleteDirectory(files[i]);
				 }
				 else {
					 files[i].delete();
				 }
			}
		}
		return( path.delete() );
	}
	 

	/**
	 * 
	 * 
	 * @param storyTitle
	 * @return String containing just alphanumeric characters and spaces converted to underscores
	 */
	public static String cleanFileName(String curStoryTitle)
	{
		return "littlebirdtales_movie-" + System.currentTimeMillis();

//		String storyTitle = StringEscapeUtils.unescapeHtml(curStoryTitle);
//		StringBuilder cleaned = new StringBuilder();
//		
//		char[] chars = storyTitle.trim().toLowerCase().toCharArray();
//		for (int i=0; i < chars.length; i++)
//		{
//			char tempChar = chars[i];
//			if (Character.isLetterOrDigit(tempChar))
//			{
//				cleaned.append(tempChar);
//			}
//			else if (Character.isWhitespace(tempChar) || tempChar == '-')
//			{
//				cleaned.append('_');
//			}
//		}
//		
//		// if the name is short or empty and a default name
//		if (cleaned.length() < 4)
//		{
//			cleaned.insert(0, "a_little_bird_tale_");
//		}
//		
//		// make the file name unique by appending the System.currentTimeMillis to the end
//		cleaned.append("-" + System.currentTimeMillis());
//		return cleaned.toString();
	}

	public static String getStackTrace(Throwable aThrowable) {
		    final Writer result = new StringWriter();
		    final PrintWriter printWriter = new PrintWriter(result);
		    aThrowable.printStackTrace(printWriter);
		    return result.toString();
		  }
	  static String stripLeadingAndTrailingQuotes(String str)
	  {
	      if (str.startsWith("\""))
	      {
	          str = str.substring(1, str.length());
	      }
	      if (str.endsWith(" \""))
	      {
	          str = str.substring(0, str.length() - 1);
	      }
	      return str;
	  }
		static void sendMessageToWebSite(long mp4FileId)
		{
			try {
				String url = "http://" + hostname + "/tales/mp4Completed/mp4file_id/" + mp4FileId;
				HttpClient httpclient = new HttpClient();
				PostMethod post = new PostMethod(url);
				int result = httpclient.executeMethod(post);
				System.out.println("Sending message to LBT site. Success: " + (result == 200 ? "true" : "false" ));		
			}
			catch(Exception ex )
			{
				ex.printStackTrace();
			}
		}

}
