package panels;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel {
	
	private JTextField textTextField; //, xTextField, yTextField, widthTextField, heightTextField;
	private JComboBox colorComboBox;
	private JComboBox fontSizeComboBox;
	
	public TextPanel() {
		setPanel();
		createTextLabel();
		createTextTextField();
		createColorLabel();
		createColorComboBox();
		createFontSizeLabel();
		createFontSizeComboBox();
//		createXLabel();
//		createXTextField();
//		createYLabel();
//		createYTextField();
//		createWidthLabel();
//		createWidthTextField();
//		createHeightLabel();
//		createHeightTextField();
	}
	
	private void setPanel() {
		setSize(410, 130);
		setLayout(null);
		setLocation(40, 250);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createTextLabel() {
		JLabel textLabel = new JLabel("<html><b>Text</html></b>");
		textLabel.setSize(80, 30);
		textLabel.setLocation(10, 0);
		this.add(textLabel);
	}
	
	private void createTextTextField() {
		textTextField = new JTextField();
		textTextField.setSize(390, 30);
		textTextField.setLocation(10, 30);
		this.add(textTextField);
	}
	
	private void createColorLabel() {
		JLabel colorLabel = new JLabel("<html><b>Color</html></b>");
		colorLabel.setSize(80, 30);
		colorLabel.setLocation(10, 60);
		this.add(colorLabel);
	}
	
	private void createColorComboBox() {
		String[] colors = {"Black", "White"};
		colorComboBox = new JComboBox(colors);
		colorComboBox.setSelectedIndex(0);
		colorComboBox.setSize(80, 30);
		colorComboBox.setLocation(10, 90);
		this.add(colorComboBox);
	}
	
	private void createFontSizeLabel() {
		JLabel fontSizeLabel = new JLabel("<html><b>Font size</html></b>");
		fontSizeLabel.setSize(80, 30);
		fontSizeLabel.setLocation(100, 60);
		this.add(fontSizeLabel);
	}
	
	private void createFontSizeComboBox() {
		String[] values = {"1", "2", "3", "4", "5"};
		fontSizeComboBox = new JComboBox(values);
		fontSizeComboBox.setSelectedIndex(2);
		fontSizeComboBox.setSize(60, 30);
		fontSizeComboBox.setLocation(100, 90);
		this.add(fontSizeComboBox);
	}
	
//	private void createXTextField() {
//		xTextField = new JTextField();
//		xTextField.setSize(40, 30);
//		xTextField.setLocation(170, 90);
//		this.add(xTextField);
//	}
//	
//	private void createXLabel() {
//		JLabel labelX = new JLabel("<html><b>X</b></html>");
//		labelX.setSize(30, 30);
//		labelX.setLocation(170, 60);
//		this.add(labelX);
//	}
//	
//	private void createYTextField() {
//		yTextField = new JTextField();
//		yTextField.setSize(40, 30);
//		yTextField.setLocation(220, 90);
//		this.add(yTextField);
//	}
//	
//	private void createYLabel() {
//		JLabel labelY = new JLabel("<html><b>Y</b></html>");
//		labelY.setSize(30, 30);
//		labelY.setLocation(220, 60);
//		this.add(labelY);
//	}
//	
//	private void createWidthTextField() {
//		widthTextField = new JTextField();
//		widthTextField.setSize(60, 30);
//		widthTextField.setLocation(270, 90);
//		this.add(widthTextField);
//	}
//	
//	private void createWidthLabel() {
//		JLabel labelWidth = new JLabel("<html><b>Width</b></html>");
//		labelWidth.setSize(60, 30);
//		labelWidth.setLocation(270, 60);
//		this.add(labelWidth);
//	}
//	
//	private void createHeightTextField() {
//		heightTextField = new JTextField();
//		heightTextField.setSize(60, 30);
//		heightTextField.setLocation(340,  90);
//		this.add(heightTextField);
//	}
//	
//	private void createHeightLabel() {
//		JLabel labelHeight = new JLabel("<html><b>Height</b></html>");
//		labelHeight.setSize(60, 30);
//		labelHeight.setLocation(340, 60);
//		this.add(labelHeight);
//	}
	
	public String getText() {
		String text = textTextField.getText().toString();
		return text;
	}
	
	public Color getTextColor() {
		String color = colorComboBox.getSelectedItem().toString();
		if (color.equals("Black"))
			return Color.BLACK;
		else if (color.equals("White"))
			return Color.WHITE;
		return null;
	}
	
	public int getFontSize() {
		return Integer.parseInt(fontSizeComboBox.getSelectedItem().toString());
	}
	
//	public int getXText() {
//		String input = xTextField.getText().toString();
//		int x = 0;
//		if (!input.isEmpty())
//			x = Integer.parseInt(input);
//		return x;
//			
//	}
//	
//	public int getYText() {
//		String input = yTextField.getText().toString();
//		int y = 0;
//		if (!input.isEmpty())
//			y = Integer.parseInt(input);
//		return y;
//	}
//	
//	public int getWidthText() {
//		String input = widthTextField.getText().toString();
//		int width = 0;
//		if (!input.isEmpty())
//			width = Integer.parseInt(input);
//		return width;
//	}
//	
//	public int getHeightText() {
//		String input = heightTextField.getText().toString();
//		int height = 0;
//		if (!input.isEmpty())
//			height = Integer.parseInt(input);
//		return height;
//	}
	
	public boolean allFieldsAreFilled() {
		return true;
	}
	
	public void clearFields() {
		textTextField.setText("");
//		xTextField.setText("");
//		yTextField.setText("");
//		widthTextField.setText("");
//		heightTextField.setText("");
	}

}
