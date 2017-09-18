package com.lbt;

public class HTMLUtil {
	  public static String removeHTML(String htmlString)
	    {
	          // Remove HTML tag from java String
		   if(htmlString==null) return "";
	        String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");

	        // Remove Carriage return from java String
	        noHTMLString = noHTMLString.replaceAll("\r", "<br/>");

	        // Remove New line from java string and replace html break
	        noHTMLString = noHTMLString.replaceAll("\n", " ");
	     //   noHTMLString = noHTMLString.replaceAll("\'", "&#39;");
	        noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
	        return noHTMLString;
	    }


}
