package Main;

//CongratulationPanel.java

import javax.swing.*;
import java.awt.*;

public class CongratulationPanel extends JPanel {
 public CongratulationPanel() {
     setLayout(new BorderLayout());
     JLabel congratsLabel = new JLabel("Congratulations, you have won!");
     congratsLabel.setHorizontalAlignment(SwingConstants.CENTER);
     add(congratsLabel, BorderLayout.CENTER);
 }
}
