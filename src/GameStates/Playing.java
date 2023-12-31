package GameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Entities.Player;
import Entities.EnemyManager;
import Levels.LevelManager;
import Main.Game;
import Util.LoadSave;

public class Playing extends State implements StateMethods {
	private Player player;
	private EnemyManager enemyManager;
	private LevelManager levelManager;
	private BufferedImage bgimg;
	
	private int xLvlOffset;
	private int leftBorder = (int) (0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int) (0.8 * Game.GAME_WIDTH);
	private int lvlTilesWide = LoadSave.GetLevelData()[0].length;
	private int maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
	private int maxLvlOffsetX = maxTilesOffset * Game.TILES_SIZE;

	public Playing(Game game) {
		super(game);
		initClasses();
		bgimg = LoadSave.GetSpriteAtlas(LoadSave.GAME_BACKGROUND);

	}

	private void initClasses() {
		levelManager = new LevelManager(game);
		enemyManager = new EnemyManager(this);
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (50 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());

	}

	@Override
	public void update() {
	    levelManager.update();
	    player.update();
	    enemyManager.update(levelManager.getCurrentLevel().getLevelData());
	    checkCloseToBorder();
	    checkWinCondition();
	    checkLoseCondition();

	}
	
	private void checkCloseToBorder() {
		int playerX = (int) player.getHitbox().x;
		int diff = playerX - xLvlOffset;

		if (diff > rightBorder)
			xLvlOffset += diff - rightBorder;
		else if (diff < leftBorder)
			xLvlOffset += diff - leftBorder;

		if (xLvlOffset > maxLvlOffsetX)
			xLvlOffset = maxLvlOffsetX;
		else if (xLvlOffset < 0)
			xLvlOffset = 0;

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(bgimg, 0,0,Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		levelManager.draw(g, xLvlOffset);
		player.render(g, xLvlOffset);
		enemyManager.draw(g, xLvlOffset);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			player.setAttacking(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_W:
            player.setUp(true);
            break;
        case KeyEvent.VK_S:
            player.setDown(true);
            break;
		case KeyEvent.VK_SPACE:
			player.setJump(true);
			break;
		case KeyEvent.VK_BACK_SPACE:
			GameState.state = GameState.MENU;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_W:
            player.setUp(false);
            break;
        case KeyEvent.VK_S:
            player.setDown(false);
            break;
		case KeyEvent.VK_SPACE:
			player.setJump(false);
			break;

		}

	}

	private void checkWinCondition() {
	    int tilesWide = levelManager.getCurrentLevel().getLevelData()[0].length;
	    int totalLevelWidth = tilesWide * Game.TILES_SIZE - 31;

	    int playerRightX = (int) (player.getHitbox().x + player.getHitbox().width);
	    if (playerRightX >= totalLevelWidth) {
	        game.getGameWindow().showCongratulationPanel();
	        player.getHitbox().x = 0;
	        player.resetDirBooleans();
	    }
	}

	private void checkLoseCondition() {
	    int bottomPanelY = Game.GAME_HEIGHT;

	    int playerBottomY = (int) (player.getHitbox().y + player.getHitbox().height);
	    if (playerBottomY >= 626) {
	        game.getGameWindow().showFailurePanel();
	        player.getHitbox().x = 0;
	        player.getHitbox().y = 0;
	        player.resetDirBooleans();
	    }
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}

}