package panels;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransitionImagePanel extends JPanel {
	
	private JTextField transitionImagePathTextField, xTextField, yTextField, widthTextField, heightTextField;
	private JComboBox extensionComboBox;
	
	public TransitionImagePanel() {
		setPanel();
		createImagePathTextField();
		createImagePathLabel();
		createExtensionLabel();
		createExtensionComboBox();
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
		transitionImagePathTextField = new JTextField();
		transitionImagePathTextField.setSize(150, 30);
		transitionImagePathTextField.setLocation(10, 30);
		this.add(transitionImagePathTextField);
	}
	
	private void createImagePathLabel() {
		JLabel labelImagePath = new JLabel("<html><b>Transition image</b></html>");
		labelImagePath.setSize(100, 30);
		labelImagePath.setLocation(10, 0);
		this.add(labelImagePath);
	}
	
	private void createExtensionLabel() {
		JLabel extensionLabel = new JLabel("<html><b>Extension</b></html>");
		extensionLabel.setSize(100, 30);
		extensionLabel.setLocation(170, 0);
		this.add(extensionLabel);
	}
	
	private void createExtensionComboBox() {
		String[] extensions = {".png", ".jpg"};
		extensionComboBox = new JComboBox(extensions);
		extensionComboBox.setSize(80, 30);
		extensionComboBox.setLocation(170, 30);
		this.add(extensionComboBox);
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
	
	public String getImagePath() {
		String imagePath = transitionImagePathTextField.getText().toString();
		return imagePath;
	}
	
	public String getExtension() {
		return extensionComboBox.getSelectedItem().toString();
	}
	
	public int getXImage() {
		String input = xTextField.getText().toString();
		int x = 0;
		if (!input.isEmpty())
			x = Integer.parseInt(input);
		return x;
	}
	
	public int getYImage() {
		String input = yTextField.getText().toString();
		int y = 0;
		if (!input.isEmpty())
			y = Integer.parseInt(input);
		return y;
	}
	
	public int getWidthImage() {
		String input = widthTextField.getText().toString();
		int width = 0;
		if (!input.isEmpty())
			width = Integer.parseInt(input);
		return width;
	}
	
	public int getHeightImage() {
		String input = heightTextField.getText().toString();
		int height = 0;
		if (!input.isEmpty())
			height = Integer.parseInt(input);
		return height;
	}
	
	public boolean allFieldsAreFilled() {
//		if (transitionImagePathTextField.getText().isEmpty())
//			return true;
//		else if (xTextField.getText().isEmpty() || yTextField.getText().isEmpty() || widthTextField.getText().isEmpty() ||
//				heightTextField.getText().isEmpty())
//			return false;
		return true;
	}
	
	public void clearFields() {
		transitionImagePathTextField.setText("");
		xTextField.setText("");
		yTextField.setText("");
		widthTextField.setText("");
		heightTextField.setText("");
	}

}
