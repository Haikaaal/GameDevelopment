package Util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Main.Game;
import Entities.Goblin;

import static Util.Constant.EnemyConstants.GOBLIN;


public class LoadSave {
	
	public static final String PLAYER_ATLAS = "cobacoba2.png";
	public static final String LEVEL_ATLAS = "GreenlandsTileset.png";
	public static final String LEVEL_ONE_DATA = "testing1.png";
	public static final String MENU_BUTTONS = "GUI3.png";
	public static final String GOBLIN_SPRITE = "crabby_sprite.png";
	public static final String MENU_BACKGROUND_IMG = "47412.jpg";
	public static final String LOGO = "rodin.png";
	
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
	}
	
	public static ArrayList<Goblin> GetGoblins() {
		BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
		ArrayList<Goblin> list = new ArrayList<>();
		for (int j = 0; j < img.getHeight(); j++)
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getGreen();
				if (value == GOBLIN)
					list.add(new Goblin(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
			}
		return list;

	}
	
	public static int[][] GetLevelData() {
		BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
		int[][] lvlData = new int[img.getHeight()][img.getWidth()];

		for (int j = 0; j < img.getHeight(); j++)
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if (value >= 100)
					value = 0;
				lvlData[j][i] = value;
			}
		return lvlData;

	}
}
