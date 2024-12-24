package bgtransport.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A utility class for resizing an image.
 * This class loads an image from a specified file path and provides functionality to resize it
 * to a new width and height, while maintaining smooth scaling.
 */
public class ResizableImage {

    private BufferedImage originalImage;
    private Image scaledImage;

    /**
     * Constructs a ResizableImage object by loading an image from the specified file path.
     * 
     * @param imagePath the path to the image file to be loaded.
     * @throws IOException if an error occurs while reading the image file.
     */
    public ResizableImage(File imagePath) {
        try {
            originalImage = ImageIO.read(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    /**
     * Resizes the original image to the specified width and height.
     * The resized image will use smooth scaling to ensure quality.
     * 
     * @param newWidth  the new width for the resized image.
     * @param newHeight the new height for the resized image.
     */
    public void resizeImage(int newWidth, int newHeight) {
        if (originalImage != null) {
            scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        }
    }
    
    /**
     * Gets the resized (scaled) image.
     * 
     * @return the scaled image after calling the resizeImage method.
     */
    public Image getScaledImage() {
        return scaledImage;
    }
}
