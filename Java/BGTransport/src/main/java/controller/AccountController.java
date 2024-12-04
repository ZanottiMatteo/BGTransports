package controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.json.JSONObject;

import view.AccountIconView;

public class AccountController {

	public AccountController() {

	}

	public static void showImages() {
		int x = 1;
		for (JLabel label : AccountIconView.getLabelList()) {
			String str = String.valueOf(x);
			label.setIcon(getAccountIcon(str));
			x++;
		}
	}

	public static ImageIcon getAccountIcon(String number) {
		try (FileReader openJSON = new FileReader("json/AccountIcon.json")) {
			StringBuilder sb = new StringBuilder();
			int c;
			while ((c = openJSON.read()) != -1) {
				sb.append((char) c);
			}
			JSONObject root = new JSONObject(sb.toString());

			JSONObject AccImage = root.getJSONObject(number);

			String logo = AccImage.getString("image");
			String imageUrl;

			imageUrl = logo;

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
				BufferedImage image = ImageIO.read(inputStream);
				image.getScaledInstance(150, 150, Image.SCALE_REPLICATE);
				inputStream.close();
				return new ImageIcon(image);
			} else
				System.out.println("error");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
