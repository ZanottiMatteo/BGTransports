package bgtransport.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.json.JSONException;
import org.json.JSONObject;

import bgtransport.view.AccountIconView;

/**
 * Controller class responsible for managing account-related image icons in the
 * application. It handles the loading, processing, and displaying of user
 * profile icons in circular shape.
 */
public class AccountController {

	/**
	 * Displays the account icons on the buttons of the AccountIconView. This method
	 * retrieves the images, processes them, and sets them as icons for each button
	 * in the view.
	 */
	public static void showImages() {
		int x = 1;
		// Iterate over the list of buttons and set the corresponding account icon
		for (JButton button : AccountIconView.getButtonList()) {
			String str = String.valueOf(x);
			// Set the icon for each button
			button.setIcon(new ImageIcon(getAccountIcon(str, 128)));
			x++;
		}
	}

	/**
	 * Fetches the account icon image for the given account number, processes it
	 * into a circular shape, and returns the processed image.
	 * 
	 * @param number   The account number (as a string) used to retrieve the icon.
	 * @param diameter The desired diameter of the circular icon.
	 * @return A circular-shaped image for the given account number or null if there
	 *         was an error.
	 */
	public static Image getAccountIcon(String number, int diameter) {
		try (FileReader openJSON = new FileReader("json/AccountIcon.json")) {
			StringBuilder sb = new StringBuilder();
			int c;
			// Read the contents of the JSON file
			while ((c = openJSON.read()) != -1) {
				sb.append((char) c);
			}
			// Parse the JSON data
			JSONObject root = new JSONObject(sb.toString());
			JSONObject accImage = root.getJSONObject(number);

			String logo = accImage.getString("image");
			String imageUrl = logo;

			// Create a connection to the image URL
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(1000);
			connection.setReadTimeout(1000);

			// Check if the HTTP response is OK (status 200)
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Get the image input stream
				InputStream inputStream = connection.getInputStream();
				BufferedImage originalImage = ImageIO.read(inputStream);

				// Create a new BufferedImage with circular clipping
				BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = circularImage.createGraphics();

				// Enable high-quality rendering
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Create a circular clip area
				g2d.setClip(new Ellipse2D.Float(0, 0, diameter, diameter));

				// Draw the original image scaled into the circular area
				g2d.drawImage(originalImage, 0, 0, diameter, diameter, null);

				g2d.dispose();
				inputStream.close();
				return circularImage; // Return the circular image
			} else {
				System.out.println("Error: Unable to fetch image, Response Code: " + responseCode);
			}
		} catch (JSONException | IOException e) {
			// Return null if there's an error during processing or fetching
			return null;
		}
		return null;
	}
}
