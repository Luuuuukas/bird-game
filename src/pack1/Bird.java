package pack1;

import junit.framework.TestCase;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends BirdImage{

    private int birdG = 1;
    private int birdA = 10;

    public String chirpChirp(){
        return "Bird goes chirp chirp";
    }

    /*
    private static final Bird instance = new Bird();

    private Bird(BufferedImage image, int birdG, int birdA){
        super(image);
        this.birdG = birdG;
        this.birdA = birdA;
    }

    public static Bird getInstance(){
        return instance;
    }
    */

    public Bird(BufferedImage image, int birdG, int birdA) throws IOException {
        super(image);
        this.birdG = birdG;
        this.birdA = birdA;
    }

    public Bird() throws IOException {
    }

    public int getBirdG() {
        return birdG;
    }

    public void setBirdG(int birdG) {
        this.birdG = birdG;
    }

    public int getBirdA() {
        return birdA;
    }

    public void setBirdA(int birdA) {
        this.birdA = birdA;
    }
}
