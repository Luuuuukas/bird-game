package pack1;

import javax.swing.JFrame;
import java.io.IOException;

public class GameFrame extends JFrame{

    public GameFrame() throws IOException {
        add(new GamePanel());
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        new GameFrame();
    }

}
