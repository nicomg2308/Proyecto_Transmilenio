package controller;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Main;

public class PanelContenido extends JPanel {

	// Constructor de la clase, crea una JTextArena que no es editable donde se
	// vera
	// todo el texto creado por el programa
	public PanelContenido() {
		this.setLayout(new BorderLayout());
		t = new JTextArea(5, 20);
		t.setEditable(false);
		t.append("Bienvenido!");
		JScrollPane s = new JScrollPane(t);
		this.add(s);

	}

	// Agrega texto recibido al area de texto que se muestra en pantalla
	public void addNewLine(String s) {
		t.append("\n" + s);
		t.setCaretPosition(t.getDocument().getLength());
	}

	private JTextArea t;
}
