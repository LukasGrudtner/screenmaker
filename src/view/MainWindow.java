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

import panels.BackgroundPanel;
import panels.FilenamePanel;
import panels.GeneratedScenesPanel;
import panels.SceneButtonsPanel;
import panels.TransitionImagePanel;

public class MainWindow extends JFrame {
	
	private JButton initialSceneButton, intermediateSceneButton, finalSceneButton;
	private JTextField filenameTextField, transitionTextField;
	private JTextField xTransitionImage, yTransitionImage, widthTransitionImage, heightTransitionImage;
	private UIManager.LookAndFeelInfo appearance[];
	
	private BackgroundPanel backgroundPanel;
	private TransitionImagePanel transitionImagePanel;
	private FilenamePanel filenamePanel;
	private SceneButtonsPanel sceneButtonsPanel;
	private GeneratedScenesPanel generatedScenesPanel;
	
	public MainWindow() {
		super("ScreenMaker");
		setLayout(null);
		
		appearance = UIManager.getInstalledLookAndFeels();
		this.mudeTheLookAndFeel(1);
		
		initPanels();
		createWindow();
	}
	
	private void initPanels() {
		filenamePanel = new FilenamePanel();
		backgroundPanel = new BackgroundPanel();
		transitionImagePanel = new TransitionImagePanel();
		sceneButtonsPanel = new SceneButtonsPanel();
		generatedScenesPanel = new GeneratedScenesPanel();
		
		this.add(filenamePanel);
		this.add(backgroundPanel);
		this.add(transitionImagePanel);
		this.add(sceneButtonsPanel);
		this.add(generatedScenesPanel);
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
