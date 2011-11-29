package util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

/**
 * Text draw utility
 */
public class TextDraw 
{
	/**
	 * Draw text at given center position 
	 */
	public static void drawCenteredText(Graphics g, int cx, int cy, String text)
	{	
		Graphics2D g2D = (Graphics2D)g;
		
		Font font = g2D.getFont();
		FontRenderContext frc = g2D.getFontRenderContext();
	    
		LineMetrics lm = font.getLineMetrics(text, frc);
		float height  = lm.getHeight();
		float descent = lm.getDescent();
		
		float textWidth = (float)font.getStringBounds(text, frc).getWidth();
	    float x = cx - textWidth / 2;
	    float y = cy + height/2 - descent;
	    g2D.drawString(text, x, y);
	}
	
	/** 
	 * Calculate text width
	 */
	public static int calcTextWidth(Graphics g, String text) {
		Graphics2D g2D = (Graphics2D)g;
		
		Font font = g2D.getFont();
		FontRenderContext frc = g2D.getFontRenderContext();
	    
		return (int)font.getStringBounds(text, frc).getWidth();
	}
}
