package bgtransport.controller;

/**
 * The RoleController class manages the visibility of various menu buttons based
 * on the user's role. This method adjusts the visibility of buttons across
 * different views depending on the role defined in the system.
 */
public class RoleController {

	/**
	 * This method checks the current user's role and adjusts the visibility of the
	 * buttons in the menu panels across different views accordingly.
	 */
	public static void roleManager() {
		int role = MainController.userlogged.getRole();
		System.out.println("ruolo " + role);
		switch (role) {
		case 0:
			MainController.homeV.menuPanel.lineButton.setVisible(false);
			MainController.homeV.menuPanel.databaseButton.setVisible(false);
			MainController.homeV.menuPanel.mapButton.setVisible(false);
			MainController.mapV.menuPanel.lineButton.setVisible(false);
			MainController.mapV.menuPanel.databaseButton.setVisible(false);
			MainController.mapV.menuPanel.mapButton.setVisible(false);
			MainController.userV.menuPanel.lineButton.setVisible(false);
			MainController.userV.menuPanel.databaseButton.setVisible(false);
			MainController.userV.menuPanel.mapButton.setVisible(false);
			MainController.lineV.menuPanel.lineButton.setVisible(false);
			MainController.lineV.menuPanel.databaseButton.setVisible(false);
			MainController.lineV.menuPanel.mapButton.setVisible(false);
			MainController.databaseV.menuPanel.lineButton.setVisible(false);
			MainController.databaseV.menuPanel.databaseButton.setVisible(false);
			MainController.databaseV.menuPanel.mapButton.setVisible(false);
			break;

		case 1:
			MainController.homeV.menuPanel.lineButton.setVisible(true);
			MainController.homeV.menuPanel.databaseButton.setVisible(false);
			MainController.homeV.menuPanel.mapButton.setVisible(true);
			MainController.mapV.menuPanel.lineButton.setVisible(true);
			MainController.mapV.menuPanel.databaseButton.setVisible(false);
			MainController.mapV.menuPanel.mapButton.setVisible(true);
			MainController.userV.menuPanel.lineButton.setVisible(true);
			MainController.userV.menuPanel.databaseButton.setVisible(false);
			MainController.userV.menuPanel.mapButton.setVisible(true);
			MainController.lineV.menuPanel.lineButton.setVisible(true);
			MainController.lineV.menuPanel.databaseButton.setVisible(false);
			MainController.lineV.menuPanel.mapButton.setVisible(true);
			MainController.databaseV.menuPanel.lineButton.setVisible(true);
			MainController.databaseV.menuPanel.databaseButton.setVisible(false);
			MainController.databaseV.menuPanel.mapButton.setVisible(true);
			break;

		case 2:
			MainController.homeV.menuPanel.lineButton.setVisible(true);
			MainController.homeV.menuPanel.databaseButton.setVisible(true);
			MainController.homeV.menuPanel.mapButton.setVisible(true);
			MainController.mapV.menuPanel.lineButton.setVisible(true);
			MainController.mapV.menuPanel.databaseButton.setVisible(true);
			MainController.mapV.menuPanel.mapButton.setVisible(true);
			MainController.userV.menuPanel.lineButton.setVisible(true);
			MainController.userV.menuPanel.databaseButton.setVisible(true);
			MainController.userV.menuPanel.mapButton.setVisible(true);
			MainController.lineV.menuPanel.lineButton.setVisible(true);
			MainController.lineV.menuPanel.databaseButton.setVisible(true);
			MainController.lineV.menuPanel.mapButton.setVisible(true);
			MainController.databaseV.menuPanel.lineButton.setVisible(true);
			MainController.databaseV.menuPanel.databaseButton.setVisible(true);
			MainController.databaseV.menuPanel.mapButton.setVisible(true);
			break;

		}
	}
}
