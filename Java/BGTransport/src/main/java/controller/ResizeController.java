package controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ResizeController {

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
}
