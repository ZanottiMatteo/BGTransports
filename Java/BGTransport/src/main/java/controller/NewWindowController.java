package controller;

import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.AccountIconView;
import view.DownloadDataDBView;
import view.HomeView;
import view.LoginView;
import view.MapView;
import view.RoundedPanel;
import view.SignUpView;
import view.UserView;
import view.UserWidget;
import controller.ThemeController;;

public class NewWindowController {

	public static void openHomePanel(HomeView homeV) {
		MapController.generateMap();
		MapController.generateMiniMap();
		SwingUtilities.invokeLater(() -> {
			homeV.setVisible(true);
		});
		homeV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.componentBounds,
						homeV.mainPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.weatherPanel.componentBounds,
						homeV.weatherPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.timePanel.componentBounds,
						homeV.timePanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.miniMapPanel.componentBounds,
						homeV.miniMapPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.menuPanel.componentBounds,
						homeV.menuPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.userPanel.componentBounds,
						homeV.userPanel);
				ResizeController.resizeImagePanel(homeV, homeV.lblBGwallpaper, homeV.mainPanel);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconUser, homeV.menuPanel.userButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconMap, homeV.menuPanel.mapButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconHome, homeV.menuPanel.homeButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconLDmode,
						homeV.menuPanel.switchThemeButton);
				ResizeController.resizeImageLabel(homeV.originalPanelSize, homeV, homeV.weatherPanel.iconWeather,
						homeV.weatherPanel.lblweatherimg);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.menuPanel, homeV.MenuPanelSize,
						homeV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.weatherPanel,
						homeV.WidgetPanelSizeMedium, homeV.weatherPanel.weatherpanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.timePanel,
						homeV.WidgetPanelSizeSmall, homeV.timePanel.timepanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.miniMapPanel, homeV.MapPanelSize,
						homeV.miniMapPanel.miniMapPanelPoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, MapController.miniMapViewer, homeV.MapSize,
						homeV.miniMapPanel.mappoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.userPanel, homeV.WidgetPanelSizeMedium,
						homeV.userPanel.userpanelpoint);
				
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
				ResizeController.resizeComponents(mapV.originalPanelSize, mapV, mapV.menuPanel.componentBounds,
						mapV.menuPanel);
				ResizeController.resizeImagePanel(mapV, mapV.lblBGwallpaper, mapV.mainPanel);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconUser, mapV.menuPanel.userButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconMap, mapV.menuPanel.mapButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconHome, mapV.menuPanel.homeButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconBus, mapV.busButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconTrain, mapV.trainButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconFunicular,
						mapV.funicularButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconTram, mapV.tramButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconLDmode,
						mapV.menuPanel.switchThemeButton);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, mapV.menuPanel, mapV.MenuPanelSize,
						mapV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, mapV.externmapPanel, mapV.MapPanelSize,
						mapV.mappanelpoint);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, MapController.fullMapViewer, mapV.MapSize,
						mapV.mappoint);
			}
		});
	}

	public static void choseUserLogin(UserView userV, LoginView loginV) {
		if (LoginController.userlogged.getEmail() == null) {
			openLoginPanel(loginV);	
			
		} else			
		openUserPanel(userV);
	}
			
	public static void openUserPanel(UserView userV) {
		SwingUtilities.invokeLater(() -> {
			userV.setVisible(true);
		});
		UserInfoController.showDataWidget();
		UserInfoController.setProfileIcon();
		UserInfoController.disableTextFields();
		userV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(userV.originalPanelSize, userV, userV.componentBounds,
						userV.mainPanel);
				ResizeController.resizeComponents(userV.originalPanelSize, userV, userV.menuPanel.componentBounds,
						userV.menuPanel);
				ResizeController.resizeImagePanel(userV, userV.lblBGwallpaper, userV.mainPanel);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconUser, userV.menuPanel.userButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconMap, userV.menuPanel.mapButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconHome, userV.menuPanel.homeButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconLDmode,
						userV.menuPanel.switchThemeButton);
				ResizeController.resizePanel(userV.originalPanelSize, userV, userV.menuPanel, userV.MenuPanelSize,
						userV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(userV.originalPanelSize, userV, userV.centerPanel, userV.CenterPanelSize,
						userV.centerpanelpoint);
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
				ResizeController.resizePanel(loginV.originalPanelSize, loginV, loginV.centerPanel,
						loginV.CentralPanelSize, loginV.centerPanelpoint);
				ResizeController.resizeComponents(loginV.originalPanelSize, loginV, loginV.componentBounds,
						loginV.mainPanel);
				ResizeController.resizeImagePanel(loginV, loginV.lblBGwallpaper, loginV.mainPanel);
				ResizeController.resizeImageButton(loginV.originalPanelSize, loginV, loginV.iconReturn,
						loginV.returnButton);
				ResizeController.resizeImageButton(loginV.originalPanelSize, loginV, loginV.iconLDmode,
						loginV.switchThemeButton);
			}
		});
	}

	public static void openSignUp(SignUpView signupV) {
		SwingUtilities.invokeLater(() -> {
			signupV.setVisible(true);
		});
	}
	
	public static void openDBloader(DownloadDataDBView dbV) {
		SwingUtilities.invokeLater(() -> {
			dbV.setVisible(true);
		});
	}


	public static void openAccountIconPanel(AccountIconView accountIconV) {
		AccountController.showImages();
		SwingUtilities.invokeLater(() -> {
			accountIconV.setVisible(true);
		});
	}

}
