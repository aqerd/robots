package gui;

import entity.Robot;
import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CoordinatesWindow extends JInternalFrame implements Observer {

    private final Robot robotModel;
    private final JLabel xLabel;
    private final JLabel yLabel;
    private final JLabel dirLabel;
    private final NumberFormat coordinateFormat;

    public CoordinatesWindow(Robot robot) {
        super("Координаты робота (Observable)", true, true, true, true);
        this.robotModel = robot;

        coordinateFormat = new DecimalFormat("#0.00");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel xTitleLabel = new JLabel("X:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(xTitleLabel, gbc);

        xLabel = new JLabel(formatCoordinate(robotModel.getPositionX()));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(xLabel, gbc);

        JLabel yTitleLabel = new JLabel("Y:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(yTitleLabel, gbc);

        yLabel = new JLabel(formatCoordinate(robotModel.getPositionY()));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(yLabel, gbc);

        JLabel dirTitleLabel = new JLabel("Направление:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(dirTitleLabel, gbc);

        dirLabel = new JLabel(formatDirection(robotModel.getDirection()));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(dirLabel, gbc);

        setSize(250, 150);
        pack();
        setLocation(50, 50);

        this.robotModel.addObserver(this);

        addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                robotModel.deleteObserver(CoordinatesWindow.this);
            }

            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
                robotModel.deleteObserver(CoordinatesWindow.this);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == robotModel) {
            double currentX = robotModel.getPositionX();
            double currentY = robotModel.getPositionY();
            double currentDir = robotModel.getDirection();

            SwingUtilities.invokeLater(() -> {
                xLabel.setText(formatCoordinate(currentX));
                yLabel.setText(formatCoordinate(currentY));
                dirLabel.setText(formatDirection(currentDir));
            });
        }
    }

    private String formatCoordinate(double coordinate) {
        return coordinateFormat.format(coordinate);
    }

    private String formatDirection(double direction) {
        if (direction == 0) {
            return "Восток";
        } else if (direction == Math.PI / 2) {
            return "Север";
        } else if (direction == Math.PI) {
            return "Запад";
        } else if (direction == 3 * Math.PI / 2) {
            return "Юг";
        } else if (direction > 0 && direction < Math.PI / 2) {
            return "Северо-Восток";
        } else if (direction > Math.PI / 2 && direction < Math.PI) {
            return "Северо-Запад";
        } else if (direction > Math.PI && direction < 3 * Math.PI / 2) {
            return "Юго-Запад";
        } else if (direction > 3 * Math.PI / 2 && direction < 2 * Math.PI) {
            return "Юго-Восток";
        } else {
            return "Неизвестно";
        }
    }

    @Override
    public void dispose() {
        robotModel.deleteObserver(this);
        super.dispose();
    }
}
