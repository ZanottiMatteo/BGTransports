package controller;

import view.UserView;

import java.sql.SQLException;

import javax.swing.JTextField;

import model.QueryDB;
import model.RegisteredUser;

public class UserInfoController {
    // Default placeholder text when fields are disabled
    private static final String DISABLED_TEXT = "Field disabled";


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
        JTextField[] textFields = {
        	UserView.tfName,
        	UserView.tfSurname,
        	UserView.tfUsername,
        	UserView.tfBirthday,
            UserView.tfAddress,
            UserView.tfCity,
            UserView.tfZip,
            UserView.tfEmail
        };

        for (int i = 0; i < textFields.length; i++) {
            if (isEnabled) {
                // Restore original content and make editable
            	textFields[i].setText(""); // Clear the placeholder or keep existing text
            	textFields[i].setEditable(true);
            } else {
                // Set placeholder text and make non-editable
            	
            	try {
            		System.out.println(LoginController.user.getEmail());
					textFields[i].setText(QueryDB.getUserDetailsByEmail(LoginController.user.getEmail()).get(i));
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	textFields[i].setEditable(false);
            }
        }
    }
}
