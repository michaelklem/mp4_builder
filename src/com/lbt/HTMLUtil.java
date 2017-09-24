package com.lbt;

public class HTMLUtil {
	  public static String removeHTML(String htmlString)
	    {
	          // Remove HTML tag from java String
		   if(htmlString==null) return "";
	       
		   String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");

	        // Remove Carriage return from java String
	        noHTMLString = noHTMLString.replaceAll("\r", "");

	        noHTMLString = noHTMLString.replaceAll("\n", " ");
	        noHTMLString = noHTMLString.replaceAll("&nbsp;", "");
	        noHTMLString = noHTMLString.replaceAll("&#039;", "'");
	        noHTMLString = noHTMLString.replaceAll("&quot;", "\"");
	        noHTMLString = noHTMLString.replaceAll("&amp;", "&");
	        
	        return HtmlEntities.decode(noHTMLString);
	    }
}
