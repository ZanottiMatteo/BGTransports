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

public class AccountController {

	public static void showImages() {
		int x = 1;
		for (JButton button : AccountIconView.getButtonList()) {
			String str = String.valueOf(x);
			button.setIcon(new ImageIcon (getAccountIcon(str, 128)));
			x++;
		}
	}

	public static Image getAccountIcon(String number, int diameter) {
	    try (FileReader openJSON = new FileReader("json/AccountIcon.json")) {
	        StringBuilder sb = new StringBuilder();
	        int c;
	        while ((c = openJSON.read()) != -1) {
	            sb.append((char) c);
	        }
	        JSONObject root = new JSONObject(sb.toString());
	        JSONObject accImage = root.getJSONObject(number);

	        String logo = accImage.getString("image");
	        String imageUrl = logo;

	        URL url = new URL(imageUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(1000);
	        connection.setReadTimeout(1000);

	        // Check the HTTP response code
	        int responseCode = connection.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // Get the image stream
	            InputStream inputStream = connection.getInputStream();
	            BufferedImage originalImage = ImageIO.read(inputStream);

	            // Crea una nuova immagine tonda
	            BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
	            Graphics2D g2d = circularImage.createGraphics();

	            // Abilita rendering di alta qualità
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	            // Crea una maschera circolare
	            g2d.setClip(new Ellipse2D.Float(0, 0, diameter, diameter));

	            // Ridimensiona e disegna l'immagine al centro del cerchio
	            g2d.drawImage(originalImage, 0, 0, diameter, diameter, null);

	            g2d.dispose();
	            inputStream.close();
	            return circularImage; // Restituisci l'immagine tonda
	        } else {
	            System.out.println("Error: Unable to fetch image, Response Code: " + responseCode);
	        }
	    } catch (JSONException | IOException e) {
	        // Return null or a default image if the key is not found
	        return null;
	    } 
	    return null;
	}
}
