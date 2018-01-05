package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.scenes.Scene;

public class GeneratedScenesPanel extends JPanel {
	
	private JLabel sceneLabel;
	private JList list;
	
	public GeneratedScenesPanel() {
		setPanel();
		createSceneLabel();
		createList();
	}
	
	private void setPanel() {
		setSize(115, 400);
		setLayout(null);
		setLocation(460, 30);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createSceneLabel() {
		sceneLabel = new JLabel();
		sceneLabel.setSize(110, 380);
		sceneLabel.setLocation(10, 10);
		this.add(sceneLabel);
	}
	
	private void createList() {
		list = new JList();
		list.setBackground(new Color(214, 217, 223));
		list.setSize(112, 398);
		list.setLocation(1, 1);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(190, 40));
		this.add(list);
	}
	
	public void updateList(ArrayList<Scene> sceneList) {
		sceneLabel.setText("");
		String aux = "";
		String[] array = new String[sceneList.size()];
		for (int i = 0; i < sceneList.size(); i++) {
//			aux += scene.getBackground() + "<br />" + scene.getText() + "<br /><br />";
//			aux += scene.getClass() + "<br /><br />";
			array[i] = sceneList.get(i).getClass().getSimpleName();
		}
//		sceneLabel.setText("<html>" + aux + "</html>");
		list.setListData(array);
	}

}
