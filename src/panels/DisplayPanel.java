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

import model.SerializableScene;
import model.Text;

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
		transitionImage.setBounds(x, this.getHeight()-y, width, height);
		transitionImage.setIcon(imageIcon);
	}
	
	public void setImages(String backgroundImg, String transitionImg, int x, int y, int width, int height, Text text) {
		try {
			BufferedImage resizedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
			BufferedImage background = ImageIO.read(new File(backgroundImg));
			Graphics2D graphics = resizedImage.createGraphics();
			graphics.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
			ImageIO.write(resizedImage, "PNG", new File("backgroundResized.png"));
			
			background = ImageIO.read(new File("backgroundResized.png"));
			BufferedImage transition = ImageIO.read(new File(transitionImg));
			graphics = background.createGraphics();
			graphics.drawImage(transition, x, this.getHeight()-(height+y), width, height, null);
			ImageIO.write(background, "PNG", new File("backgroundResized.png"));
//			graphics.dispose();
			
			background = ImageIO.read(new File("backgroundResized.png"));
			BufferedImage textLabel = ImageIO.read(new File("textLabel.png"));
			graphics = background.createGraphics();
			graphics.drawImage(textLabel, text.getX(), this.getHeight()-(50+text.getY()), text.getWidth(), 30, null);
			graphics.dispose();
			
			setTextImage(textLabel, text);
			setTransitionImage(transition, x, y, width, height);
			setBackgroundImage(background);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "A imagem inserida não foi encontrada!");
		}
	}
	
	public void setTextImage(BufferedImage bufferedImage, Text text) {
		ImageIcon imageIcon = new ImageIcon(bufferedImage);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(text.getWidth(), 30, 100));
		textLabel.setIcon(imageIcon);
	}
	
}

