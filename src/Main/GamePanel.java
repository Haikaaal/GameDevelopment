package Main;

import Input.KeyboardInputs;
import Input.MouseInput;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private int xMove = 100, yMove = 100;
    public GamePanel() {
        MouseInput mouseInput = new MouseInput(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    public void changeXMove (int value) {
        this.xMove += value;
        repaint();
    }

    public void changeYMove (int value) {
        this.yMove += value;
        repaint();
    }

    public void setRectPos (int x , int y) {
        this.xMove = x;
        this.yMove = y;
        repaint();
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.fillRect(xMove, yMove, 200, 50);

    }
}
