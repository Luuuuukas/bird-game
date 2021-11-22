package pack1;

import org.w3c.dom.ls.LSOutput;

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
import java.util.Scanner;

public class GamePanel extends JPanel implements KeyListener, ActionListener, Score {

    private final int width = 800, height = 800;
    private final int wallwidth = 50;
    private int birdHeight = height / 4;
    private int birdG;
    private int birdA;
    private int score = 0;
    private final int[] wallX = {width, width + width / 2};
    private final int[] gap = {(int)(Math.random() * (height - 150)), (int)(Math.random() * (height - 100))};
    private boolean gameOver = false;
    private final Timer time = new Timer(40, this);
    private int birdFlap;
    private int gravity;

    BufferedImage image = ImageIO.read(new File("bird2.png"));
    Bird bird = new Bird(image, birdG, birdA);

    public GamePanel() throws IOException {

        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter gravity and bird flap strenght (recommended values 1 and 10) (limit is 20 and 20)");

        bird.setBirdG(scanner.nextInt());
        bird.setBirdA(scanner.nextInt());

        birdFlap = bird.getBirdA();
        gravity = bird.getBirdG();

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
            printScoreInConsole();
            time.stop();
        }

    }

    public void drawBird(Graphics g) throws IOException {

        g.drawImage(bird.getImage(), 75, birdHeight + bird.getBirdG(), this);
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

        bird.setBirdA(gameLogic.birdAceleration(bird.getBirdA(), gravity));
        bird.setBirdG(gameLogic.birdGravity(bird.getBirdA(), bird.getBirdG()));

        gameLogic.wallXCoordinate(wallX);

        repaint();
    }

    private void logic() {

        for (int i = 0; i < 2; i++) {
            gameOver = GameLogic.gameStatus(wallX, wallwidth, birdHeight, bird.getBirdG(), gap, height, width);

            if(wallX[i] + wallwidth == 75)
                addScore();
        }

    }

    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == e.VK_SPACE){
            bird.setBirdA(bird.getBirdA() - birdFlap);
        }

        if(code == e.VK_S){
            time.start();
        }

        if(code == e.VK_R){
            time.stop();
            birdHeight = height / 4;
            bird.setBirdG(0);
            bird.setBirdA(8);
            resetScore();
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

    @Override
    public void printScoreInConsole() {
        System.out.println("FINAL SCORE IS:" + score);
    }

    @Override
    public void addScore() {
        score++;
    }

    @Override
    public void resetScore() {
        score = 0;
    }
}
