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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.FinalScene;
import model.InitialScene;
import model.InputDataPool;
import model.IntermediateScene;
import model.Scene;
import model.SceneWriterJSON;
import model.Transition;
import panels.BackgroundPanel;
import panels.DisplayPanel;
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
	private DisplayPanel displayPanel;
	
	private JButton generateButton;
	private JButton viewButton;
	
	private String filePath;
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
		
		createGenerateButton();
		createViewButton();
		setEnabledIntermediateButton(false);
		setEnabledFinalButton(false);
		setEnabledGenerateButton(false);
	}
	
	private void initPanels() {
		filenamePanel = new FilenamePanel();
		backgroundPanel = new BackgroundPanel();
		transitionImagePanel = new TransitionImagePanel();
		sceneButtonsPanel = new SceneButtonsPanel();
		generatedScenesPanel = new GeneratedScenesPanel();
		textPanel = new TextPanel();
		displayPanel = new DisplayPanel();
		
		this.add(filenamePanel);
		this.add(backgroundPanel);
		this.add(transitionImagePanel);
		this.add(sceneButtonsPanel);
		this.add(generatedScenesPanel);
		this.add(textPanel);
		this.add(displayPanel);
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
		setSize(1020, 600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void setListener() {
		sceneButtonsPanel.getInitialSceneButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (allFieldsAreFilled()) {
					InputDataPool inputDataPool = getInputDataPool();
					Transition transition = new Transition(inputDataPool.getTransitionImagePath(), inputDataPool.getTransitionImageX(),
							inputDataPool.getTransitionImageY(), inputDataPool.getTransitionImageWidth(), 
							inputDataPool.getTransitionImageHeight());
					
					Scene scene = new InitialScene(inputDataPool.getBackgroundPath(), inputDataPool.getText(), transition);
					sceneList.add(scene);
					generatedScenesPanel.updateList(sceneList);
					
					setEnabledInitialButton(false);
					setEnabledIntermediateButton(true);
					setEnabledFinalButton(true);
					
					showScreenView();
					clearFields();
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir!");
				}
			}
		});
		
		sceneButtonsPanel.getIntermediateSceneButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (allFieldsAreFilled()) {
					InputDataPool inputDataPool = getInputDataPool();
					Transition transition = new Transition(inputDataPool.getTransitionImagePath(), inputDataPool.getTransitionImageX(),
							inputDataPool.getTransitionImageY(), inputDataPool.getTransitionImageWidth(), 
							inputDataPool.getTransitionImageHeight());
					
					Scene scene;
				
					scene = new IntermediateScene(inputDataPool.getBackgroundPath(), inputDataPool.getText(), transition);
					sceneList.add(scene);
					generatedScenesPanel.updateList(sceneList);
					
					showScreenView();
					clearFields();
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir!");
				}
			}
		});
		
		sceneButtonsPanel.getFinalSceneButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (allFieldsAreFilled()) {
					InputDataPool inputDataPool = getInputDataPool();
					Transition transition = new Transition(inputDataPool.getTransitionImagePath(), inputDataPool.getTransitionImageX(),
							inputDataPool.getTransitionImageY(), inputDataPool.getTransitionImageWidth(), 
							inputDataPool.getTransitionImageHeight());
					
					Scene scene;
					
					scene = new FinalScene(inputDataPool.getBackgroundPath(), inputDataPool.getText(), transition);
					sceneList.add(scene);
					generatedScenesPanel.updateList(sceneList);
					
					clearFields();
					setEnabledIntermediateButton(false);
					setEnabledFinalButton(false);
					setEnabledGenerateButton(true);
				
					showScreenView();
					clearFields();
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir!");
				}
			}
		});
	}
	
	private void createGenerateButton() {
		generateButton = new JButton("<html><b>Generate</b></html>");
		generateButton.setSize(100, 30);
		generateButton.setLocation(550, 500);
		
		generateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				filePath = filenamePanel.getFilenamePath();
				String extension = filenamePanel.getExtension();
				
				if (!filePath.isEmpty()) {
					SceneWriterJSON sceneWriter = new SceneWriterJSON(filePath+extension, sceneList);
					sceneWriter.write();
					JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "O nome do arquivo de destino não foi informado!");
				}
			}
		});
		
		getContentPane().add(generateButton);
	}
	
	private void createViewButton() {
		viewButton = new JButton("<html><b>Show</b></html>");
		viewButton.setSize(100, 30);
		viewButton.setLocation(550, 450);
		viewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showScreenView();
			}
		});
		getContentPane().add(viewButton);
	}
	
	private void showScreenView() {
		InputDataPool inputDataPool = getInputDataPool();
		displayPanel.setImages(inputDataPool.getBackgroundPath(), inputDataPool.getTransitionImagePath(), 
				inputDataPool.getTransitionImageX(), inputDataPool.getTransitionImageY(), inputDataPool.getTransitionImageWidth(),
				inputDataPool.getTransitionImageHeight());
		displayPanel.setText(inputDataPool);
		
	}
	
	private void setEnabledInitialButton(boolean b) {
		sceneButtonsPanel.getInitialSceneButton().setEnabled(b);
	}
	
	private void setEnabledIntermediateButton(boolean b) {
		sceneButtonsPanel.getIntermediateSceneButton().setEnabled(b);
	}
	
	private void setEnabledFinalButton(boolean b) {
		sceneButtonsPanel.getFinalSceneButton().setEnabled(b);
	}
	
	private void setEnabledGenerateButton(boolean b) {
		generateButton.setEnabled(b);
	}
	
	private boolean allFieldsAreFilled() {
		if (backgroundPanel.allFieldsAreFilled() && textPanel.allFieldsAreFilled() && transitionImagePanel.allFieldsAreFilled())
			return true;
		return false;
	}
	
	private InputDataPool getInputDataPool() {
		InputDataPool inputDataPool = new InputDataPool();
		String backgroundPath = backgroundPanel.getBackgroundPath() + backgroundPanel.getExtension();
		String text = textPanel.getText();
		Color textColor = textPanel.getTextColor();
		int fontSize = textPanel.getFontSize();
		int textX = textPanel.getXText();
		int textY = textPanel.getYText();
		int textWidth = textPanel.getWidthText();
		int textHeight = textPanel.getHeightText();
		String transitionImagePath = transitionImagePanel.getImagePath() + transitionImagePanel.getExtension();
		int transitionImageX = transitionImagePanel.getXImage();
		int transitionImageY = transitionImagePanel.getYImage();
		int transitionImageWidth = transitionImagePanel.getWidthImage();
		int transitionImageHeight = transitionImagePanel.getHeightImage();
		
		inputDataPool.setBackgroundPath(backgroundPath);
		inputDataPool.setText(text);
		inputDataPool.setTextColor(textColor);
		inputDataPool.setFontSize(fontSize);
		inputDataPool.setTextX(textX);
		inputDataPool.setTextY(textY);
		inputDataPool.setTextWidth(textWidth);
		inputDataPool.setTextHeight(textHeight);
		inputDataPool.setTransitionImagePath(transitionImagePath);
		inputDataPool.setTransitionImageX(transitionImageX);
		inputDataPool.setTransitionImageY(transitionImageY);
		inputDataPool.setTransitionImageWidth(transitionImageWidth);
		inputDataPool.setTransitionImageHeight(transitionImageHeight);
		
		return inputDataPool;
	}
	
	private void clearFields() {
		backgroundPanel.clearFields();
		textPanel.clearFields();
		transitionImagePanel.clearFields();
	}

}
