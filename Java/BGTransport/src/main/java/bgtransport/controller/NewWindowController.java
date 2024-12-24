package bgtransport.controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import bgtransport.view.AccountIconView;
import bgtransport.view.DatabaseView;
import bgtransport.view.DownloadDataDBView;
import bgtransport.view.HomeView;
import bgtransport.view.LineView;
import bgtransport.view.LoginView;
import bgtransport.view.MapView;
import bgtransport.view.SignUpView;
import bgtransport.view.UserView;

/**
 * Controller class for managing the opening of different views or panels in the
 * application.
 */
public class NewWindowController {

	/**
	 * Opens the home panel and sets up necessary components like map generation and
	 * resizing.
	 * 
	 * @param homeV The HomeView object to be displayed.
	 */
	public static void openHomePanel(HomeView homeV) {
		MapController.generateMap();
		MapController.generateMiniMap();
		SwingUtilities.invokeLater(() -> homeV.setVisible(true));
		homeV.addComponentListener(new ComponentAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.componentBounds,
						homeV.mainPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.weatherPanel.componentBounds,
						homeV.weatherPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.timePanel.componentBounds,
						homeV.timePanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, HomeView.miniMapPanel.componentBounds,
						HomeView.miniMapPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.menuPanel.componentBounds,
						homeV.menuPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.userPanel.componentBounds,
						homeV.userPanel);
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.infoPanel.componentBounds,
						homeV.infoPanel);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconUser,
						homeV.menuPanel.userButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconMap,
						homeV.menuPanel.mapButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconHome,
						homeV.menuPanel.homeButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconLine,
						homeV.menuPanel.lineButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconDatabase,
						homeV.menuPanel.databaseButton);
				ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.menuPanel.iconLDmode,
						homeV.menuPanel.switchThemeButton);
				ResizeController.resizeImageLabel(homeV.originalPanelSize, homeV, homeV.weatherPanel.iconWeather,
						homeV.weatherPanel.lblweatherimg);
				ResizeController.resizeImageLabel(homeV.originalPanelSize, homeV, homeV.infoPanel.iconLogo,
						homeV.infoPanel.logoLabel);
				ResizeController.resizeImageLabel(homeV.originalPanelSize, homeV, homeV.infoPanel.iconLogoD,
						homeV.infoPanel.logoLabelD);
				ResizeController.resizeImagePanel(homeV, homeV.lblBGwallpaper, homeV.mainPanel);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.menuPanel, homeV.menuPanelSize,
						homeV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.weatherPanel,
						homeV.widgetPanelSizeMedium, homeV.weatherPanel.weatherpanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.timePanel,
						homeV.widgetPanelSizeMedium, homeV.timePanel.timepanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, HomeView.miniMapPanel,
						homeV.widgetPanelSizeLarge, HomeView.miniMapPanel.miniMapPanelPoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, MapController.miniMapViewer, homeV.mapSize,
						HomeView.miniMapPanel.mappoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.userPanel,
						homeV.widgetPanelSizeMedium, homeV.userPanel.userpanelpoint);
				ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.infoPanel, homeV.widgetPanelTitle,
						homeV.infoPanel.infopanelpoint);

			}
		});
	}

	/**
	 * Opens the map panel and sets up necessary components like resizing.
	 * 
	 * @param mapV The MapView object to be displayed.
	 */
	public static void openMapPanel(MapView mapV) {
		SwingUtilities.invokeLater(() -> mapV.setVisible(true));
		mapV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(mapV.originalPanelSize, mapV, mapV.componentBounds, mapV.mainPanel);
				ResizeController.resizeComponents(mapV.originalPanelSize, mapV, mapV.menuPanel.componentBounds,
						mapV.menuPanel);
				ResizeController.resizeImagePanel(mapV, mapV.lblBGwallpaper, mapV.mainPanel);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconUser,
						mapV.menuPanel.userButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconMap,
						mapV.menuPanel.mapButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconHome,
						mapV.menuPanel.homeButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconLine,
						mapV.menuPanel.lineButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconDatabase,
						mapV.menuPanel.databaseButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconBus, mapV.busButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconTrain, mapV.trainButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconFunicular,
						mapV.funicularButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconTram, mapV.tramButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.iconmypos, mapV.myposButton);
				ResizeController.resizeImageButton(mapV.originalPanelSize, mapV, mapV.menuPanel.iconLDmode,
						mapV.menuPanel.switchThemeButton);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, mapV.menuPanel, mapV.menuPanelSize,
						mapV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, MapView.externmapPanel, mapV.mapPanelSize,
						mapV.mappanelpoint);
				ResizeController.resizePanel(mapV.originalPanelSize, mapV, MapController.fullMapViewer, mapV.mapSize,
						mapV.mappoint);
			}
		});
	}

	/**
	 * Decides which user panel to open based on the current login status.
	 * 
	 * @param userV  The UserView object to be displayed.
	 * @param loginV The LoginView object to be displayed if the user is not logged
	 *               in.
	 */
	public static void choseUserLogin(UserView userV, LoginView loginV) {
		if (LoginController.userlogged.getEmail() == null) {
			openLoginPanel(loginV);

		} else
			openUserPanel(userV);
	}

	/**
	 * Opens the user panel and sets up the profile and user information.
	 * 
	 * @param userV The UserView object to be displayed.
	 */
	public static void openUserPanel(UserView userV) {
		SwingUtilities.invokeLater(() -> userV.setVisible(true));
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
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconUser,
						userV.menuPanel.userButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconMap,
						userV.menuPanel.mapButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconHome,
						userV.menuPanel.homeButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconLine,
						userV.menuPanel.lineButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconDatabase,
						userV.menuPanel.databaseButton);
				ResizeController.resizeImageButton(userV.originalPanelSize, userV, userV.menuPanel.iconLDmode,
						userV.menuPanel.switchThemeButton);
				ResizeController.resizePanel(userV.originalPanelSize, userV, userV.menuPanel, userV.menuPanelSize,
						userV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(userV.originalPanelSize, userV, userV.centerPanel, userV.centerPanelSize,
						userV.centerpanelpoint);
			}
		});
	}

	/**
	 * Opens the login panel.
	 * 
	 * @param loginV The LoginView object to be displayed.
	 */
	public static void openLoginPanel(LoginView loginV) {
		SwingUtilities.invokeLater(() -> loginV.setVisible(true));
		loginV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizePanel(loginV.originalPanelSize, loginV, loginV.centerPanel,
						loginV.centralPanelSize, loginV.centerPanelpoint);
				ResizeController.resizeComponents(loginV.originalPanelSize, loginV, loginV.componentBounds,
						loginV.mainPanel);
				ResizeController.resizeImagePanel(loginV, loginV.lblBGwallpaper, loginV.mainPanel);
				ResizeController.resizeImageButton(loginV.originalPanelSize, loginV, loginV.iconReturn,
						loginV.returnButton);
				ResizeController.resizeImageButton(loginV.originalPanelSize, loginV, loginV.iconLDmode,
						loginV.switchThemeButton);
				ResizeController.resizeImageLabel(loginV.originalPanelSize, loginV, loginV.iconLogo, loginV.logoLabel);
				ResizeController.resizeImageLabel(loginV.originalPanelSize, loginV, loginV.iconLogoD,
						loginV.logoLabelD);
			}
		});
	}

	/**
	 * Opens the line panel.
	 * 
	 * @param lineV The LineView object to be displayed.
	 */
	public static void openLinePanel(LineView lineV) {
		SwingUtilities.invokeLater(() -> lineV.setVisible(true));
		lineV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(lineV.originalPanelSize, lineV, lineV.componentBounds,
						lineV.mainPanel);
				ResizeController.resizeComponents(lineV.originalPanelSize, lineV, lineV.menuPanel.componentBounds,
						lineV.menuPanel);
				ResizeController.resizeImagePanel(lineV, lineV.lblBGwallpaper, lineV.mainPanel);
				ResizeController.resizeImageButton(lineV.originalPanelSize, lineV, lineV.menuPanel.iconUser,
						lineV.menuPanel.userButton);
				ResizeController.resizeImageButton(lineV.originalPanelSize, lineV, lineV.menuPanel.iconMap,
						lineV.menuPanel.mapButton);
				ResizeController.resizeImageButton(lineV.originalPanelSize, lineV, lineV.menuPanel.iconHome,
						lineV.menuPanel.homeButton);
				ResizeController.resizeImageButton(lineV.originalPanelSize, lineV, lineV.menuPanel.iconLine,
						lineV.menuPanel.lineButton);
				ResizeController.resizeImageButton(lineV.originalPanelSize, lineV, lineV.menuPanel.iconDatabase,
						lineV.menuPanel.databaseButton);
				ResizeController.resizeImageButton(lineV.originalPanelSize, lineV, lineV.menuPanel.iconLDmode,
						lineV.menuPanel.switchThemeButton);
				ResizeController.resizePanel(lineV.originalPanelSize, lineV, lineV.menuPanel, lineV.menuPanelSize,
						lineV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(lineV.originalPanelSize, lineV, lineV.centerPanel, lineV.centerPanelSize,
						lineV.centerpanelpoint);
			}
		});
	}

	/**
	 * Opens the database panel and sets up necessary components like resizing.
	 * 
	 * @param dbV The DatabaseView object to be displayed.
	 */
	public static void openDatabasePanel(DatabaseView databaseV) {
		SwingUtilities.invokeLater(() -> databaseV.setVisible(true));
		databaseV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(databaseV.originalPanelSize, databaseV, databaseV.componentBounds,
						databaseV.mainPanel);
				ResizeController.resizeComponents(databaseV.originalPanelSize, databaseV,
						databaseV.menuPanel.componentBounds, databaseV.menuPanel);
				ResizeController.resizeImagePanel(databaseV, databaseV.lblBGwallpaper, databaseV.mainPanel);
				ResizeController.resizeImageButton(databaseV.originalPanelSize, databaseV, databaseV.menuPanel.iconUser,
						databaseV.menuPanel.userButton);
				ResizeController.resizeImageButton(databaseV.originalPanelSize, databaseV, databaseV.menuPanel.iconMap,
						databaseV.menuPanel.mapButton);
				ResizeController.resizeImageButton(databaseV.originalPanelSize, databaseV, databaseV.menuPanel.iconHome,
						databaseV.menuPanel.homeButton);
				ResizeController.resizeImageButton(databaseV.originalPanelSize, databaseV, databaseV.menuPanel.iconLine,
						databaseV.menuPanel.lineButton);
				ResizeController.resizeImageButton(databaseV.originalPanelSize, databaseV,
						databaseV.menuPanel.iconDatabase, databaseV.menuPanel.databaseButton);
				ResizeController.resizeImageButton(databaseV.originalPanelSize, databaseV,
						databaseV.menuPanel.iconLDmode, databaseV.menuPanel.switchThemeButton);
				ResizeController.resizePanel(databaseV.originalPanelSize, databaseV, databaseV.menuPanel,
						databaseV.menuPanelSize, databaseV.menuPanel.menupanelpoint);
				ResizeController.resizePanel(databaseV.originalPanelSize, databaseV, databaseV.centerPanel,
						databaseV.centerPanelSize, databaseV.centerpanelpoint);
			}
		});
	}

	/**
	 * Opens the sign-up panel.
	 * 
	 * @param signupV The SignUpView object to be displayed.
	 */
	public static void openSignUp(SignUpView signupV) {
		SwingUtilities.invokeLater(() -> signupV.setVisible(true));
	}

	/**
	 * Opens the database loader panel.
	 * 
	 * @param dbV The DownloadDataDBView object to be displayed.
	 */
	public static void openDBloader(DownloadDataDBView dbV) {
		SwingUtilities.invokeLater(() -> dbV.setVisible(true));
	}

	/**
	 * Opens the account icon loader panel.
	 * 
	 * @param accountIconV The AccountIconView object to be displayed.
	 */
	public static void openAccountIconPanel(AccountIconView accountIconV) {
		AccountController.showImages();
		SwingUtilities.invokeLater(() -> accountIconV.setVisible(true));
	}
}
