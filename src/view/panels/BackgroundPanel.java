package view.panels;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BackgroundPanel extends JPanel {
	
	private JTextField backgroundTextField;
	private JComboBox extensionComboBox;
	
	public BackgroundPanel() {
		setPanel();
		createBackgroundLabel();
		createBackgroundTextField();
		createExtensionLabel();
		createExtensionComboBox();
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
	
	public String getBackgroundPath() {
		String backgroundPath = backgroundTextField.getText().toString();
		return backgroundPath;
	}
	
	public String getExtension() {
		return extensionComboBox.getSelectedItem().toString();
	}
	
	public boolean allFieldsAreFilled() {
		if (backgroundTextField.getText().isEmpty())
			return false;
		return true;
	}
	
	public void clearFields() {
		backgroundTextField.setText("");
	}

}
