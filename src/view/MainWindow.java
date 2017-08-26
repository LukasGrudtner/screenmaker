package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainWindow extends JFrame {
	
	private JPanel scenesButtonsPanel, filenamePanel, transitionPanel, generatedScenesPanel;
	private JButton initialSceneButton, intermediateSceneButton, finalSceneButton;
	private JTextField filenameTextField, transitionTextField;
	private JTextField xTransitionImage, yTransitionImage, widthTransitionImage, heightTransitionImage;
	private UIManager.LookAndFeelInfo appearance[];
	
	public MainWindow() {
		super("ScreenMaker");
		setLayout(null);
		
		appearance = UIManager.getInstalledLookAndFeels();
		this.mudeTheLookAndFeel(1);
		
		createSceneButtonsPanel();
		createFilenamePanel();
		createImagePathPanel();
		createGeneratedScenesPanel();
		
		createSceneButtons();
		createFilenameField();
		createExtensionsFields();
		createTransitionsFields();
		createWindow();
	}
	
	
	private void createTransitionsFields() {
		transitionTextField = new JTextField();
		transitionTextField.setSize(150, 30);
		transitionTextField.setLocation(10, 30);
		
		JLabel labelImagePath = new JLabel("<html><b>Image path</b></html>");
		labelImagePath.setSize(100, 30);
		labelImagePath.setLocation(10, 0);
		
		transitionPanel.add(transitionTextField);
		transitionPanel.add(labelImagePath);
		
		xTransitionImage = new JTextField();
		xTransitionImage.setSize(40, 30);
		xTransitionImage.setLocation(10, 90);
		
		JLabel labelX = new JLabel("<html><b>X</b></html>");
		labelX.setSize(30, 30);
		labelX.setLocation(10, 60);
		
		transitionPanel.add(xTransitionImage);
		transitionPanel.add(labelX);
		
		yTransitionImage = new JTextField();
		yTransitionImage.setSize(40, 30);
		yTransitionImage.setLocation(60, 90);
		
		JLabel labelY = new JLabel("<html><b>Y</b></html>");
		labelY.setSize(30, 30);
		labelY.setLocation(60, 60);
		
		transitionPanel.add(yTransitionImage);
		transitionPanel.add(labelY);
		
		widthTransitionImage = new JTextField();
		widthTransitionImage.setSize(60, 30);
		widthTransitionImage.setLocation(110, 90);
		
		JLabel labelWidth = new JLabel("<html><b>Width</b></html>");
		labelWidth.setSize(60, 30);
		labelWidth.setLocation(110, 60);
		
		transitionPanel.add(widthTransitionImage);
		transitionPanel.add(labelWidth);
		
		heightTransitionImage = new JTextField();
		heightTransitionImage.setSize(60, 30);
		heightTransitionImage.setLocation(180,  90);
		
		JLabel labelHeight = new JLabel("<html><b>Height</b></html>");
		labelHeight.setSize(60, 30);
		labelHeight.setLocation(180, 60);
		
		transitionPanel.add(heightTransitionImage);
		transitionPanel.add(labelHeight);
	}
	
	private void createExtensionsFields() {
		JLabel labelExtension = new JLabel("<html><b>Extension</b></html>");
		labelExtension.setSize(100, 30);
		labelExtension.setLocation(180, 0);
		
		filenamePanel.add(labelExtension);
	}
	
	private void createFilenameField() {
		filenameTextField = new JTextField();
		filenameTextField.setSize(150, 30);
		filenameTextField.setLocation(10, 30);
		
		JLabel labelFilename = new JLabel("<html><b>Filename</b></html>");
		labelFilename.setSize(100, 30);
		labelFilename.setLocation(10, 0);
		
		filenamePanel.add(filenameTextField);
		filenamePanel.add(labelFilename);
	}
	
	private void createSceneButtons() {
		
		initialSceneButton = new JButton("<html><b>InitialScene</b></html>");
		initialSceneButton.setSize(100, 30);
		initialSceneButton.setLocation(10, 10);
		initialSceneButton.setToolTipText("Cria uma cena inicial.");
		initialSceneButton.setVisible(true);
		
		intermediateSceneButton = new JButton("<html><b>IntermediateScene</b></html>");
		intermediateSceneButton.setSize(150, 30);
		intermediateSceneButton.setLocation(130, 10);
		intermediateSceneButton.setToolTipText("Cria uma cena intermediária.");
		
		finalSceneButton = new JButton("<html><b>FinalScene</b></html>");
		finalSceneButton.setSize(100, 30);
		finalSceneButton.setLocation(300, 10);
		finalSceneButton.setToolTipText("Cria uma cena final.");
		
		scenesButtonsPanel.add(initialSceneButton);
		scenesButtonsPanel.add(intermediateSceneButton);
		scenesButtonsPanel.add(finalSceneButton);
	}
	
	private void createGeneratedScenesPanel() {
		generatedScenesPanel = new JPanel();
		generatedScenesPanel.setSize(190, 400);
		generatedScenesPanel.setLayout(null);
		generatedScenesPanel.setLocation(460, 30);
		generatedScenesPanel.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
		
		getContentPane().add(generatedScenesPanel);
	}
	
	private void createImagePathPanel() {
		transitionPanel = new JPanel();
		transitionPanel.setSize(410, 130);
		transitionPanel.setLayout(null);
		transitionPanel.setLocation(40, 170);
		transitionPanel.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
		
		getContentPane().add(transitionPanel);
	}
	
	private void createFilenamePanel() {
		filenamePanel = new JPanel();
		filenamePanel.setSize(410, 70);
		filenamePanel.setLayout(null);
		filenamePanel.setLocation(40, 90);
		filenamePanel.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
		
		getContentPane().add(filenamePanel);
	}
	
	private void createSceneButtonsPanel() {
		scenesButtonsPanel = new JPanel();
		scenesButtonsPanel.setSize(410, 50);
		scenesButtonsPanel.setLayout(null);
		scenesButtonsPanel.setLocation(40, 30);
		scenesButtonsPanel.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
		
		getContentPane().add(scenesButtonsPanel);
	}
	
	private void mudeTheLookAndFeel(int valor) {
		// Muda aparência e comportamento
		try {
			UIManager.setLookAndFeel(appearance[valor].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	private void createWindow() {
		setSize(700, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
