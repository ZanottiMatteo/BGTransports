package controller;

import view.UserView;

import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import model.QueryDB;
import model.RegisteredUser;

public class UserInfoController {
    
	private static String email = null;
	
    public static void setProfileIcon() {
		int n = LoginController.user.getImageAccount();
    	if (n != 0) {
    	String str = String.valueOf(n);
    	UserView.chooseIcon.setIcon(null);
    	UserView.profilePhoto.setIcon(new ImageIcon (AccountController.getAccountIcon(str, 242, 2)));
    	} else UserView.chooseIcon.setIcon(new ImageIcon(AccountController.class.getResource("/images/Addimage.png")));
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
        JTextField[] textFields = {	
        	UserView.tfName,
        	UserView.tfSurname,
        	UserView.tfUsername,
        	UserView.tfBirthday,
            UserView.tfAddress,
            UserView.tfCity,
            UserView.tfZip,
            UserView.tfEmail // It always have to be the last because it can't be modified directly.
        };

        for (int i = 0; i < textFields.length; i++) {
            if (isEnabled) {
            	if (i != textFields.length-1) {
                // Restore original content and make editable
            	textFields[i].setText(""); // Clear the placeholder or keep existing text
            	textFields[i].setEditable(true);
            	}
            } else {
                // Set placeholder text and make non-editable
            	
            	try {
            		System.out.println(LoginController.user.getEmail());
            		email = LoginController.user.getEmail();
					textFields[i].setText(QueryDB.getUserDetailsByEmail(email).get(i));
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	textFields[i].setEditable(false);
            }
        }
    }
    
    public static void setDataFromTF() throws SQLException {
    	JTextField[] textFields = {
            	UserView.tfName,
            	UserView.tfSurname,
            	UserView.tfUsername,
            	UserView.tfBirthday,
                UserView.tfAddress,
                UserView.tfCity,
                UserView.tfZip
            };
    	if (!textFields[0].getText().isEmpty()) LoginController.user.setName(textFields[0].getText());
    	if (!textFields[1].getText().isEmpty())LoginController.user.setSurname(textFields[1].getText());
    	if (!textFields[2].getText().isEmpty())LoginController.user.setUsername(textFields[2].getText());
    	if (!textFields[3].getText().isEmpty())LoginController.user.setBirthday(textFields[3].getText());
    	if (!textFields[4].getText().isEmpty())LoginController.user.setAddress(textFields[4].getText());
    	if (!textFields[5].getText().isEmpty())LoginController.user.setCity(textFields[5].getText());
    	if (!textFields[6].getText().isEmpty())LoginController.user.setZIPcode(textFields[6].getText());
    }
}
