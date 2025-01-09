package bgtransport.controller;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import bgtransport.model.UserQueryDB;
import bgtransport.view.UserView;
import bgtransport.view.UserWidget;

public class UserInfoController {

    /**
     * Sets the profile icon for the user. If a custom image is available, it uses
     * the user-provided image; otherwise, it sets a default placeholder image.
     */
    public static void setProfileIcon() {
        int n = MainController.userlogged.getImageAccount();
        System.out.println("n  " + n);
        if (n != 0) {
            String str = String.valueOf(n);
            UserView.chooseIcon.setIcon(null);
            UserView.image = new ImageIcon(AccountController.getAccountIcon(str, 252));
            UserView.profilePhoto.setIcon(UserView.image);
            UserWidget.image = new ImageIcon(AccountController.getAccountIcon(str, 128));
            UserWidget.accounticon.setIcon(UserWidget.image);
        } else {
            UserView.profilePhoto.setIcon(null);
           UserView.chooseIcon.setIcon(new ImageIcon(AccountController.class.getResource("/images/Addimage.png")));
        }
    }

    /**
     * Disables all text fields in the UserView, making them non-editable and 
     * populating them with placeholder text.
     */
    public static void disableTextFields() {
        toggleTextFields(false);
    }

    /**
     * Enables all text fields in the UserView, restoring their editability and 
     * clearing the placeholder text.
     */
    public static void enableTextFields() {
        toggleTextFields(true);
    }

    /**
     * Toggles the editability of all text fields in the UserView. If disabled, 
     * placeholder text is displayed; otherwise, text fields are cleared and made editable.
     *
     * @param isEnabled true to enable text fields, false to disable them.
     */
    private static void toggleTextFields(boolean isEnabled) {
        String email = null;
        JTextField[] textFields = { 
            UserView.tfName, UserView.tfSurname, UserView.tfUsername, 
            UserView.tfBirthday, UserView.tfAddress, UserView.tfCity, 
            UserView.tfZip, UserView.tfEmail // Email is always the last field and cannot be modified directly.
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
                    System.out.println(MainController.userlogged.getEmail());
                    email = MainController.userlogged.getEmail();
                    textFields[i].setText(UserQueryDB.getUserDetailsByEmail(email).get(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                textFields[i].setEditable(false);
            }
        }
    }

    /**
     * Updates the logged-in user's details based on the content of the text fields in the UserView.
     *
     * @throws SQLException if an error occurs while updating user details in the database.
     */
    public static void setDataFromTF() throws SQLException {
        JTextField[] textFields = { 
            UserView.tfName, UserView.tfSurname, UserView.tfUsername, 
            UserView.tfBirthday, UserView.tfAddress, UserView.tfCity, 
            UserView.tfZip 
        };
        if (!textFields[0].getText().isEmpty())
        	MainController.userlogged.setName(textFields[0].getText());
        if (!textFields[1].getText().isEmpty())
        	MainController.userlogged.setSurname(textFields[1].getText());
        if (!textFields[2].getText().isEmpty())
        	MainController.userlogged.setUsername(textFields[2].getText());
        if (!textFields[3].getText().isEmpty())
        	MainController.userlogged.setBirthday(textFields[3].getText());
        if (!textFields[4].getText().isEmpty())
        	MainController.userlogged.setAddress(textFields[4].getText());
        if (!textFields[5].getText().isEmpty())
        	MainController.userlogged.setCity(textFields[5].getText());
        if (!textFields[6].getText().isEmpty())
        	MainController.userlogged.setZipCode(textFields[6].getText());
    }

    /**
     * Displays user data in the UserWidget component, including username, 
     * full name, email, and profile icon.
     */
    public static void showDataWidget() {
        UserWidget.usernamelabel.setVisible(true);
        UserWidget.usernamelabel.setText(MainController.userlogged.getUsername());
        UserWidget.complnamelabel.setVisible(true);
        UserWidget.complnamelabel
                .setText(MainController.userlogged.getName() + " " + MainController.userlogged.getSurname());
        UserWidget.emaillabel.setVisible(true);
        UserWidget.emaillabel.setText(MainController.userlogged.getEmail());
        UserWidget.accounticon.setVisible(true);
        UserWidget.titlelabel.setVisible(true);
        UserWidget.errorlabel.setVisible(false);
    }
    
    /**
     * Hides user data from the UserWidget component and clears all labels.
     * Displays an error message in place of user details.
     */
    public static void hideDataWidget() {
        // Hide the widgets
        UserWidget.usernamelabel.setVisible(false);
        UserWidget.complnamelabel.setVisible(false);
        UserWidget.emaillabel.setVisible(false);
        UserWidget.accounticon.setVisible(false);
        UserWidget.titlelabel.setVisible(false);
        UserWidget.errorlabel.setVisible(true);
        
        // Clear the content of the labels
        UserWidget.usernamelabel.setText("");
        UserWidget.complnamelabel.setText("");
        UserWidget.emaillabel.setText("");
    }

}
