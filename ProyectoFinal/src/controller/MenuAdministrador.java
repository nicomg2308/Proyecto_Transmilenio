package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuAdministrador extends Menu {

	// Constructor de la clase, aniade todos los botones que debe tener el menu
	// de un administrador
	public MenuAdministrador() {
		super();

		// Cuando es presionado, este boton llama a la funcion en main que
		// permite cargar
		// troncales, rutas y estaciones de disco
		JMenuItem cargar = new JMenuItem("Cargar Troncales y Rutas");
		cargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.cargar();
			}
		});

		// Cuando es presionado, este boton llama a la funcion en main que
		// permite guardar
		// troncales, rutas y estaciones a disco
		JMenuItem guardar = new JMenuItem("Guardar Troncales y Rutas");
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.guardar();
			}
		});

		// Cuando se presiona este boton, se llama la funcion de Main que hace
		// que las
		// estaciones, rutas y troncales actuales del programa se vuelvan las
		// que hay por defecto.
		JMenuItem formatear = new JMenuItem("Formatear Troncales y Rutas");
		formatear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.inicializarEstacionesYRutas();
			}
		});

		// Se agregan los botone formatear, guardar y cargar al menu de opciones
		// que tiene la superclase(Menu)
		super.opciones.add(formatear);
		super.opciones.add(guardar);
		super.opciones.add(cargar);

		JMenu menuTroncales = new JMenu("Troncales");

		// Este boton recibe toda la informacion necesaria para llamar a la
		// funcion apropiada en Main para
		// agregar nuevas estaciones a alguna troncal.
		JMenuItem aniadirEstacion = new JMenuItem("Aniadir estacion");
		aniadirEstacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] botones = { "Referencia a otra estacion", "Indice", "Cancelar" };
				int opcion = JOptionPane.showOptionDialog(null,
						"Desea aniadir la nueva estacion con referencia a una estacion existente o dando un indice?",
						"", JOptionPane.PLAIN_MESSAGE, 0, null, botones, botones[2]);
				if (opcion == 0) {
					botones[0] = "Antes";
					botones[1] = "Despues";
					botones[2] = "Cancelar";
					String nombre = JOptionPane.showInputDialog("Que nombre desea que tenga la nueva estacion?");
					nombre = nombre.toLowerCase();
					nombre = nombre.replaceAll(" ", "");
					String troncal = JOptionPane.showInputDialog("En que troncal desea agregarla?");
					troncal = troncal.toLowerCase();
					troncal = troncal.replaceAll(" ", "");
					String estacion = JOptionPane.showInputDialog("Con referencia a cual estacion desea agregarla?");
					estacion = estacion.toLowerCase();
					troncal = troncal.replaceAll(" ", "");

					opcion = JOptionPane.showOptionDialog(null,
							"Desea aniadir la nueva estacion antes o despues de una estacion existente?", "",
							JOptionPane.PLAIN_MESSAGE, 0, null, botones, botones[2]);
					if (opcion == 0 || opcion == 1) {
						Main.aniadirEstacion(troncal, nombre, estacion, opcion == 0);
					} else {
						// Cancelado
					}
				} else {
					if (opcion == 1) {
						try {
							int indice = Integer.parseInt(
									JOptionPane.showInputDialog("En que indice desea ingresar la nueva estacion?"));
							String nombre = JOptionPane
									.showInputDialog("Que nombre desea que tenga la nueva estacion?");
							nombre = nombre.toLowerCase();
							nombre = nombre.replaceAll(" ", "");
							String troncal = JOptionPane.showInputDialog("En que troncal desea agregarla?");
							troncal = troncal.toLowerCase();
							troncal = troncal.replaceAll(" ", "");
							Main.aniadirEstacion(troncal, nombre, indice);
						} catch (Exception excepcion) {
							excepcion.printStackTrace();
						}
					} else {
						// Cancelado
					}
				}
			}
		});

		// Este boton recibe toda la informacion necesaria para llamar a la
		// funcion apropiada en Main para
		// remover estaciones de alguna troncal.
		JMenuItem removerEstacion = new JMenuItem("Remover Estacion");
		removerEstacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] botones = { "Nombre", "Indice", "Cancelar" };
				int opcion = JOptionPane.showOptionDialog(null,
						"Desea remover la estacion por nombre o por indice en la troncal?", "",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[2]);
				if (opcion == 0) {
					String troncal = JOptionPane.showInputDialog("De que troncal desea eliminar la estacion?");
					troncal = troncal.toLowerCase();
					troncal = troncal.replaceAll(" ", "");
					System.out.println(troncal.toLowerCase());
					String estacion = JOptionPane.showInputDialog("Que estacion desea eliminar?");
					estacion = estacion.toLowerCase();
					estacion = estacion.replaceAll(" ", "");
					Main.removerEstacion(troncal, estacion);
				} else {
					if (opcion == 1) {
						try {
							String troncal = JOptionPane.showInputDialog("De que troncal desea eliminar la estacion?");
							troncal = troncal.toLowerCase();
							troncal = troncal.replaceAll(" ", "");
							int indice = Integer.parseInt(JOptionPane
									.showInputDialog("Cual es el indice de la estacion que desea eliminar?"));
							Main.removerEstacion(troncal, indice);
						} catch (Exception excepcion) {
							Main.aniadirTexto(
									"Ha habido un error al ingresar la estacion!, procure ingresar unicamente un numero como indice");
						}
					}
				}
			}
		});

		// Este boton pregunta por un nombre, luego llama a Main para que
		// muestre las estaciones que hay
		// en una troncal con ese nombre
		JMenuItem verEstaciones = new JMenuItem("Ver estaciones");
		verEstaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String troncal = JOptionPane.showInputDialog("Las estaciones de cual troncal desea ver?");
					troncal = troncal.toLowerCase();
					troncal = troncal.replaceAll(" ", "");
					Main.mostrarEstaciones(troncal);
				} catch (Exception excepcion) {
					Main.aniadirTexto("Ha ocurrido un error");
					excepcion.printStackTrace();
				}
			}
		});

		menuTroncales.add(aniadirEstacion);
		menuTroncales.add(removerEstacion);
		menuTroncales.add(verEstaciones);

		JMenu menuRutas = new JMenu("Rutas");

		// Este boton recibe toda la informacion necesaria para llamar a la
		// funcion en Main para
		// agregar una nueva ruta.
		JMenuItem aniadirRuta = new JMenuItem("Aniadir ruta");
		aniadirRuta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre que desea que tenga la ruta");
				nombre = nombre.toLowerCase();
				nombre = nombre.replaceAll(" ", "");
				int numeroDeParadas = 1;
				ArrayList<String> paradas = new ArrayList<>();
				try {
					numeroDeParadas = Integer
							.parseInt(JOptionPane.showInputDialog("Cuantas paradas desea que haga la ruta?"));
					for (int i = 0; i < numeroDeParadas; i++)
						paradas.add(
								JOptionPane.showInputDialog("Ingrese el nombre de la estacion #" + i + " de la ruta"));
					Main.aniadirRuta(nombre, paradas);
				} catch (Exception excepcion) {
					Main.aniadirTexto("Ha ingresado un numero invalido");
					excepcion.printStackTrace();
				}
			}
		});

		// Pregunta un nombre, luego llama a Main para que remueva una ruta con
		// ese nombre
		JMenuItem removerRuta = new JMenuItem("Remover ruta");
		removerRuta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.removerRuta(JOptionPane.showInputDialog("Ingrese el nombre que de la ruta que desea remover"));

			}
		});

		// Este boton recibe toda la informacion necesaria para llamar a la
		// funcion apropiada en Main para
		// agregar nuevas paradas a alguna ruta.
		JMenuItem aniadirParada = new JMenuItem("Aniadir parada");
		aniadirParada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] botones = { "Referencia a otra parada", "Indice", "Cancelar" };
				int opcion = JOptionPane.showOptionDialog(null,
						"Desea aniadir la nueva parada con referencia a una parada existente o dando un indice?", "",
						JOptionPane.PLAIN_MESSAGE, 0, null, botones, botones[2]);
				if (opcion == 0) {
					botones[0] = "Antes";
					botones[1] = "Despues";
					botones[2] = "Cancelar";
					String nombre = JOptionPane.showInputDialog("Cual es el nombre de la parada que desea agregar?");
					nombre = nombre.toLowerCase();
					nombre = nombre.replaceAll(" ", "");
					String ruta = JOptionPane.showInputDialog("En que ruta desea agregarla?");
					ruta = ruta.toLowerCase();
					ruta = ruta.replaceAll(" ", "");
					String parada = JOptionPane.showInputDialog("Con referencia a cual parada desea agregarla?");
					parada = parada.toLowerCase();
					parada = parada.replaceAll(" ", "");

					opcion = JOptionPane.showOptionDialog(null,
							"Desea aniadir la nueva parada antes o despues de una parada existente?", "",
							JOptionPane.PLAIN_MESSAGE, 0, null, botones, botones[2]);
					System.out.println(opcion);
					if (opcion == 0 || opcion == 1) {
						Main.aniadirParada(ruta, nombre, parada, opcion == 0);
					} else {
						// Cancelado
					}
				} else {
					if (opcion == 1) {
						try {
							int indice = Integer.parseInt(
									JOptionPane.showInputDialog("En que indice desea ingresar la nueva parada?"));
							String nombre = JOptionPane
									.showInputDialog("Cual es el nombre de la parada que desea agregar?");
							nombre = nombre.toLowerCase();
							nombre = nombre.replaceAll(" ", "");
							String ruta = JOptionPane.showInputDialog("En que ruta desea agregarla?");
							ruta = ruta.toLowerCase();
							ruta = ruta.replaceAll(" ", "");
							Main.aniadirParada(ruta, nombre, indice);
						} catch (Exception excepcion) {
							excepcion.printStackTrace();
							Main.aniadirTexto("Ha ocurrido un error al intentar agregar la parada!");
						}
					} else {
						// Cancelado
					}
				}
			}
		});

		// Este boton recibe toda la informacion necesaria para llamar a la
		// funcion apropiada en Main para
		// remover paradas de alguna ruta.
		JMenuItem removerParada = new JMenuItem("Remover parada");
		removerParada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] botones = { "Nombre", "Indice", "Cancelar" };
				int opcion = JOptionPane.showOptionDialog(null,
						"Desea remover la parada por nombre o por indice en la ruta?", "", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, botones, botones[2]);
				if (opcion == 0) {
					String ruta = JOptionPane.showInputDialog("De que ruta desea eliminar la parada?");
					ruta = ruta.toLowerCase();
					ruta = ruta.replaceAll(" ", "");
					String parada = JOptionPane.showInputDialog("Que parada desea eliminar?");
					parada = parada.toLowerCase();
					parada = parada.replaceAll(" ", "");
					Main.removerParada(ruta, parada);
				} else {
					if (opcion == 1) {
						String ruta = JOptionPane.showInputDialog("De que ruta desea eliminar la parada?");
						ruta = ruta.toLowerCase();
						ruta = ruta.replaceAll(" ", "");
						try {
							int indice = Integer.parseInt(
									JOptionPane.showInputDialog("Cual es el indice de la parada que desea eliminar?"));
							Main.removerParada(ruta, indice);
						} catch (Exception excepcion) {
							Main.aniadirTexto(
									"Ha habido un error al ingresar la parada!, procure ingresar unicamente un numero como indice");
						}
					}
				}
			}
		});

		// Pregunta por un nombre, luego llama a Main para que muestre las
		// paradas de una ruta
		// con ese nombre.
		JMenuItem verParadas = new JMenuItem("Ver paradas");
		verParadas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String ruta = JOptionPane.showInputDialog("Las paradas de cual ruta desea ver?");
					ruta = ruta.toLowerCase();
					ruta = ruta.replaceAll(" ", "");
					Main.mostrarParadas(ruta);
				} catch (Exception excepcion) {
					Main.aniadirTexto("Ha ocurrido un error");
					excepcion.printStackTrace();
				}
			}
		});

		// Llama a la funcion en Main que muestra todas las rutas existentes
		JMenuItem verRutas = new JMenuItem("Ver rutas");
		verRutas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.mostrarRutas();
			}
		});

		menuRutas.add(aniadirRuta);
		menuRutas.add(removerRuta);
		menuRutas.add(aniadirParada);
		menuRutas.add(removerParada);
		menuRutas.add(verRutas);
		menuRutas.add(verParadas);

		add(menuTroncales);
		add(menuRutas);
	}
}
