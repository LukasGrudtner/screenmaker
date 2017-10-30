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
import model.Transition;

public class DisplayPanel extends JPanel {
	
	private static final String ASSETS_PATH = "assets" + File.separator;
	private static final String RESIZED_BACKGROUND = "resizedBackground.png";
	private static final String TEXT_IMAGE = "textLabel.png";
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
	
	public void setTextImage(BufferedImage bufferedImage, Text text) {
		ImageIcon imageIcon = new ImageIcon(bufferedImage);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(text.getWidth(), 30, 100));
		textLabel.setIcon(imageIcon);
	}
	
	public void showDisplay(String backgroundPath, Text text) {
		try {
			/* BufferedImage para o plano de fundo. */
			BufferedImage background = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
			
			/* BufferedImage para a imagem do plano de fundo. */
			BufferedImage backgroundImage = ImageIO.read(new File(ASSETS_PATH + backgroundPath));
			
			/* Cria uma tela com as dimensões especificadas para o background, e desenha a imagem do background. */
			Graphics2D graphics = background.createGraphics();
			graphics.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
			ImageIO.write(background, "PNG", new File(ASSETS_PATH + RESIZED_BACKGROUND));
			
			/* Insere a imagem de transição. */
			background = ImageIO.read(new File(ASSETS_PATH + RESIZED_BACKGROUND));
//			BufferedImage transitionImage = ImageIO.read(new File(ASSETS_PATH + transition.getImagePath()));
			graphics = background.createGraphics();
//			graphics.drawImage(transitionImage, transition.getX(), this.getHeight()-(transition.getHeight()+transition.getY()), transition.getWidth(), transition.getHeight(), null);
			ImageIO.write(background, "PNG", new File(ASSETS_PATH + RESIZED_BACKGROUND));
			
			/* Insere a imagem de texto. */
			if (!text.getText().isEmpty()) {
				background = ImageIO.read(new File(ASSETS_PATH + RESIZED_BACKGROUND));
				BufferedImage textLabel = ImageIO.read(new File(ASSETS_PATH + TEXT_IMAGE));
				graphics = background.createGraphics();
				graphics.drawImage(textLabel, text.getX(), this.getHeight()-(50+text.getY()), text.getWidth(), 30, null);
				setTextImage(textLabel, text);
			}
			
//			setTransitionImage(transitionImage, transition.getX(), transition.getY(), transition.getWidth(), transition.getHeight());
			setBackgroundImage(background);
			
			graphics.dispose();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "A imagem inserida não foi encontrada!");
		}
	}
	
	
}

