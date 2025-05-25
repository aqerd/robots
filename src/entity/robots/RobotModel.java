package entity.robots;

import java.awt.Point;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public interface RobotModel {
	double getRobotX();
	double getRobotY();
	double getRobotDirection();
	double getTargetX();
	double getTargetY();
	void setTargetPosition(Point p);
	void updateModel();
	void draw(Graphics2D g, JPanel observer);
}
