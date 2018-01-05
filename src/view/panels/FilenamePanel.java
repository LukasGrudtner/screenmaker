package view.panels;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilenamePanel extends JPanel {
	
	private JTextField filenameTextField;
	private JComboBox extensionComboBox;
	
	public FilenamePanel() {
		setPanel();
		createFilenameLabel();
		createFilenameTextField();
		createExtensionLabel();
		createExtensionComboBox();
	}
	
	private void setPanel() {
		setSize(410, 70);
		setLayout(null);
		setLocation(40, 90);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createFilenameLabel() {
		JLabel labelFilename = new JLabel("<html><b>Filename</b></html>");
		labelFilename.setSize(100, 30);
		labelFilename.setLocation(10, 0);
		this.add(labelFilename);
	}
	
	private void createFilenameTextField() {
		filenameTextField = new JTextField();
		filenameTextField.setSize(150, 30);
		filenameTextField.setLocation(10, 30);
		this.add(filenameTextField);
	}
	
	private void createExtensionLabel() {
		JLabel extensionLabel = new JLabel("<html><b>Extension</b></html>");
		extensionLabel.setSize(100, 30);
		extensionLabel.setLocation(170, 0);
		this.add(extensionLabel);
	}
	
	private void createExtensionComboBox() {
		String[] extensions = {".json"};
		extensionComboBox = new JComboBox(extensions);
		extensionComboBox.setSize(80, 30);
		extensionComboBox.setLocation(170, 30);
		this.add(extensionComboBox);
	}
	
	public String getFilenamePath() {
		return filenameTextField.getText().toString();
	}
	
	public String getExtension() {
		return extensionComboBox.getSelectedItem().toString();
	}

}
