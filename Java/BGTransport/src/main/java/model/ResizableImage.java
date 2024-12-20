package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResizableImage{

	private BufferedImage originalImage;
    private Image scaledImage;

    public ResizableImage(File imagePath) {
        try {
            originalImage = ImageIO.read(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void resizeImage(int newWidth, int newHeight) {
        if (originalImage != null) {
            scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        }
    }
    
    public Image getScaledImage() {
        return scaledImage;
    }
}
