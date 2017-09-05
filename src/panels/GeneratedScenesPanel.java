package panels;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Scene;

public class GeneratedScenesPanel extends JPanel {
	
	private JLabel sceneLabel;
	
	public GeneratedScenesPanel() {
		setPanel();
		createSceneLabel();
	}
	
	private void setPanel() {
		setSize(190, 400);
		setLayout(null);
		setLocation(460, 30);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createSceneLabel() {
		sceneLabel = new JLabel();
		sceneLabel.setSize(170, 380);
		sceneLabel.setLocation(10, 10);
		this.add(sceneLabel);
	}
	
	public void updateList(ArrayList<Scene> sceneList) {
		sceneLabel.setText("");
		String aux = "";
		for (Scene scene : sceneList) {
//			aux += scene.getBackground() + "<br />" + scene.getText() + "<br /><br />";
			aux += scene.getClass() + "<br /><br />";
		}
		sceneLabel.setText("<html>" + aux + "</html>");
	}

}
