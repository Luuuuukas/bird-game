package pack1;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class BirdTest{

    @Test
    public void testChirpFunction() throws IOException {

        Bird bird = new Bird();

        String result = bird.chirpChirp();

        Assert.assertEquals("Bird goes chirp chirp", result);

    }

    @Test
    public void testRecommendedBirdFlapAndGravityInputs() throws IOException { //Bird bird

        Bird bird = new Bird();

        boolean recommended;

        System.out.println("Enter gravity and bird flap strenght (recommended values 1 and 10) (limit is 20 and 20)");

        recommended = bird.getBirdG() == 1 && bird.getBirdA() == 10;

        Assert.assertTrue(recommended);
    }

    @Test
    public void testImageName() throws IOException{

        Bird bird = new Bird();

        Assert.assertEquals(bird.getImageName(), "bird2.png");
    }

}
