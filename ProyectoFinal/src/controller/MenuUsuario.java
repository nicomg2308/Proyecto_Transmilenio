package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuUsuario extends Menu {

	// Constructor de la clase, aniade todos los botones que debe tener el menu
	// de un usuario
	public MenuUsuario() {
		super();

		// Cuando lo presionan, este boton pregunta un nombre, y llama a main
		// para consultar
		// informacion sobre una estacion con ese nombre
		JMenuItem infoEstacion = new JMenuItem("Informacion sobre una estacion");
		infoEstacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("De que estacion desea obtener la informacion?");
				nombre = nombre.toLowerCase();
				nombre = nombre.replaceAll(" ", "");
				Main.infoEstacion(nombre);
			}
		});

		// Cuando lo presionan, este botonpregunta por el nombre de 2
		// estaciones, una destino y
		// otra inicio, y con esos 2 nombres llama al metodo en Main que muestra
		// las rutas entre
		// esas 2 estaciones
		JMenuItem planear = new JMenuItem("Planear viaje");
		planear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inicio = JOptionPane.showInputDialog("Desde cual estacion desea iniciar?");
				inicio = inicio.toLowerCase();
				inicio = inicio.replaceAll(" ", "");
				String destino = JOptionPane.showInputDialog("A cual estacion desea llegar?");
				destino = destino.toLowerCase();
				destino = destino.replaceAll(" ", "");
				Main.planear(inicio, destino);
			}
		});

		// Cuando este boton es presionado, pregunta por un nombre, luego llama
		// a Main para que
		// muestre las paradas por las que para una ruta con ese nombre.
		JMenuItem infoRuta = new JMenuItem("Informacion sobre ruta");
		infoRuta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ruta = JOptionPane.showInputDialog("Las paradas de cual ruta desea ver?");
				ruta = ruta.toLowerCase();
				ruta = ruta.replaceAll(" ", "");
				Main.mostrarParadas(ruta);
			}
		});

		add(infoRuta);
		add(infoEstacion);
		add(planear);
	}

}
