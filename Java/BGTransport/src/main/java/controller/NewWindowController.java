package controller;

import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import view.HomeView;
import view.LoginView;
import view.MapView;
import view.RoundedPanel;
import view.SignUpWindow;
import controller.ThemeController;;

public class NewWindowController {

	public static void openHomePanel(HomeView homeV) {
		SwingUtilities.invokeLater(() -> {
			homeV.setVisible(true);
		});
		homeV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.componentBounds,
						homeV.mainPanel);
				ResizeController.resizeImagePanel(homeV, homeV.lblBGwallpaper, homeV.mainPanel);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.iconUser, homeV.userButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.iconMap, homeV.mapButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.iconHome, homeV.homeButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.iconLDmode, homeV.switchThemeButton);
				ResizeController.resizeImageLabel(homeV.originalPanelSize, homeV, homeV.iconWeather,
						homeV.lblweatherimg);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.menuPanel, homeV.MenuPanelSize, homeV.menupanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.weatherPanel,
						homeV.WidgetPanelSizeMedium, homeV.weatherpanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.timePanel,
						homeV.WidgetPanelSizeSmall, homeV.timepanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.miniMapPanel, homeV.MapPanelSize, homeV.miniMapPanelPoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, MapController.miniMapViewer, homeV.MapSize, homeV.mappoint);
			}
		});
	}

	public static void openMapPanel(MapView mapV) {
		SwingUtilities.invokeLater(() -> {
			mapV.setVisible(true);
		});
		mapV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(mapV.originalPanelSize, mapV, mapV.componentBounds, mapV.mainPanel);
				ResizeController.resizeImagePanel(mapV, mapV.lblBGwallpaper, mapV.mainPanel);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconUser, mapV.userButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconMap, mapV.mapButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconHome, mapV.homeButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconBus, mapV.busButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconTrain, mapV.trainButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconFunicular, mapV.funicularButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconTram, mapV.tramButton);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, mapV.menuPanel, mapV.MenuPanelSize, mapV.menupanelpoint);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, mapV.externmapPanel, mapV.MapPanelSize, mapV.mappanelpoint);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, MapController.fullMapViewer, mapV.MapSize,
						mapV.mappoint);
			}
		});
	}

	public static void openLoginPanel(LoginView loginV) {

		SwingUtilities.invokeLater(() -> {
			loginV.setVisible(true);
		});
		loginV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizePanel(loginV.originalPanelSize, loginV, loginV.centerPanel, loginV.CentralPanelSize, loginV.centerPanelpoint);
				ResizeController.resizeComponents(loginV.originalPanelSize, loginV, loginV.componentBounds,	loginV.mainPanel);
				ResizeController.resizeImagePanel(loginV, loginV.lblBGwallpaper, loginV.mainPanel);
				ResizeController.resizeImageButton(loginV.originalPanelSize, loginV, loginV.iconReturn, loginV.returnButton);
				ResizeController.resizeImageButton(loginV.originalPanelSize, loginV, loginV.iconLDmode, loginV.switchThemeButton);
			}
		});
	}

	public static void openSignUp(SignUpWindow signupV) {

		SwingUtilities.invokeLater(() -> {
			signupV.setVisible(true);
		});
	}

}
