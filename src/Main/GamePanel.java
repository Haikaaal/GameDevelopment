package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import Input.KeyboardInputs;
import Input.MouseInput;
import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;

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
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
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