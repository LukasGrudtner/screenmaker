package panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilenamePanel extends JPanel {
	
	JTextField filenameTextField;
	
	public FilenamePanel() {
		setPanel();
		createFilenameLabel();
		createFilenameTextField();
		
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

}
