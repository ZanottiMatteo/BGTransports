package bgtransport.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;

import bgtransport.model.ConstantString;
import bgtransport.model.ResizableImage;
import bgtransport.view.BigLabel;
import bgtransport.view.LittleLabel;
import bgtransport.view.MediumLabel;
import bgtransport.view.MiniLabel;
import bgtransport.view.VeryBigLabel;

public class ResizeController {

	public static void resizeComponents(Dimension originalPanelSize, JFrame jframe,
			Map<Component, Rectangle> componentBounds, JPanel panel) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		//System.out.println("W: " + jframe.getWidth() + "H: " + jframe.getHeight());

		for (Map.Entry<Component, Rectangle> entry : componentBounds.entrySet()) {
			Component comp = entry.getKey();
			Rectangle originalBounds = entry.getValue();
			comp.setBounds((int) (originalBounds.x * widthRatio), (int) (originalBounds.y * heightRatio),
					(int) (originalBounds.width * widthRatio), (int) (originalBounds.height * heightRatio));
			if (comp instanceof LittleLabel) {
				LittleLabel label = (LittleLabel) comp;

				int fontSize = Math.max(jframe.getWidth() / 100, 10);

				label.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof MiniLabel) {
				MiniLabel label = (MiniLabel) comp;

				int fontSize = Math.max(jframe.getWidth() / 130, 10);

				label.setFont(new Font(ConstantString.SANSSERIF, Font.ITALIC, fontSize));
			} else if (comp instanceof MediumLabel) {
				MediumLabel label = (MediumLabel) comp;

				int fontSize = Math.max(jframe.getWidth() / 90, 10);

				label.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof BigLabel) {
				BigLabel label = (BigLabel) comp;

				int fontSize = Math.max(jframe.getWidth() / 50, 10);

				label.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof VeryBigLabel) {
				VeryBigLabel label = (VeryBigLabel) comp;

				int fontSize = Math.max(jframe.getWidth() / 20, 10);

				label.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof JLabel) {
				JLabel label = (JLabel) comp;

				int fontSize = Math.max(jframe.getWidth() / 60, 10);

				label.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, fontSize));
			}
		}
		panel.repaint();
		panel.revalidate();
	}

	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JPanel panel, Dimension paneldimension,
			Point point) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		panel.setBounds((int) (point.x * widthRatio), (int) (point.y * heightRatio),
				(int) (paneldimension.width * widthRatio), (int) (paneldimension.height * heightRatio));
		panel.repaint();
		panel.revalidate();
	}

	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JXMapViewer mapViewer,
			Dimension paneldimension, Point point) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		mapViewer.setBounds((int) (point.x * widthRatio), (int) (point.y * heightRatio),
				(int) (paneldimension.width * widthRatio), (int) (paneldimension.height * heightRatio));
		mapViewer.repaint();
		mapViewer.revalidate();
	}

	public static void resizeImagePanel(JFrame jframe, ResizableImage rimage, JPanel panel) {
		int newWidth = jframe.getWidth();
		int newHeight = jframe.getHeight();
		rimage.resizeImage(newWidth, newHeight);
		panel.repaint();
		panel.revalidate();
	}

	public static void resizeImageButton(Dimension originalPanelSize, JFrame jframe, ImageIcon rimage,
			JButton jbutton) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		double singleRatio;
		if (widthRatio > heightRatio) {
			singleRatio = heightRatio;
		} else {
			singleRatio = widthRatio;
		}
		Image scaledImage = rimage.getImage().getScaledInstance((int) (rimage.getIconWidth() * singleRatio),
				(int) (rimage.getIconHeight() * singleRatio), Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		jbutton.setIcon(resizedIcon);
	}

	public static void resizeImageLabel(Dimension originalPanelSize, JFrame jframe, ImageIcon rimage, JLabel jlabel) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		double singleRatio;
		if (widthRatio > heightRatio) {
			singleRatio = heightRatio;
		} else {
			singleRatio = widthRatio;
		}
		Image scaledImage = rimage.getImage().getScaledInstance((int) (rimage.getIconWidth() * singleRatio),
				(int) (rimage.getIconHeight() * singleRatio), Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		jlabel.setIcon(resizedIcon);
	}
}
