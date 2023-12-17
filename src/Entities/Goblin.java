package Entities;

import static Util.Constant.EnemyConstants.*;

import Main.Game;

public class Goblin extends Enemy {

	public Goblin(float x, float y) {
		super(x, y, GOBLIN_WIDTH, GOBLIN_HEIGHT, GOBLIN);
		initHitbox(x, y, (int) (22 * Game.SCALE), (int) (28 * Game.SCALE));
	}

}