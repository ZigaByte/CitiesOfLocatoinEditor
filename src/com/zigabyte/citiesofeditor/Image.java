
package com.zigabyte.citiesofeditor;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Image {

	public static BufferedImage image;
	public static BufferedImage cross;

	public static void loadImage() {
		try {
			image = ImageIO.read(Image.class.getResource("/mapa.png"));
			cross = ImageIO.read(Image.class.getResource("/cross_green.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
