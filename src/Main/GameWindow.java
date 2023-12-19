package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow {
    private JFrame jFrame;
    private JPanel gamePanel;
    private CongratulationPanel congratulationPanel;
    private FailurePanel failurePanel;

    public GameWindow(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        congratulationPanel = new CongratulationPanel();
        failurePanel = new FailurePanel(gamePanel);

        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);

        showGamePanel();

        jFrame.setVisible(true);
        jFrame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }
        });
    }

    public void showGamePanel() {
        jFrame.getContentPane().removeAll();
        jFrame.add(gamePanel);
        jFrame.pack();
    }

    public void showCongratulationPanel() {
        jFrame.getContentPane().removeAll();
        jFrame.add(congratulationPanel);
        jFrame.pack();
    }

    public void showFailurePanel() {
        jFrame.getContentPane().removeAll();
        jFrame.add(failurePanel);
        jFrame.pack();
    }
}
