package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.FinalScene;
import model.InitialScene;
import model.IntermediateScene;
import model.Scene;
import panels.BackgroundPanel;
import panels.FilenamePanel;
import panels.GeneratedScenesPanel;
import panels.SceneButtonsPanel;
import panels.TextPanel;
import panels.TransitionImagePanel;

public class MainWindow extends JFrame {
	
	private UIManager.LookAndFeelInfo appearance[];
	
	private BackgroundPanel backgroundPanel;
	private TransitionImagePanel transitionImagePanel;
	private FilenamePanel filenamePanel;
	private SceneButtonsPanel sceneButtonsPanel;
	private GeneratedScenesPanel generatedScenesPanel;
	private TextPanel textPanel;
	
	private ArrayList<Scene> sceneList;
	
	public MainWindow() {
		super("ScreenMaker");
		setLayout(null);
		
		appearance = UIManager.getInstalledLookAndFeels();
		this.mudeTheLookAndFeel(1);
		
		initPanels();
		createWindow();
		sceneList = new ArrayList<Scene>();
		setListener();
	}
	
	private void initPanels() {
		filenamePanel = new FilenamePanel();
		backgroundPanel = new BackgroundPanel();
		transitionImagePanel = new TransitionImagePanel();
		sceneButtonsPanel = new SceneButtonsPanel();
		generatedScenesPanel = new GeneratedScenesPanel();
		textPanel = new TextPanel();
		
		this.add(filenamePanel);
		this.add(backgroundPanel);
		this.add(transitionImagePanel);
		this.add(sceneButtonsPanel);
		this.add(generatedScenesPanel);
		this.add(textPanel);
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
		setSize(700, 600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void setListener() {
		sceneButtonsPanel.getInitialSceneButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filenamePath = filenamePanel.getFilenamePath();
				String backgroundPath = backgroundPanel.getBackgroundPath();
				String text = textPanel.getText();
				
				Scene scene;
				
				if (!filenamePath.isEmpty() && !backgroundPath.isEmpty()) {
					scene = new InitialScene(backgroundPath, text);
					sceneList.add(scene);
					generatedScenesPanel.updateList(sceneList);
				}
				
			}
		});
		
		sceneButtonsPanel.getIntermediateSceneButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filenamePath = filenamePanel.getFilenamePath();
				String backgroundPath = backgroundPanel.getBackgroundPath();
				String text = textPanel.getText();
				
				Scene scene;
				
				if (!filenamePath.isEmpty() && !backgroundPath.isEmpty()) {
					scene = new IntermediateScene(backgroundPath, text);
					sceneList.add(scene);
					generatedScenesPanel.updateList(sceneList);

				}
			}
		});
		
		sceneButtonsPanel.getFinalSceneButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filenamePath = filenamePanel.getFilenamePath();
				String backgroundPath = backgroundPanel.getBackgroundPath();
				String text = textPanel.getText();
				
				Scene scene;
				
				if (!filenamePath.isEmpty() && !backgroundPath.isEmpty()) {
					scene = new FinalScene(backgroundPath, text);
					sceneList.add(scene);
					generatedScenesPanel.updateList(sceneList);

				}
			}
		});
	}

}
