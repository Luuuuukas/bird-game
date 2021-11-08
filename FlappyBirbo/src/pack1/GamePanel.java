package pack1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

public class GamePanel extends JPanel implements KeyListener, ActionListener {


    private final int width = 800, height = 800;
    private final int wallwidth = 50;
    private int birdHeight = height / 4;
    private int birdV = 0;
    private int birdA = 8;
    private int score = 0;
    private final int[] wallX = {width, width + width / 2};
    private final int[] gap = {(int)(Math.random() * (height - 150)), (int)(Math.random() * (height - 100))};
    private boolean gameOver = false;
    private final Timer time = new Timer(40, this);


    public GamePanel(){
        setSize(width, height);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(!gameOver)
        {
            logic();
            drawWall(g);
            try {
                drawBird(g);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.setColor(Color.YELLOW);
            g.drawString("SCORE: " + score, width / 2, 15);
        } else {
            g.setColor(Color.YELLOW);
            g.drawString("PRESS R TO RESTART, THEN S TO START, SCORE: " + score , width / 2, 15);
        }

    }

    public void drawBird(Graphics g) throws IOException {

        BufferedImage image = ImageIO.read(new File("bird2.png"));
        g.drawImage(image, 75, birdHeight + birdV, this);

    }

    public void drawWall(Graphics g){

        for(int i = 0; i<2; i++){
            g.setColor(Color.RED);
            g.fillRect(wallX[i], 0, wallwidth, height);

            g.setColor(Color.BLACK);
            g.fillRect(wallX[i], gap[i], wallwidth, 150);
        }

    }

    public void actionPerformed(ActionEvent e){

        GameLogic gameLogic = new GameLogic();

        birdA = gameLogic.birdAceleration(birdA);
        birdV = gameLogic.birdVelocity(birdA, birdV);
        gameLogic.wallXCoordinate(wallX);

        repaint();
    }

    private void logic() {

        for (int i = 0; i < 2; i++) {

            if (wallX[i] < 100 && wallX[i] + wallwidth >= 100 || wallX[i] <= 75 && wallX[i] + wallwidth >= 75)
                if (birdHeight + birdV <= gap[i] || birdHeight + birdV + 25 >= gap[i] + 150)
                    gameOver = true;

                if (birdHeight + birdV <= 0 || birdHeight + birdV + 25 >= height)
                    gameOver = true;

                if (75 == wallX[i] + wallwidth)
                    score++;

                if (wallX[i] + wallwidth <= 0) {
                    wallX[i] = width;
                    gap[i] = (int) (Math.random() * (height - 150));
                }
        }

    }

    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == e.VK_SPACE){
            birdA = -10;
        }

        if(code == e.VK_S){
            time.start();
        }

        if(code == e.VK_R){
            time.stop();
            birdHeight = height / 4;
            birdV = 0;
            birdA = 8;
            score = 0;
            wallX[0] = width;
            wallX[1] = width + width / 2;
            gap[0] = (int)(Math.random() * (height - 150));
            gap[1] = (int)(Math.random() * (height - 150));
            gameOver = false;

            repaint();
        }
    }

    public void keyTyped(KeyEvent e){
    }

    public void keyReleased(KeyEvent e){
    }

}
