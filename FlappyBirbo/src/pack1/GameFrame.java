package pack1;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

    public GameFrame(){
        add(new GamePanel());
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GameFrame();
    }

}
