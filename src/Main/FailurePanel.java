package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FailurePanel extends JPanel {
    private GamePanel gamePanel;

    public FailurePanel(GamePanel gamePanel) { 
        this.gamePanel = gamePanel; 
        setLayout(new BorderLayout());

        JLabel failureLabel = new JLabel("You failed!");
        failureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(failureLabel, BorderLayout.CENTER);

        JButton returnButton = new JButton("Retry");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.getGame().showGamePanel();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(returnButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
