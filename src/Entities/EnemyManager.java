package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameStates.Playing;
import Util.LoadSave;
import static Util.Constant.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] goblinArr;
	private ArrayList<Goblin> goblins = new ArrayList<>();

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
		addEnemies();
	}

	private void addEnemies() {
		goblins = LoadSave.GetGoblins();
		System.out.println("size of crabs: " + goblins.size());
	}

	public void update() {
		for (Goblin c : goblins)
			c.update();
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawGoblins(g, xLvlOffset);
	}

	private void drawGoblins(Graphics g, int xLvlOffset) {
		for (Goblin c : goblins)
			g.drawImage(goblinArr[c.getEnemyState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset, (int) c.getHitbox().y, GOBLIN_WIDTH, GOBLIN_HEIGHT, null);

	}

	private void loadEnemyImgs() {
		goblinArr = new BufferedImage[5][9];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.GOBLIN_SPRITE);
		for (int j = 0; j < goblinArr.length; j++)
			for (int i = 0; i < goblinArr[j].length; i++)
				goblinArr[j][i] = temp.getSubimage(i * GOBLIN_WIDTH_DEFAULT, j * GOBLIN_HEIGHT_DEFAULT, GOBLIN_WIDTH_DEFAULT, GOBLIN_HEIGHT_DEFAULT);
	}
}