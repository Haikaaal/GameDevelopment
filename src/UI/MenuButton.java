package UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameStates.GameState;
import Util.LoadSave;
import static Util.Constant.UI.Buttons.*;

public class MenuButton {
	private int xPos, yPos, rowIndex, index;
	private int xOffsetCenter = B_WIDTH / 2;
	private GameState state;
	private BufferedImage[] imgs;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;

	public MenuButton(int xPos, int yPos, int rowIndex, GameState state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImgs();
		initBounds();
	}

	private void initBounds() {
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);

	}

	private void loadImgs() {
		imgs = new BufferedImage[4];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);

		int startY = rowIndex * B_HEIGHT_DEFAULT;

		for (int i = 0; i < imgs.length; i++) {
			int startX = i * B_WIDTH_DEFAULT;
			imgs[i] = new BufferedImage(B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT, BufferedImage.TYPE_INT_ARGB);
			Graphics g = imgs[i].getGraphics();
			g.drawImage(temp, 0, 0, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT, startX, startY, startX + B_WIDTH_DEFAULT, startY + B_HEIGHT_DEFAULT, null);
			g.dispose();
		}

	}

	public void draw(Graphics g) {
		g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
	}

	public void update() {
		index = 0;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void applyGamestate() {
		GameState.state = state;
	}

	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}

}