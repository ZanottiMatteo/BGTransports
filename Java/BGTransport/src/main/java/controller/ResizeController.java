package controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.ResizableImage;

public class ResizeController {

	private static BufferedImage originalImage;
    private Image scaledImage;
	
	public ResizeController() {
		
	}
	
	public static void resizeComponents(Dimension originalPanelSize, JFrame jframe, Map<Component, Rectangle> componentBounds, JPanel panel) {
    	double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
        double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;        
       // System.out.println("W: " + getWidth() + "H: " + getHeight());     
        
        for (Map.Entry<Component, Rectangle> entry : componentBounds.entrySet()) {
            Component comp = entry.getKey();
            Rectangle originalBounds = entry.getValue();
            comp.setBounds((int)(originalBounds.x * widthRatio), (int)(originalBounds.y * heightRatio), (int)(originalBounds.width * widthRatio), (int)(originalBounds.height * heightRatio));
        }       
        panel.repaint();
        panel.revalidate();
    } 
	
	public static void resizeImage(JFrame jframe, ResizableImage Rimage, JPanel panel) {
		int newWidth = jframe.getWidth();
        int newHeight = jframe.getHeight();
        Rimage.resizeImage(newWidth, newHeight);
        panel.repaint();
        panel.revalidate();
	}
	
}
