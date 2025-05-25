package entity.point;

import java.awt.Graphics2D;
import java.awt.Color;

public class Target {
	private int x;
	private int y;

	public Target(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillOval(x - 5 / 2, y - 5 / 2, 5, 5);
		g.setColor(Color.BLACK);
		g.drawOval(x - 5 / 2, y - 5 / 2, 5, 5);
	}
}
