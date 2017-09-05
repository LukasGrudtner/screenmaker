package panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SceneButtonsPanel extends JPanel {

	JButton initialSceneButton, intermediateSceneButton, finalSceneButton;
	
	public SceneButtonsPanel() {
		setPanel();
		createInitialSceneButton();
		createIntermediateSceneButton();
		createFinalSceneButton();
	}
	
	private void setPanel() {
		setSize(410, 50);
		setLayout(null);
		setLocation(40, 30);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createInitialSceneButton() {
		initialSceneButton = new JButton("<html><b>InitialScene</b></html>");
		initialSceneButton.setSize(100, 30);
		initialSceneButton.setLocation(10, 10);
		initialSceneButton.setToolTipText("Cria uma cena inicial.");
		this.add(initialSceneButton);
	}
	
	private void createIntermediateSceneButton() {
		intermediateSceneButton = new JButton("<html><b>IntermediateScene</b></html>");
		intermediateSceneButton.setSize(150, 30);
		intermediateSceneButton.setLocation(130, 10);
		intermediateSceneButton.setToolTipText("Cria uma cena intermediária.");
		this.add(intermediateSceneButton);
	}
	
	private void createFinalSceneButton() {
		finalSceneButton = new JButton("<html><b>FinalScene</b></html>");
		finalSceneButton.setSize(100, 30);
		finalSceneButton.setLocation(300, 10);
		finalSceneButton.setToolTipText("Cria uma cena final.");
		this.add(finalSceneButton);
	}
	
}
