package entity;

import java.awt.Point;
import java.awt.Image;

public interface RobotModel {
	double getRobotX();
	double getRobotY();
	double getRobotDirection();
	double getTargetX();
	double getTargetY();
	void setTargetPosition(Point p);
	void updateModel();
	Image getImage();
	String getDrawingRules();
}
