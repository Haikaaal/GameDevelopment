package Main;

import javax.swing.JFrame;

public class GameWindow{
    private JFrame jFrame;
    public GameWindow(GamePanel gamePanel) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);

    }
}
