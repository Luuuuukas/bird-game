package pack1;

import junit.framework.TestCase;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class BirdImage{

    protected BufferedImage image;
    private String imageName = "bird2.png";
    private String imageColor = "green";

    private void printImageName(){
        System.out.println("Image name is: " + imageName);
    }
    private void printImageColour(){
        System.out.println("Image primary color is " + imageColor);
    }

    public BirdImage(BufferedImage image, String imageName, String imageColor) throws IOException {
        this.image = image;
        this.imageName = imageName;
        this.imageColor = imageColor;
    }

    public BirdImage(BufferedImage image) throws IOException {
        this.image = image;
    }

    public BirdImage() throws IOException {
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageColor() {
        return imageColor;
    }

    public void setImageColor(String imageColor) {
        this.imageColor = imageColor;
    }
}
