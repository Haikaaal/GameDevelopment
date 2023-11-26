package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import Input.KeyboardInputs;
import Input.MouseInput;




public class GamePanel extends JPanel {

    private MouseInput mouseInputs;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        mouseInputs = new MouseInput(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void updateGame() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame () {
        return game;
    }

}