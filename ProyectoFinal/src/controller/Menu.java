package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import controller.Main;

public abstract class Menu extends JMenuBar {

	public Menu() {

		// Cada vez que se presiona este boton, se alterna entre los roles de
		// administrador y usuario
		JMenuItem cambioRol = new JMenuItem("Cambiar de rol");
		cambioRol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.cambioRol();
			}
		});

		// Al presionar este boton se cierra el programa
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.salir();
			}
		});

		opciones = new JMenu("Opciones");

		opciones.add(cambioRol);
		opciones.add(salir);

		add(opciones);

	}

	protected JMenu opciones;
}
