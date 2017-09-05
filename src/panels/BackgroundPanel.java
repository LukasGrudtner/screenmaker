package panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BackgroundPanel extends JPanel {
	
	JTextField backgroundTextField;
	
	public BackgroundPanel() {
		setPanel();
		createBackgroundLabel();
		createBackgroundTextField();
		
	}
	
	private void setPanel() {
		setSize(410, 70);
		setLayout(null);
		setLocation(40, 170);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createBackgroundLabel() {
		JLabel labelBackground = new JLabel("<html><b>Background path</b></html>");
		labelBackground.setSize(100, 30);
		labelBackground.setLocation(10, 0);
		this.add(labelBackground);
	}
	
	private void createBackgroundTextField() {
		backgroundTextField = new JTextField();
		backgroundTextField.setSize(150, 30);
		backgroundTextField.setLocation(10, 30);
		this.add(backgroundTextField);
	}

}
