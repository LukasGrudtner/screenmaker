package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.InputDataPool;

public class DisplayPanel extends JPanel {
	
	private JLabel backgroundImage, transitionImage, textLabel;

	public DisplayPanel() {
		setPanel();
		createBackground();
		createTransitionImage();
		createTextLabel();
	}
	
	private void setPanel() {
		setSize(380, 200);
		setLayout(null);
		setLocation(585, 100);
		setBorder(new javax.swing.border.LineBorder(Color.gray, 1, true));
	}
	
	private void createBackground() {
		backgroundImage = new JLabel();
		this.add(backgroundImage);
	}
	
	private void createTransitionImage() {
		transitionImage = new JLabel();
		this.add(transitionImage);
	}
	
	private void createTextLabel() {
		textLabel = new JLabel();
		this.add(textLabel);
	}
	
	public void setBackgroundImage(BufferedImage bufferedImage) {
		ImageIcon imageIcon = new ImageIcon(bufferedImage);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 100));
		backgroundImage.setBounds(0, 0, this.getWidth(), this.getHeight());
		backgroundImage.setIcon(imageIcon);
	}
	
	public void setTransitionImage(BufferedImage bufferedImage, int x, int y, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(bufferedImage);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, 100));
		transitionImage.setBounds(x, y, width, height);
		transitionImage.setIcon(imageIcon);
	}
	
	public void setImages(String backgroundImg, String transitionImg, int x, int y, int width, int height) {
		try {
			BufferedImage background = ImageIO.read(new File(backgroundImg));
			BufferedImage transition = ImageIO.read(new File(transitionImg));
			Graphics2D graphics = background.createGraphics();
			graphics.drawImage(transition, x, y, width, height, null);
			graphics.dispose();
			
			setBackgroundImage(background);
			setTransitionImage(transition, x, y, width, height);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "A imagem inserida não foi encontrada!");
		}
	}
	
	public void setText(InputDataPool inputDataPool) {
		textLabel.setText(inputDataPool.getText());
		textLabel.setLocation(inputDataPool.getTextX(), inputDataPool.getTextY());
		textLabel.setSize(inputDataPool.getTextWidth(), inputDataPool.getTextHeight());
		textLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 10*inputDataPool.getFontSize()));
		textLabel.setForeground(inputDataPool.getTextColor());
	}
	
}

