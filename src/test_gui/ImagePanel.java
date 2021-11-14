package test_gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
	private Image img;
	
	public ImagePanel()
	{
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("car.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(690, 590,
		        Image.SCALE_SMOOTH);
		
		this.img = dimg;
		
    }

	public void paintComponent(Graphics g)
	{
		g.drawImage(img, 0, 0, null);
	}
}
