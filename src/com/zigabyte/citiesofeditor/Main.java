
package com.zigabyte.citiesofeditor;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main {

	static JFrame frame;
	static Canvas canvas;
	static JTextField name;
	static JTextArea box;
	static JButton button;

	public static int x, y;

	public Main() {
		Image.loadImage();

		// instantiate the JFrame
		frame = new JFrame();
		frame.setTitle("CitiesOfLocationEditor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();

		// setup the Canvas
		canvas = new Canvas();
		canvas.setBackground(Color.black);
		canvas.setPreferredSize(new Dimension(800, 480));
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				Main.x = arg0.getX();
				Main.y = arg0.getY();
				Main.render();
			}

			public void mouseExited(MouseEvent arg0) {}

			public void mouseEntered(MouseEvent arg0) {}

			public void mouseClicked(MouseEvent arg0) {}
		});
		panel.add(canvas);

		// Setup the results area
		box = new JTextArea();
		box.setPreferredSize(new Dimension(300, 300));
		box.setText("CLICK ON THE BLACK SCREEN FOR THE MAP TO APPEAR AND SET UP THE RIGHT COORDINATES\n");
		box.append("Your cities and coordinates will end up here:\n");
		panel.add(box);

		// Your city naame input area
		name = new JTextField();
		name.setPreferredSize(new Dimension(200, 100));
		name.setText("Put your city name here");
		panel.add(name);

		// The confirm button
		button = new JButton();
		button.setPreferredSize(new Dimension(200, 100));
		button.setText("Confirm !");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				box.append(name.getText().substring(3).toUpperCase() + "( \"" + name.getText() + "," + x + ", " + y + "\" ),\n ");
				name.setText("");
			}
		});
		panel.add(button);

		// more frame instatiation
		frame.add(panel);
		frame.setSize(new Dimension(800, 800));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);


		render();
	}


	public static void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, 800, 480);

		g.drawImage(Image.image, 0, 0, 800, 480, null);
		g.drawImage(Image.cross, x - 10, y - 10, 20, 20, null);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Main();
	}

}
