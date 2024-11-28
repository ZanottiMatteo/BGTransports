package controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;

import model.ResizableImage;
import view.BigLabel;
import view.LittleLabel;
import view.MediumLabel;

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
            int size = 0;
            comp.setBounds((int)(originalBounds.x * widthRatio), (int)(originalBounds.y * heightRatio), (int)(originalBounds.width * widthRatio), (int)(originalBounds.height * heightRatio));
            if (comp instanceof LittleLabel) {
            	LittleLabel label = (LittleLabel) comp;
                
                // Calcoliamo una nuova dimensione del font in base alla larghezza della finestra
                int fontSize = Math.max(jframe.getWidth() / 100, 10);  // La dimensione del font deve essere almeno 10

                // Impostiamo il nuovo font per la JLabel
                label.setFont(new Font("SanSerif", Font.BOLD, fontSize));
            } else if (comp instanceof MediumLabel) {
            	MediumLabel label = (MediumLabel) comp;
                
                // Calcoliamo una nuova dimensione del font in base alla larghezza della finestra
                int fontSize = Math.max(jframe.getWidth() / 80, 10);  // La dimensione del font deve essere almeno 10

                // Impostiamo il nuovo font per la JLabel
                label.setFont(new Font("SanSerif", Font.BOLD, fontSize));
            } else if (comp instanceof BigLabel) {
            	BigLabel label = (BigLabel) comp;
                
                // Calcoliamo una nuova dimensione del font in base alla larghezza della finestra
                int fontSize = Math.max(jframe.getWidth() / 50, 10);  // La dimensione del font deve essere almeno 10

                // Impostiamo il nuovo font per la JLabel
                label.setFont(new Font("SanSerif", Font.BOLD, fontSize));
            } else if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                
                // Calcoliamo una nuova dimensione del font in base alla larghezza della finestra
                int fontSize = Math.max(jframe.getWidth() / 60, 10);  // La dimensione del font deve essere almeno 10

                // Impostiamo il nuovo font per la JLabel
                label.setFont(new Font("SanSerif", Font.BOLD, fontSize));
            }
        }       
        panel.repaint();
        panel.revalidate();
    } 
	
	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JPanel panel, Dimension paneldimension, Point point) {
    	double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
        double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;         
        panel.setBounds((int)(point.x*widthRatio), (int)(point.y*heightRatio), (int)(paneldimension.width * widthRatio), (int)(paneldimension.height * heightRatio));
        panel.repaint();
        panel.revalidate();
    }
	
	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JXMapViewer MapViewer, Dimension paneldimension, Point point) {
    	double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
        double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;         
        MapViewer.setBounds((int)(point.x*widthRatio), (int)(point.y*heightRatio), (int)(paneldimension.width * widthRatio), (int)(paneldimension.height * heightRatio));
        MapViewer.repaint();
        MapViewer.revalidate();
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
	
	public static void resizeImageLabel(Dimension originalPanelSize, JFrame jframe, ImageIcon Rimage, JLabel jlabel) {
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
        jlabel.setIcon(resizedIcon);
	}
}
