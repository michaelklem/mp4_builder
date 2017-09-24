/**
 * 
 */
package com.lbt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.red5.io.flv.impl.FLVReader;

import com.lbt.dto.Stories;
import com.lbt.dto.StoryPages;

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
	public static String tempUserDirectoryPrefix = "";
	public static String firstImagePath = "";
	public static String lastImagePath = "";
	public static String textBG = "";
	public static String ffmpegPath = "";
	public static String mp4BoxPath = "";
	public static String flvBindPath = "";
	public static String defaultImagePath = "";
	public static ArrayList<String> audioFiles = new ArrayList<String>(); 
	public static int imageCount = 0;
	public static boolean isProcessing = false;
	static DataModel dm = new DataModel();
	static ImageModel mm = new ImageModel();
	static Timer timer = null;
	static long duration = 0;
	static TimerTask timertask = null; 
	private static ServerSocket SERVER_SOCKET;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ffmpegTest();
		//timer = new Timer();
		//timertask = new TimerTask() {
			
		//	@Override
			///public void run() {
			loadConfiguration();
			// createIntance();
			try {
				if(args != null && args.length >1)
				{
					System.out.println(args[0]);
					if(args[0].equals("userid"))
					{
				   	CompileUserVideos(Integer.valueOf(args[1]));
					}
					else if (args[0].equals("storyid"))
					{
					CompileStoryVideo(Integer.valueOf(args[1]));
					}
				   
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		//	}
		//};
		//timer.schedule(timertask, new Date(), 30000);
	}
	public static void createIntance()
	{
		 try {
	            SERVER_SOCKET = new ServerSocket(1334);
	            System.out.println("OK to continue running.");
	            System.out.println("Press any key to exit.");
	            
	            
	        } catch (IOException x) {
	            System.out.println("Another instance already running... exit.");
	        }
	}
	public static void loadConfiguration()
	{
		File file = new File(Program.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println(file.getParent());
		Properties properties = new Properties() ;
		try {
			properties.load(new FileInputStream(file.getParent() + "/littlebirdtale_en_US.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ffmpegPath = properties.getProperty("com.lbt.ffmpegpath");
		mp4BoxPath = properties.getProperty("com.lbt.mp4boxpath");
		flvBindPath = properties.getProperty("com.lbt.flvbindpath");
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
		
	}
	public static void CompileUserVideos(long userId)
	{
	   Stories _stories[] =	dm.findByUsers(userId);
	   for (int i=0; i<_stories.length; i++ ) {
			CompileVideo(_stories[i]);
		}
	}
	public static void CompileStoryVideo(int storyId)
	{
		Stories _stories[] =	dm.findByStoryId(storyId);
		   for (int i=0; i<_stories.length; i++ ) {
				CompileVideo(_stories[i]);
			}
	}
	public static void CompileVideo(Stories nextStory)
	{
		if (!isProcessing) {
			
			isProcessing = true;
			
			
			
			audioFiles.clear();
			duration = 0;
			imageCount = 0;
			mm.textBG = directoryPrefix + "textBG.png";
			
			if (nextStory!=null) {
				try {
					dm.startProcessing(nextStory);
					String storyID = String.valueOf(nextStory.getStoryId());
					String userID = String.valueOf(nextStory.getUserId());
					setStoryDirectories(userID);
					createDirectories(storyID, userID);
					if((new File(firstImagePath).exists()))
					{
					createAudioFile(
							null,
							tempAudioDirectoryPrefix + "first"
									+ nextStory.getStoryId() + ".flv");
					createCopies(firstImagePath, 0);
					}
					
					createImage(
							HTMLUtil.removeHTML(nextStory.getTitle()),
							tempStoryDirectoryPrefix + "text"
									+ nextStory.getStoryId() + ".png",
							storyImagesDirectoryPrefix + nextStory.getImagePath(),
							tempStoryDirectoryPrefix + nextStory.getStoryId()
									+ ".png");
					createAudioFile(
							storyAudioDirectoryPrefix + nextStory.getAudioPath(),
							tempAudioDirectoryPrefix + "story"
									+ nextStory.getStoryId() + ".flv");
					createCopies(tempStoryDirectoryPrefix + nextStory.getStoryId()
							+ ".png", duration);
					StoryPages _storyPages[] = null;
					if (nextStory != null) {
						_storyPages = dm.findWhereStoryIdEquals(nextStory
								.getStoryId());

						for (int i = 0; i < _storyPages.length; i++) {
							duration = 0;
							createImage(
									HTMLUtil.removeHTML(_storyPages[i].getBody()),
									tempStoryDirectoryPrefix + "text"
											+ _storyPages[i].getStoryPageId()
											+ ".png", storyImagesDirectoryPrefix
											+ _storyPages[i].getImagePath(),
									tempStoryDirectoryPrefix + "combine"
											+ _storyPages[i].getStoryPageId()
											+ ".png");
							createAudioFile(
									storyAudioDirectoryPrefix
											+ _storyPages[i].getAudioPath(),
									tempAudioDirectoryPrefix
											+ _storyPages[i].getStoryPageId()
											+ ".flv");
							createCopies(tempStoryDirectoryPrefix + "combine"
									+ _storyPages[i].getStoryPageId() + ".png",
									duration);

						}
						if ((new File(lastImagePath).exists())) {
							createAudioFile(null, tempAudioDirectoryPrefix
									+ "last" + nextStory.getStoryId() + ".flv");
							createCopies(lastImagePath, 0);
						}
						mergeAudio(nextStory.getStoryId());
					}
					dm.videoCompiled(nextStory);
				} catch (IOException e) {
					dm.videoHasError(nextStory, getStackTrace(e));
					
				}
			}
			isProcessing = false;
		}

	}
	public static void createImage(String text,String textImage, String taleImage, String combineImage) throws IOException
	{
			mm.text = text;
		//	mm.text = "Hello";
			mm.textImage = textImage;
			mm.taleImage = taleImage;
			mm.textBG = textBG;
			System.out.println(taleImage);
			mm.combineImage = combineImage;
			mm.TextOverlay();
			mm.CreateImage();
	}
	public static void createDirectories(String storyID,String userID)
	{
//			tempUserDirectoryPrefix = tempDirectoryPrefix + userID +"\\";
//			tempStoryDirectoryPrefix = tempDirectoryPrefix + userID +"\\" + storyID + "\\";
//			tempImagesDirectoryPrefix = tempStoryDirectoryPrefix + "Images\\";
//			tempAudioDirectoryPrefix = tempStoryDirectoryPrefix + "Audio\\";
		tempUserDirectoryPrefix = tempDirectoryPrefix + userID +"/";
		tempStoryDirectoryPrefix = tempDirectoryPrefix + userID +"/" + storyID + "/";
		tempImagesDirectoryPrefix = tempStoryDirectoryPrefix + "Images/";
		tempAudioDirectoryPrefix = tempStoryDirectoryPrefix + "Audio/";
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
	}
	public static void setStoryDirectories(String userID)
	{
//		storyDirectoryPrefix = directoryPrefix + userID + "\\";
//		storyImagesDirectoryPrefix = storyDirectoryPrefix + "images\\";
//		storyAudioDirectoryPrefix = storyDirectoryPrefix + "audio\\";
//		storyVideoDirectoryPrefix = storyDirectoryPrefix + "video\\";
		storyDirectoryPrefix = directoryPrefix + userID + "/";
		storyImagesDirectoryPrefix = storyDirectoryPrefix + "images/";
		storyAudioDirectoryPrefix = storyDirectoryPrefix + "audio/";
		storyVideoDirectoryPrefix = storyDirectoryPrefix + "video/";
		boolean success = (new File(storyVideoDirectoryPrefix)).mkdir();
	    if (success) {
	      System.out.println("Directory: " + storyVideoDirectoryPrefix + " created");
	    }
	}
	public static void createCopies(String imagePath, long duration) throws IOException
	{
		NumberFormat format = new DecimalFormat("00000");
		
		int numberofCopies = 0;
		double miliseconds = 100;
		double minutes = 0;
		if(duration!= 0)
		{
			minutes = ((double)duration)/miliseconds;
			System.out.println(minutes);
			numberofCopies =  (int) Math.rint(minutes);
			
		}
		else
		{
			numberofCopies=54;
		}
		for (int i=0; i<numberofCopies; i++ ) {
			
		//	String destination = tempImagesDirectoryPrefix + "\\" +  format.format(imageCount) + ".png";
			String destination = tempImagesDirectoryPrefix + "/" +  format.format(imageCount) + ".png";
			try {
				File sourceFile = new File(imagePath);
				File destFile = new File(destination);
				copyFile(sourceFile, destFile);
				imageCount++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw e;
			}
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
	public static long getDuration(String filePath)
	{
		long duration = 0;
		File flvFile = new File(filePath);
		FLVReader reader = null;
		if(flvFile.exists())
		{
		try {
			reader = getFLVReader(flvFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(reader!=null)
		{
		duration =  reader.getDuration();
		
		}
		}
		
		return duration;
	}
	public static FLVReader getFLVReader(File flvFile) throws IOException
	{
		org.red5.io.flv.impl.FLVReader reader = null;
		try {
			reader = new FLVReader(flvFile);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return reader;
	}
	public static void createAudioFile(String sourcePath,String destPath) throws IOException
	{
		
		try {
			if (sourcePath != null
					&& sourcePath != "") {
				System.out.println(sourcePath);
				duration = getDuration(sourcePath);

			}
			else
			{
				sourcePath = emptyAudio;
			}
			if (duration == 0) {
				sourcePath = emptyAudio;
			}
			File srcFile = new File(sourcePath);
			File destFile = new File(destPath);
			
			copyFile(srcFile, destFile);
			audioFiles.add(destFile.getPath());
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
	} finally {
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
	 
	public static void mergeAudio(long storyID) throws IOException
	{
		String mergecmdPart="";
		String codecPart=" -oac copy -ovc copy ";
		String tempOutFilePart=  tempAudioDirectoryPrefix + "mergeAudio.mp3 " ;
		String OutAudioFilePart=  tempAudioDirectoryPrefix + "mergeAudio_MP3WRAP.mp3 " ;
		String OutAudioFilePartRaw=  tempAudioDirectoryPrefix + "mergeAudio_MP3WRAP.mp3 " ;
		String tempVOutFilePart=   tempAudioDirectoryPrefix + storyID +".mp4 " ;
		String OutFilePart=   storyVideoDirectoryPrefix + storyID +".mp4 " ;
		Runtime rt = Runtime.getRuntime();
		String command = "";
		Process proc = null;
		for(int i=0;i< audioFiles.size();i++)
		{
			
			String infilename = audioFiles.get(i).substring(0,audioFiles.get(i).length()-4);
			String outfilename = infilename +".mp3  " ;
			command = ffmpegPath + " -i " + infilename +".flv" + " -acodec libmp3lame -y " +  outfilename ;
			try {
				proc = rt.exec(command );
				System.out.println(convertStreamToString(proc.getErrorStream()));
				System.out.println (command);
				mergecmdPart += outfilename; 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			
		}
		
		try {
			
			command = flvBindPath + " " + tempOutFilePart + mergecmdPart ;
			
			
			proc = rt.exec(command );
			System.out.println (command);
			System.out.println(convertStreamToString(proc.getInputStream()));
			
		//	command = ffmpegPath + " -i " + tempOutFilePart + " -y " +  OutAudioFilePart ;
			//proc = rt.exec(command );
			//System.out.println(convertStreamToString(proc.getErrorStream()));
			command = ffmpegPath + " -f image2 -r 10 -i " +  tempImagesDirectoryPrefix+"%05d.png"+ " -i " + OutAudioFilePart +  " -vcodec libx264 -vpre slow -acodec libfaac -y " + tempVOutFilePart;
			//proc = rt.exec(command );
			System.out.println (command);
			//ProcessBuilder pb = new ProcessBuilder(command);
			proc = rt.exec(command );
		
			System.out.println(convertStreamToString(proc.getErrorStream()));
			command = mp4BoxPath +  " -quiet -hint "+  tempVOutFilePart +" -out "+ OutFilePart;
			System.out.println (command);
			proc = rt.exec(command );
			System.out.println(convertStreamToString(proc.getErrorStream()));
			//int exitValue = proc.exitValue();
			
			 
			deleteDirectory(new File(tempStoryDirectoryPrefix));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
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
	

}
