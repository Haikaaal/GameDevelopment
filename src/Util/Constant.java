package Util;

import Main.Game;

public class Constant {
	public static class UI {
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 50;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
	}
	
    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int HIT = 3;
        public static final int ATTACK = 4;

        public static int GetSpriteAmount(int playerAction) {
            switch (playerAction) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                    return 2;
                case ATTACK:
                    return 3;
                default:
                    return 1;
            }
        }
    }
    
    public static class EnemyConstants {
		public static final int GOBLIN = 0;

		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;

		public static final int GOBLIN_WIDTH_DEFAULT = 72;
		public static final int GOBLIN_HEIGHT_DEFAULT = 32;

		public static final int GOBLIN_WIDTH = (int) (GOBLIN_WIDTH_DEFAULT * Game.SCALE);
		public static final int GOBLIN_HEIGHT = (int) (GOBLIN_HEIGHT_DEFAULT * Game.SCALE);
		

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {

			switch (enemy_type) {
			case GOBLIN:
				switch (enemy_state) {
				case IDLE:
					return 9;
				case RUNNING:
					return 6;
				case ATTACK:
					return 7;
				case HIT:
					return 4;
				case DEAD:
					return 5;
				}
			}
			return 0;
		}
	}

}