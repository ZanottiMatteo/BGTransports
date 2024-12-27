package bgtransport.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;

import bgtransport.model.ConstantString2;
import bgtransport.model.ResizableImage;
import bgtransport.view.BigLabel;
import bgtransport.view.LittleLabel;
import bgtransport.view.MediumLabel;
import bgtransport.view.MiniLabel;
import bgtransport.view.VeryBigLabel;

/**
 * This class contains static methods for resizing components, panels, and
 * images within a JFrame based on the JFrame's current size relative to the
 * original size. It also handles font resizing for different types of labels.
 */
public class ResizeController {

	/**
	 * Resizes the components on the panel based on the JFrame's current size.
	 *
	 * @param originalPanelSize The original size of the panel.
	 * @param jframe            The JFrame containing the panel.
	 * @param componentBounds   A map of components to their original bounds.
	 * @param panel             The panel that contains the components.
	 */
	public static void resizeComponents(Dimension originalPanelSize, JFrame jframe,
			Map<Component, Rectangle> componentBounds, JPanel panel) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;

		for (Map.Entry<Component, Rectangle> entry : componentBounds.entrySet()) {
			Component comp = entry.getKey();
			Rectangle originalBounds = entry.getValue();
			comp.setBounds((int) (originalBounds.x * widthRatio), (int) (originalBounds.y * heightRatio),
					(int) (originalBounds.width * widthRatio), (int) (originalBounds.height * heightRatio));

			// Adjust font size for different types of labels
			if (comp instanceof LittleLabel) {
				LittleLabel label = (LittleLabel) comp;
				int fontSize = Math.max(jframe.getWidth() / 100, 10);
				label.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof MiniLabel) {
				MiniLabel label = (MiniLabel) comp;
				int fontSize = Math.max(jframe.getWidth() / 130, 10);
				label.setFont(new Font(ConstantString2.SANSSERIF, Font.ITALIC, fontSize));
			} else if (comp instanceof MediumLabel) {
				MediumLabel label = (MediumLabel) comp;
				int fontSize = Math.max(jframe.getWidth() / 90, 10);
				label.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof BigLabel) {
				BigLabel label = (BigLabel) comp;
				int fontSize = Math.max(jframe.getWidth() / 50, 10);
				label.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof VeryBigLabel) {
				VeryBigLabel label = (VeryBigLabel) comp;
				int fontSize = Math.max(jframe.getWidth() / 20, 10);
				label.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, fontSize));
			} else if (comp instanceof JLabel) {
				JLabel label = (JLabel) comp;
				int fontSize = Math.max(jframe.getWidth() / 60, 10);
				label.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, fontSize));
			}
		}
		panel.repaint();
		panel.revalidate();
	}

	/**
	 * Resizes a panel based on the current size of the JFrame.
	 *
	 * @param originalPanelSize The original size of the panel.
	 * @param jframe            The JFrame containing the panel.
	 * @param panel             The panel to resize.
	 * @param paneldimension    The original dimensions of the panel.
	 * @param point             The position of the panel in the JFrame.
	 */
	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JPanel panel, Dimension paneldimension,
			Point point) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		panel.setBounds((int) (point.x * widthRatio), (int) (point.y * heightRatio),
				(int) (paneldimension.width * widthRatio), (int) (paneldimension.height * heightRatio));
		panel.repaint();
		panel.revalidate();
	}

	/**
	 * Resizes a panel containing a map viewer based on the current size of the
	 * JFrame.
	 *
	 * @param originalPanelSize The original size of the panel.
	 * @param jframe            The JFrame containing the panel.
	 * @param mapViewer         The map viewer to resize.
	 * @param paneldimension    The original dimensions of the panel.
	 * @param point             The position of the panel in the JFrame.
	 */
	public static void resizePanel(Dimension originalPanelSize, JFrame jframe, JXMapViewer mapViewer,
			Dimension paneldimension, Point point) {
		double widthRatio = (double) jframe.getWidth() / originalPanelSize.width;
		double heightRatio = (double) jframe.getHeight() / originalPanelSize.height;
		mapViewer.setBounds((int) (point.x * widthRatio), (int) (point.y * heightRatio),
				(int) (paneldimension.width * widthRatio), (int) (paneldimension.height * heightRatio));
		mapViewer.repaint();
		mapViewer.revalidate();
	}

	/**
	 * Resizes an image within a resizable image panel based on the current size of
	 * the JFrame.
	 *
	 * @param jframe The JFrame containing the resizable image.
	 * @param rimage The resizable image object.
	 * @param panel  The panel containing the image.
	 */
	public static void resizeImagePanel(JFrame jframe, ResizableImage rimage, JPanel panel) {
		int newWidth = jframe.getWidth();
		int newHeight = jframe.getHeight();
		rimage.resizeImage(newWidth, newHeight);
		panel.repaint();
		panel.revalidate();
	}

	/**
	 * Resizes an image within a button based on the current size of the JFrame.
	 *
	 * @param originalPanelSize The original size of the panel.
	 * @param jframe            The JFrame containing the button.
	 * @param rimage            The image icon to resize.
	 * @param jbutton           The button containing the image.
	 */
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

	/**
	 * Resizes an image within a label based on the current size of the JFrame.
	 *
	 * @param originalPanelSize The original size of the panel.
	 * @param jframe            The JFrame containing the label.
	 * @param rimage            The image icon to resize.
	 * @param jlabel            The label containing the image.
	 */
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
