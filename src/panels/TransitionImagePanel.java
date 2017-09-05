package panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransitionImagePanel extends JPanel {
	
	private JTextField imagePathTextField, xTextField, yTextField, widthTextField, heightTextField;
	
	public TransitionImagePanel() {
		setPanel();
		createImagePathTextField();
		createImagePathLabel();
		createXLabel();
		createXTextField();
		createYLabel();
		createYTextField();
		createWidthLabel();
		createWidthTextField();
		createHeightLabel();
		createHeightTextField();
	}
	
	private void setPanel() {
		setSize(410, 130);
		setLayout(null);
		setLocation(40, 390);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createImagePathTextField() {
		imagePathTextField = new JTextField();
		imagePathTextField.setSize(150, 30);
		imagePathTextField.setLocation(10, 30);
		this.add(imagePathTextField);
	}
	
	private void createImagePathLabel() {
		JLabel labelImagePath = new JLabel("<html><b>Image path</b></html>");
		labelImagePath.setSize(100, 30);
		labelImagePath.setLocation(10, 0);
		this.add(labelImagePath);
	}
	
	private void createXTextField() {
		xTextField = new JTextField();
		xTextField.setSize(40, 30);
		xTextField.setLocation(10, 90);
		this.add(xTextField);
	}
	
	private void createXLabel() {
		JLabel labelX = new JLabel("<html><b>X</b></html>");
		labelX.setSize(30, 30);
		labelX.setLocation(10, 60);
		this.add(labelX);
	}
	
	private void createYTextField() {
		yTextField = new JTextField();
		yTextField.setSize(40, 30);
		yTextField.setLocation(60, 90);
		this.add(yTextField);
	}
	
	private void createYLabel() {
		JLabel labelY = new JLabel("<html><b>Y</b></html>");
		labelY.setSize(30, 30);
		labelY.setLocation(60, 60);
		this.add(labelY);
	}
	
	private void createWidthTextField() {
		widthTextField = new JTextField();
		widthTextField.setSize(60, 30);
		widthTextField.setLocation(110, 90);
		this.add(widthTextField);
	}
	
	private void createWidthLabel() {
		JLabel labelWidth = new JLabel("<html><b>Width</b></html>");
		labelWidth.setSize(60, 30);
		labelWidth.setLocation(110, 60);
		this.add(labelWidth);
	}
	
	private void createHeightTextField() {
		heightTextField = new JTextField();
		heightTextField.setSize(60, 30);
		heightTextField.setLocation(180,  90);
		this.add(heightTextField);
	}
	
	private void createHeightLabel() {
		JLabel labelHeight = new JLabel("<html><b>Height</b></html>");
		labelHeight.setSize(60, 30);
		labelHeight.setLocation(180, 60);
		this.add(labelHeight);
	}

}
