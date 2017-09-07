package panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel {
	
	private JTextField textTextField;
	
	public TextPanel() {
		setPanel();
		createTextLabel();
		createTextTextField();
		createColorLabel();
		createFontSizeLabel();
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
	
	private void createFontSizeLabel() {
		JLabel fontSizeLabel = new JLabel("<html><b>FontSize</html></b>");
		fontSizeLabel.setSize(80, 30);
		fontSizeLabel.setLocation(110, 60);
		this.add(fontSizeLabel);
	}
	
	public String getText() {
		String text = textTextField.getText().toString();
		textTextField.setText("");
		return text;
	}

}
