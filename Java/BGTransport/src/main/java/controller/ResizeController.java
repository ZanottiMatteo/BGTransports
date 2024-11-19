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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.ResizableImage;

public class ResizeController {

	private static BufferedImage originalImage;
    private Image scaledImage;
	
	public static void resizeComponents(Dimension originalPanelSize, JFrame jframe, Map<Component, Rectangle> componentBounds, JPanel panel) {
    	double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
        double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;        
        System.out.println("W: " + jframe.getWidth() + "H: " + jframe.getHeight());     
        
        for (Map.Entry<Component, Rectangle> entry : componentBounds.entrySet()) {
            Component comp = entry.getKey();
            Rectangle originalBounds = entry.getValue();
            comp.setBounds((int)(originalBounds.x * widthRatio), (int)(originalBounds.y * heightRatio), (int)(originalBounds.width * widthRatio), (int)(originalBounds.height * heightRatio));
        }       
        panel.repaint();
        panel.revalidate();
    } 
	
	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JPanel panel, Dimension paneldimension ) {
    	double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
        double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;         
        panel.setSize((int)(paneldimension.width * widthRatio), (int)(paneldimension.height * heightRatio));
        panel.repaint();
        panel.revalidate();
    }
	
	public static void resizeImagePanel(JFrame jframe, ResizableImage Rimage, JPanel panel) {
		int newWidth = jframe.getWidth();
        int newHeight = jframe.getHeight();
        Rimage.resizeImage(newWidth, newHeight);
        panel.repaint();
        panel.revalidate();
	}
	
	public static void resizeImageButton(Dimension originalPanelSize, JFrame jframe, ImageIcon Rimage, JButton jbutton) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
        double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
        double singleRatio = 0.0;
        if (widthRatio > heightRatio) {
        	singleRatio = heightRatio;
        } else {
        	singleRatio = widthRatio;
        }     
        Image scaledImage = Rimage.getImage().getScaledInstance((int)(Rimage.getIconWidth() * singleRatio), (int)(Rimage.getIconHeight() * singleRatio), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        jbutton.setIcon(resizedIcon);
	}
}
