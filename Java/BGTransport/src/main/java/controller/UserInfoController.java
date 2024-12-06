package controller;

import view.UserView;
import view.UserWidget;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import model.QueryDB;

public class UserInfoController {

	public static void setProfileIcon() {
		int n = LoginController.userlogged.getImageAccount();
		if (n != 0) {
			String str = String.valueOf(n);
			UserView.chooseIcon.setIcon(null);
			UserView.profilePhoto.setIcon(new ImageIcon(AccountController.getAccountIcon(str, 242)));
			UserWidget.accounticon.setIcon(new ImageIcon(AccountController.getAccountIcon(str, 128)));
		} else {
			UserView.chooseIcon.setIcon(new ImageIcon(AccountController.class.getResource("/images/Addimage.png")));
		}
	}

	/**
	 * Disables all the text fields in the UserView, making them non-editable and
	 * displaying a placeholder text.
	 */
	public static void disableTextFields() {
		toggleTextFields(false);
	}

	/**
	 * Enables all the text fields in the UserView, restoring their editability and
	 * clearing the placeholder text.
	 */
	public static void enableTextFields() {
		toggleTextFields(true);
	}

	/**
	 * Toggles the editability of all text fields in the UserView, and sets/clears
	 * placeholder text based on the state.
	 *
	 * @param isEnabled True to enable, false to disable.
	 */
	private static void toggleTextFields(boolean isEnabled) {
		String email = null;
		JTextField[] textFields = { UserView.tfName, UserView.tfSurname, UserView.tfUsername, UserView.tfBirthday,
				UserView.tfAddress, UserView.tfCity, UserView.tfZip, UserView.tfEmail // It always have to be the last
																						// because it can't be modified
																						// directly.
		};

		for (int i = 0; i < textFields.length; i++) {
			if (isEnabled) {
				if (i != textFields.length - 1) {
					// Restore original content and make editable
					textFields[i].setText(""); // Clear the placeholder or keep existing text
					textFields[i].setEditable(true);
				}
			} else {
				// Set placeholder text and make non-editable

				try {
					System.out.println(LoginController.userlogged.getEmail());
					email = LoginController.userlogged.getEmail();
					textFields[i].setText(QueryDB.getUserDetailsByEmail(email).get(i));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				textFields[i].setEditable(false);
			}
		}
	}

	public static void setDataFromTF() throws SQLException {
		JTextField[] textFields = { UserView.tfName, UserView.tfSurname, UserView.tfUsername, UserView.tfBirthday,
				UserView.tfAddress, UserView.tfCity, UserView.tfZip };
		if (!textFields[0].getText().isEmpty())
			LoginController.userlogged.setName(textFields[0].getText());
		if (!textFields[1].getText().isEmpty())
			LoginController.userlogged.setSurname(textFields[1].getText());
		if (!textFields[2].getText().isEmpty())
			LoginController.userlogged.setUsername(textFields[2].getText());
		if (!textFields[3].getText().isEmpty())
			LoginController.userlogged.setBirthday(textFields[3].getText());
		if (!textFields[4].getText().isEmpty())
			LoginController.userlogged.setAddress(textFields[4].getText());
		if (!textFields[5].getText().isEmpty())
			LoginController.userlogged.setCity(textFields[5].getText());
		if (!textFields[6].getText().isEmpty())
			LoginController.userlogged.setZIPcode(textFields[6].getText());
	}

	public static void showDataWidget() {
		UserWidget.usernamelabel.setVisible(true);
		UserWidget.usernamelabel.setText(LoginController.userlogged.getUsername());
		UserWidget.complnamelabel.setVisible(true);
		UserWidget.complnamelabel
				.setText(LoginController.userlogged.getName() + " " + LoginController.userlogged.getSurname());
		UserWidget.emaillabel.setVisible(true);
		UserWidget.emaillabel.setText(LoginController.userlogged.getEmail());
		UserWidget.accounticon.setVisible(true);
		UserWidget.titlelabel.setVisible(true);
		UserWidget.errorlabel.setVisible(false);
	}
}
