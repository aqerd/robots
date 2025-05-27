package gui.windows.dialog;

import entity.robots.custom.DrawableRobot;
import utils.LocalizationManager;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class RobotCustomization extends JDialog {
	private JSpinner sizeSpinner;
	private JComboBox<String> shapeComboBox;
	private JButton fillColorButton;
	private JButton borderColorButton;
	private JButton targetIndicatorColorButton;
	private JSpinner velocitySpinner;
	private JSpinner angularVelocitySpinner;

	private Color selectedFillColor = Color.BLUE;
	private Color selectedBorderColor = Color.BLACK;
	private Color selectedTargetIndicatorColor = Color.RED;

	private DrawableRobot.Shape selectedShape = DrawableRobot.Shape.CIRCLE;
	private int selectedSize = 50;
	private double selectedVelocity = 1.2;
	private double selectedAngularVelocity = 0.01;

	private boolean confirmed = false;
	private Map<String, DrawableRobot.Shape> shapeNameMap;

	public RobotCustomization(Frame owner) {
		super(owner, LocalizationManager.getLocalizedText("robotCustomizationDialogTitle"), true);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		shapeNameMap = new HashMap<>();
		for (DrawableRobot.Shape shape : DrawableRobot.Shape.values()) {
			shapeNameMap.put(LocalizationManager.getLocalizedText("shape." + shape.name().toLowerCase()), shape);
		}

		gbc.gridx = 0; gbc.gridy = 0;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamSize")), gbc);
		sizeSpinner = new JSpinner(new SpinnerNumberModel(selectedSize, 10, 100, 5));
		gbc.gridx = 1; gbc.gridy = 0;
		add(sizeSpinner, gbc);

		gbc.gridx = 0; gbc.gridy = 1;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamShape")), gbc);
		shapeComboBox = new JComboBox<>(shapeNameMap.keySet().toArray(new String[0]));
		gbc.gridx = 1; gbc.gridy = 1;
		add(shapeComboBox, gbc);

		gbc.gridx = 0; gbc.gridy = 2;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamFillColor")), gbc);
		fillColorButton = new JButton();
		configureColorButton(fillColorButton, selectedFillColor, _ -> {
			Color color = JColorChooser.showDialog(this, LocalizationManager.getLocalizedText("selectFillColorTitle"), selectedFillColor);
			if (color != null) {
				selectedFillColor = color;
				fillColorButton.setBackground(selectedFillColor);
			}
		});
		gbc.gridx = 1; gbc.gridy = 2;
		add(fillColorButton, gbc);

		gbc.gridx = 0; gbc.gridy = 3;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamBorderColor")), gbc);
		borderColorButton = new JButton();
		configureColorButton(borderColorButton, selectedBorderColor, _ -> {
			Color color = JColorChooser.showDialog(this, LocalizationManager.getLocalizedText("selectBorderColorTitle"), selectedBorderColor);
			if (color != null) {
				selectedBorderColor = color;
				borderColorButton.setBackground(selectedBorderColor);
			}
		});
		gbc.gridx = 1; gbc.gridy = 3;
		add(borderColorButton, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamTargetIndicatorColor")), gbc);
		targetIndicatorColorButton = new JButton();
		configureColorButton(targetIndicatorColorButton, selectedTargetIndicatorColor, _ -> {
			Color color = JColorChooser.showDialog(this, LocalizationManager.getLocalizedText("selectTargetIndicatorColorTitle"), selectedTargetIndicatorColor);
			if (color != null) {
				selectedTargetIndicatorColor = color;
				targetIndicatorColorButton.setBackground(selectedTargetIndicatorColor);
			}
		});
		gbc.gridx = 1; gbc.gridy = 4;
		add(targetIndicatorColorButton, gbc);

		gbc.gridx = 0; gbc.gridy = 5;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamVelocity")), gbc);
		velocitySpinner = new JSpinner(new SpinnerNumberModel(selectedVelocity, 0.1, 5.0, 0.1));
		gbc.gridx = 1; gbc.gridy = 5;
		add(velocitySpinner, gbc);

		gbc.gridx = 0; gbc.gridy = 6;
		add(new JLabel(LocalizationManager.getLocalizedText("robotParamAngularVelocity")), gbc);
		angularVelocitySpinner = new JSpinner(new SpinnerNumberModel(selectedAngularVelocity, 0.001, 0.1, 0.001));
		((JSpinner.NumberEditor)angularVelocitySpinner.getEditor()).getFormat().setMinimumFractionDigits(3);
		gbc.gridx = 1; gbc.gridy = 6;
		add(angularVelocitySpinner, gbc);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton okButton = new JButton(LocalizationManager.getLocalizedText("buttonOK"));
		okButton.addActionListener(_ -> {
			selectedSize = (Integer) sizeSpinner.getValue();
			selectedShape = shapeNameMap.get((String)shapeComboBox.getSelectedItem());
			selectedVelocity = (Double) velocitySpinner.getValue();
			selectedAngularVelocity = (Double) angularVelocitySpinner.getValue();
			confirmed = true;
			setVisible(false);
		});
		buttonPanel.add(okButton);

		JButton cancelButton = new JButton(LocalizationManager.getLocalizedText("buttonCancel"));
		cancelButton.addActionListener(_ -> {
			confirmed = false;
			setVisible(false);
		});
		buttonPanel.add(cancelButton);

		gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
		add(buttonPanel, gbc);

		pack();
		setLocationRelativeTo(owner);
	}

	private void configureColorButton(JButton button, Color initialColor, java.awt.event.ActionListener actionListener) {
		button.setBackground(initialColor);
		button.setPreferredSize(new Dimension(100, 25));
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.addActionListener(actionListener);
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public int getSelectedSize() {
		return selectedSize;
	}

	public DrawableRobot.Shape getSelectedShape() {
		return selectedShape;
	}

	public Color getSelectedFillColor() {
		return selectedFillColor;
	}

	public Color getSelectedBorderColor() {
		return selectedBorderColor;
	}
	
	public Color getSelectedTargetIndicatorColor() {
		return selectedTargetIndicatorColor;
	}

	public double getSelectedVelocity() {
		return selectedVelocity;
	}

	public double getSelectedAngularVelocity() {
		return selectedAngularVelocity;
	}
}