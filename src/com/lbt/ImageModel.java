package com.lbt;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageModel {
	/**
	 * @param args
	 */
	private static BufferedImage image;
	
	public String textBG= "C:\\Users\\adil\\Desktop\\textBG.png";
	public String textImage= "C:\\Users\\adil\\Desktop\\test.png";
	public String combineImage= "C:\\Users\\adil\\Desktop\\combineImage.png";
	public String taleImage= "C:\\Users\\adil\\Desktop\\Image.jpg";
	public String text= "Hello World";
		

	
	public void TextOverlay() throws IOException {
        try {
        	File txtBGfile = new File(textBG);
        	image = ImageIO.read(txtBGfile);
            image = process(image);
            File outputfile = new File(textImage);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            throw e;
        }
        
        
        
    }
	public void CreateImage() throws IOException
	{
		try{
		
		File talefile = new File(taleImage);
		 		
		if(!talefile.exists() || !talefile.isFile())
		{
			talefile = new File(Program.defaultImagePath); 
		}
		
		BufferedImage timage = ImageIO.read(talefile);
		File textfile = new File(textImage);
		BufferedImage textimage = ImageIO.read(textfile);
		image = combineImages(timage,textimage);
		File outputfile = new File(combineImage);
        ImageIO.write(image, "png", outputfile);
        
		} catch (IOException e) {
			throw e;
		}
	}
	private BufferedImage combineImages(BufferedImage imagePart,BufferedImage textPart) {
		int w = imagePart.getWidth();
        int h = imagePart.getHeight()+120;
        BufferedImage img = new BufferedImage(
            w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(imagePart, 0, 0, null);
        g2d.drawImage(textPart, 0, imagePart.getHeight(), null);
        g2d.dispose();
        return img;
	}
	  private BufferedImage process(BufferedImage old) {
	        int w = old.getWidth();
	        int h = old.getHeight();
	        BufferedImage img = new BufferedImage(
	            w, h, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = img.createGraphics();
	        
	        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
	        g2d.drawImage(old, 0, 0, null);
	        g2d.setPaint(Color.black);
	        g2d.setFont(new Font("Veranda", Font.PLAIN, 16));
	        FontMetrics fm = g2d.getFontMetrics();

	        int lineHeight = fm.getHeight() - 4;
	        int x = 10;
	        int y = 0;
	        int curX = x;
	        int curY = y;
	        
	        String[] words = text.split(" ");
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = "";
	        int lineCount = 0;
	        for (String word : words)
	        {
	                // Find out the width of the word.
	                int wordWidth = fm.stringWidth(word + " ");

	                // If text exceeds the width, then move to next line.
	                if (curX + wordWidth >= x + w)
	                {
	                		lines.add(line);
	                		line = " "; // add a space to the first character in the line for padding
	                		lineCount++;
	                		curY += lineHeight;
	                        curX = x;
	                }
	                line += word + " "; 

	                // Move over to the right for next word.
	                curX += wordWidth;
	        }
	        lines.add(line);
	        int totalLines = lines.size();
        	if(lines.size()>6)
        	{
        		totalLines = 6;
        	}
	        for(int i=0; i< totalLines; i++)
	        {
	        	g2d.drawString(lines.get(i), 
	        				GetLineX(fm.stringWidth(lines.get(i))), 
	        				GetLineY(i+1, lineHeight, totalLines));
	        }
	        
	        g2d.dispose();
	        return img;
	    }
	  private int GetLineY(int currentLine, int lineHeight, int totalLines)
	  {
			int diff = 120 - (lineHeight*totalLines); 
	        int yPadding = (currentLine*lineHeight) + (diff/2);
	        yPadding -= (lineHeight/2);
		  return yPadding;
	  }
	  private int GetLineX(int lineWidth)
	  {
		  int diff = 600 - lineWidth; 
		  return (diff/2);
	  }
}
