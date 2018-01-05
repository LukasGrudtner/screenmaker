package view.panels;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel {
	
	private JTextField textTextField, positionTextField;
	private JComboBox positionComboBox;
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
		createPositionLabel();
		createPositionComboBox();
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
	
	private void createPositionLabel() {
		JLabel positionLabel = new JLabel("<html><b>Position</html></b>");
		positionLabel.setSize(80, 30);
		positionLabel.setLocation(180, 60);
		this.add(positionLabel);
	}
	
	private void createPositionComboBox() {
		String[] values = {"Top Right", "Top Center", "Bottom Center"};
		positionComboBox = new JComboBox(values);
		positionComboBox.setSelectedIndex(2);
		positionComboBox.setSize(120, 30);
		positionComboBox.setLocation(180, 90);
		this.add(positionComboBox);
	}
	
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
	
	public String getTextPosition() {
		return positionComboBox.getSelectedItem().toString();
	}
	
	public int getFontSize() {
		return Integer.parseInt(fontSizeComboBox.getSelectedItem().toString());
	}
	
	public boolean allFieldsAreFilled() {
		return true;
	}
	
	public void clearFields() {
		textTextField.setText("");
	}

}
