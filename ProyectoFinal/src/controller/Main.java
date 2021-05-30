package controller;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class Main {

	// Inicializa la ventana, le coloca un titulo, hace que sea visible, coloca
	// su tamanio por defecto,
	// hace que el color de fondo sea blanco y que al presionar la X se cierre
	// el programa
	private static void inicializarGraficas() {
		ventana = new Ventana();
		ventana.setTitle("Proyecto 6 - Transmilenio(Modo usuario)");
		ventana.setVisible(true);
		ventana.setBounds(0, 0, 800, 500);
		ventana.setBackground(Color.WHITE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Recibe una troncal, un nombre para la nueva estacion, una estacion en la
	// troncal para usar como punto
	// de referencia y un booleano que determina si la nueva estacion se coloca
	// antes o despues de la
	// estacion de referencia. Busca en todas las troncales de la lista hasta
	// encontrar la troncal dada, y
	// llama el metodo apropiado de la troncal para aniadir la nueva estacion.
	public static void aniadirEstacion(String troncal, String nombre, String estacion, boolean b) {
		if (b == siguiente) {
			for (int i = 0; i < troncales.size(); i++)
				if (troncales.get(i).obtenerNombre().equals(troncal))
					troncales.get(i).aniadirSiguienteEstacion(nombre, estacion);
		} else {
			for (int i = 0; i < troncales.size(); i++)
				if (troncales.get(i).obtenerNombre().equals(troncal))
					troncales.get(i).aniadirAnteriorEstacion(nombre, estacion);
		}
	}

	// Crea las estaciones, troncales y rutas que se usan por defecto en el
	// programa
	public static void inicializarEstacionesYRutas() {
		troncales = new ArrayList<>();

		ArrayList<String> listaautonorte = new ArrayList<>();
		listaautonorte.add("portalnorte");
		listaautonorte.add("toberin");
		listaautonorte.add("cardioinfantil");
		listaautonorte.add("mazuren");
		listaautonorte.add("calle146");
		listaautonorte.add("calle142");
		listaautonorte.add("alcala");
		listaautonorte.add("prado");
		listaautonorte.add("calle127");
		listaautonorte.add("pepesierra");
		listaautonorte.add("calle106");
		listaautonorte.add("calle100");
		listaautonorte.add("virrey");
		listaautonorte.add("calle85");
		listaautonorte.add("heroes");
		Troncal autonorte = new Troncal("autopistanorte", listaautonorte);
		troncales.add(autonorte);

		ArrayList<String> listacaracas = new ArrayList<>();
		listacaracas.add("heroes");
		listacaracas.add("calle76");
		listacaracas.add("calle72");
		listacaracas.add("flores");
		listacaracas.add("calle63");
		listacaracas.add("calle57");
		listacaracas.add("marly");
		listacaracas.add("calle45");
		listacaracas.add("av39");
		listacaracas.add("profamilia");
		listacaracas.add("calle26");
		listacaracas.add("calle22");
		listacaracas.add("calle19");
		listacaracas.add("avjimenez");
		listacaracas.add("tercermilenio");
		Troncal caracas = new Troncal("caracas", listacaracas);
		troncales.add(caracas);

		ArrayList<String> listasuba = new ArrayList<>();
		listasuba.add("portalsuba");
		listasuba.add("la Campiña");
		listasuba.add("suba-tv91");
		listasuba.add("21angeles");
		listasuba.add("gratamira");
		listasuba.add("suba-avboyaca");
		listasuba.add("niza-cl127");
		listasuba.add("humedalcordoba");
		listasuba.add("shaio");
		listasuba.add("puentelargo");
		listasuba.add("suba-cl100");
		listasuba.add("suba-cl95");
		listasuba.add("rionegro");
		listasuba.add("sanmartin");
		Troncal suba = new Troncal("suba", listasuba);
		troncales.add(suba);

		ArrayList<String> listaamericas = new ArrayList<>();
		listaamericas.add("avjimenez");
		listaamericas.add("delasabana");
		listaamericas.add("sanfazon-kr22");
		listaamericas.add("ricaurte");
		listaamericas.add("cds-carrera32");
		listaamericas.add("zonaindustrial");
		listaamericas.add("carrera43");
		listaamericas.add("puentearanda");
		listaamericas.add("americas-kr53a");
		listaamericas.add("pradera");
		listaamericas.add("marsella");
		listaamericas.add("mundoaventura");
		listaamericas.add("mandalay");
		listaamericas.add("banderas");
		listaamericas.add("transversal86");
		listaamericas.add("bibliotecatintal");
		listaamericas.add("patiobonito");
		listaamericas.add("portalamericas");
		Troncal americas = new Troncal("americas", listaamericas);
		troncales.add(americas);

		rutas = new ArrayList<>();
		ArrayList<String> listab1 = new ArrayList<>();
		listab1.add("portalamericas");
		listab1.add("patiobonito");
		listab1.add("bibliotecatintal");
		listab1.add("transversal86");
		listab1.add("banderas");
		listab1.add("mandalay");
		listab1.add("mundoaventura");
		listab1.add("marsella");
		listab1.add("pradera");
		listab1.add("americas-kr53a");
		listab1.add("puentearanda");
		listab1.add("carrera43");
		listab1.add("zonaindustrial");
		listab1.add("cds-carrera32");
		listab1.add("ricaurte");
		listab1.add("sanfazon-kr22");
		listab1.add("delasabana");
		listab1.add("avjimenez");
		listab1.add("calle19");
		listab1.add("calle22");
		listab1.add("calle26");
		listab1.add("profamilia");
		listab1.add("av39");
		listab1.add("calle45");
		listab1.add("marly");
		listab1.add("calle57");
		listab1.add("calle63");
		listab1.add("flores");
		listab1.add("calle72");
		listab1.add("cale76");
		listab1.add("heroes");
		listab1.add("calle 85");
		listab1.add("virrey");
		listab1.add("calle100");
		listab1.add("calle106");
		listab1.add("pepesierra");
		listab1.add("calle127");
		listab1.add("prado");
		listab1.add("alcala");
		listab1.add("calle142");
		listab1.add("calle146");
		listab1.add("mazuren");
		listab1.add("cardioinfantil");
		listab1.add("toberin");
		listab1.add("portalnorte");
		Ruta b1 = new Ruta("b1", listab1);
		rutas.add(b1);

		ArrayList<String> listaf1 = new ArrayList<>();
		listaf1.add("portalnorte");
		listaf1.add("toberin");
		listaf1.add("cardioinfantil");
		listaf1.add("mazuren");
		listaf1.add("calle146");
		listaf1.add("calle142");
		listaf1.add("alcala");
		listaf1.add("prado");
		listaf1.add("calle 127");
		listaf1.add("pepesierra");
		listaf1.add("calle106");
		listaf1.add("calle100");
		listaf1.add("virrey");
		listaf1.add("calle85");
		listaf1.add("heroes");
		listaf1.add("calle76");
		listaf1.add("calle72");
		listaf1.add("flores");
		listaf1.add("calle63");
		listaf1.add("calle57");
		listaf1.add("marly");
		listaf1.add("calle45");
		listaf1.add("av39");
		listaf1.add("profamilia");
		listaf1.add("calle26");
		listaf1.add("calle22");
		listaf1.add("calle19");
		listaf1.add("avjimenez");
		listaf1.add("delasabana");
		listaf1.add("sanfazon-kr22");
		listaf1.add("ricaurte");
		listaf1.add("cds-carrera32");
		listaf1.add("zonaindustrial");
		listaf1.add("carrera 43");
		listaf1.add("puentearanda");
		listaf1.add("americas-kr53a");
		listaf1.add("pradera");
		listaf1.add("marsella");
		listaf1.add("mundoaventura");
		listaf1.add("mandalay");
		listaf1.add("banderas");
		listaf1.add("transversal86");
		listaf1.add("bibliotecatintal");
		listaf1.add("patiobonito");
		listaf1.add("portalamericas");
		Ruta f1 = new Ruta("f1", listaf1);
		rutas.add(f1);

		ArrayList<String> listaf19 = new ArrayList<>();
		listaf19.add("portalsuba");
		listaf19.add("lacampiña");
		listaf19.add("suba-tv91");
		listaf19.add("gratamira");
		listaf19.add("puentelargo");
		listaf19.add("suba-cl100");
		listaf19.add("calle72");
		listaf19.add("calle63");
		listaf19.add("marly");
		listaf19.add("calle45");
		listaf19.add("profamilia");
		listaf19.add("calle26");
		listaf19.add("calle19");
		listaf19.add("ricaurte");
		listaf19.add("zonaindustrial");
		listaf19.add("americas-kr53a");
		listaf19.add("marsella");
		listaf19.add("mandalay");
		listaf19.add("banderas");
		Ruta f19 = new Ruta("f19", listaf19);
		rutas.add(f19);

		ArrayList<String> listac19 = new ArrayList<>();
		listac19.add("banderas");
		listac19.add("mandalay");
		listac19.add("marsella");
		listac19.add("americas-kr53a");
		listac19.add("zonaindustrial");
		listac19.add("ricaurte");
		listac19.add("calle19");
		listac19.add("calle26");
		listac19.add("profamilia");
		listac19.add("calle45");
		listac19.add("marly");
		listac19.add("calle63");
		listac19.add("calle72");
		listac19.add("suba-cl100");
		listac19.add("puentelargo");
		listac19.add("gratamira");
		listac19.add("suba-tv91");
		listac19.add("lacampiña");
		listac19.add("portalsuba");
		Ruta c19 = new Ruta("c19", listac19);
		rutas.add(c19);

		ArrayList<String> listaf14 = new ArrayList<>();
		listaf14.add("portalnorte");
		listaf14.add("calle146");
		listaf14.add("alcala");
		listaf14.add("calle127");
		listaf14.add("calle106");
		listaf14.add("calle100");
		listaf14.add("calle85");
		listaf14.add("heroes");
		listaf14.add("marly");
		listaf14.add("calle45");
		listaf14.add("profamilia");
		listaf14.add("calle26");
		listaf14.add("delasabana");
		listaf14.add("cds-carrera 32");
		listaf14.add("pradera");
		listaf14.add("banderas");
		listaf14.add("transversal86");
		listaf14.add("bibliotecatintal");
		listaf14.add("portalamericas");
		Ruta f14 = new Ruta("f14", listaf14);
		rutas.add(f14);

		ArrayList<String> listab14 = new ArrayList<>();
		listab14.add("portalamericas");
		listab14.add("bibliotecatintal");
		listab14.add("transversal86");
		listab14.add("banderas");
		listab14.add("pradera");
		listab14.add("cds-carrera32");
		listab14.add("delasabana");
		listab14.add("calle26");
		listab14.add("profamilia");
		listab14.add("calle45");
		listab14.add("marly");
		listab14.add("heroes");
		listab14.add("calle85");
		listab14.add("calle100");
		listab14.add("calle106");
		listab14.add("calle127");
		listab14.add("alcala");
		listab14.add("calle146");
		listab14.add("portalnorte");
		Ruta b14 = new Ruta("b14", listab14);
		rutas.add(b14);

		ArrayList<String> listab50 = new ArrayList<>();
		listab50.add("portalsuba");
		listab50.add("lacampiña");
		listab50.add("suba-tv91");
		listab50.add("21angeles");
		listab50.add("shaio");
		listab50.add("rionegro");
		listab50.add("heroes");
		listab50.add("calle85");
		listab50.add("virrey");
		listab50.add("calle100");
		listab50.add("calle142");
		listab50.add("cardioinfantil");
		listab50.add("portalnorte");
		Ruta b50 = new Ruta("b50", listab50);
		rutas.add(b50);

		ArrayList<String> listac61 = new ArrayList<>();
		listac61.add("portalnorte");
		listac61.add("cardioinfantil");
		listac61.add("calle142");
		listac61.add("calle100");
		listac61.add("virrey");
		listac61.add("calle85");
		listac61.add("heroes");
		listac61.add("rionegro");
		listac61.add("shaio");
		listac61.add("21angeles");
		listac61.add("suba-tv91");
		listac61.add("lacampiña");
		listac61.add("portalsuba");
		Ruta c61 = new Ruta("c61", listac61);
		rutas.add(c61);

		ArrayList<String> listac29 = new ArrayList<>();
		listac29.add("portalamericas");
		listac29.add("patiobonito");
		listac29.add("bibliotecatintal");
		listac29.add("banderas");
		listac29.add("calle 26");
		listac29.add("profamilia");
		listac29.add("marly");
		listac29.add("calle63");
		listac29.add("calle72");
		listac29.add("suba-calle100");
		listac29.add("shaio");
		listac29.add("suba-tv91");
		listac29.add("lacampiña");
		listac29.add("portalsuba");
		Ruta c29 = new Ruta("c29", listac29);
		rutas.add(c29);

		ArrayList<String> listaf29 = new ArrayList<>();
		listaf29.add("portalsuba");
		listaf29.add("lacampiña");
		listaf29.add("suba-tv91");
		listaf29.add("shaio");
		listaf29.add("suba-calle100");
		listaf29.add("calle 72");
		listaf29.add("calle63");
		listaf29.add("marly");
		listaf29.add("profamilia");
		listaf29.add("calle 26");
		listaf29.add("banderas");
		listaf29.add("bibliotecatintal");
		listaf29.add("patiobonito");
		listaf29.add("portalamericas");
		Ruta f29 = new Ruta("f29", listaf29);
		rutas.add(f29);

		ArrayList<String> listaa74 = new ArrayList<>();
		listaa74.add("toberin");
		listaa74.add("calle146");
		listaa74.add("calle142");
		listaa74.add("alcala");
		listaa74.add("prado");
		listaa74.add("calle127");
		listaa74.add("calle76");
		listaa74.add("calle72");
		Ruta a74 = new Ruta("A74", listaa74);
		rutas.add(a74);

		ArrayList<String> listab74 = new ArrayList<>();
		listab74.add("universidades");
		listab74.add("av39");
		listab74.add("calle57");
		listab74.add("calle72");
		listab74.add("calle76");
		listab74.add("heroes");
		listab74.add("virrey");
		listab74.add("calle100");
		listab74.add("prado");
		listab74.add("calle142");
		listab74.add("toberin");
		listab74.add("portalnorte");
		Ruta b74 = new Ruta("b74", listab74);
		rutas.add(b74);

		ArrayList<String> listaf23 = new ArrayList<>();
		listaf23.add("lasaguas");
		listaf23.add("avjimenez");
		listaf23.add("sanfazon-kr22");
		listaf23.add("ricaurte");
		listaf23.add("mundoaventura");
		listaf23.add("banderas");
		listaf23.add("patiobonito");
		listaf23.add("portalamericas");
		Ruta f23 = new Ruta("f23", listaf23);
		rutas.add(f23);

		ArrayList<String> listaj23 = new ArrayList<>();
		listaj23.add("portalamericas");
		listaj23.add("patiobonito");
		listaj23.add("banderas");
		listaj23.add("mundoaventura");
		listaj23.add("ricaurte");
		listaj23.add("sanfazon-kr22");
		listaj23.add("avjimenez");
		listaj23.add("lasaguas");
		Ruta j23 = new Ruta("j23", listaj23);
		rutas.add(j23);

		ArrayList<String> listab13 = new ArrayList<>();
		listab13.add("tercermilenio");
		listab13.add("calle22");
		listab13.add("av39");
		listab13.add("calle63");
		listab13.add("flores");
		listab13.add("calle85");
		listab13.add("calle100");
		listab13.add("calle106");
		listab13.add("calle142");
		listab13.add("mazuren");
		listab13.add("cardioinfantil");
		listab13.add("portalnorte");
		Ruta b13 = new Ruta("b13", listab13);
		rutas.add(b13);

		ArrayList<String> listah13 = new ArrayList<>();
		listah13.add("portalnorte");
		listah13.add("cardioinfantil");
		listah13.add("mazuren");
		listah13.add("calle142");
		listah13.add("calle106");
		listah13.add("calle100");
		listah13.add("calle85");
		listah13.add("flores");
		listah13.add("calle63");
		listah13.add("av39");
		listah13.add("calle22");
		listah13.add("tercermilenio");
		Ruta h13 = new Ruta("h13", listah13);
		rutas.add(h13);

		ArrayList<String> listac15 = new ArrayList<>();
		listac15.add("tercermilenio");
		listac15.add("calle19");
		listac15.add("calle22");
		listac15.add("av39");
		listac15.add("calle45");
		listac15.add("marly");
		listac15.add("Calle 76");
		listac15.add("escuelamilitar");
		listac15.add("puentelargo");
		listac15.add("humedalcordoba");
		listac15.add("niza-cl127");
		listac15.add("21angeles");
		listac15.add("portalsuba");
		Ruta c15 = new Ruta("c15", listac15);
		rutas.add(c15);

		ArrayList<String> listac4 = new ArrayList<>();
		listac4.add("tercermilenio");
		listac4.add("avjimenez");
		listac4.add("calle19");
		listac4.add("calle22");
		listac4.add("calle26");
		listac4.add("profamilia");
		listac4.add("av39");
		listac4.add("calle45");
		listac4.add("marly");
		listac4.add("calle57");
		listac4.add("calle63");
		listac4.add("flores");
		listac4.add("calle72");
		listac4.add("calle76");
		listac4.add("polo");
		listac4.add("escuelamilitar");
		listac4.add("sanmartin");
		listac4.add("rionegro");
		listac4.add("suba-cl95");
		listac4.add("suba-cl100");
		listac4.add("puentelargo");
		listac4.add("shaio");
		listac4.add("humedalcordoba");
		listac4.add("niza-cl127");
		listac4.add("suba-avboyaca");
		listac4.add("gratamira");
		listac4.add("21angeles");
		listac4.add("suba-tv91");
		listac4.add("lacampiña");
		listac4.add("portalsuba");
		Ruta c4 = new Ruta("c4", listac4);
		rutas.add(c4);

		ArrayList<String> listah4 = new ArrayList<>();
		listah4.add("portalsuba");
		listah4.add("lacampiña");
		listah4.add("suba-tv91");
		listah4.add("21angeles");
		listah4.add("gratamira");
		listah4.add("suba-avboyaca");
		listah4.add("niza-cl127");
		listah4.add("humedalcordoba");
		listah4.add("shaio");
		listah4.add("puentelargo");
		listah4.add("suba-cl100");
		listah4.add("suba-cl95");
		listah4.add("rionegro");
		listah4.add("sanmartin");
		listah4.add("escuelamilitar");
		listah4.add("polo");
		listah4.add("calle76");
		listah4.add("calle72");
		listah4.add("flores");
		listah4.add("calle63");
		listah4.add("calle57");
		listah4.add("marly");
		listah4.add("calle45");
		listah4.add("av39");
		listah4.add("profamilia");
		listah4.add("calle26");
		listah4.add("calle22");
		listah4.add("calle19");
		listah4.add("avjimenez");
		listah4.add("tercermilenio");
		Ruta h4 = new Ruta("h4", listah4);
		rutas.add(h4);

		ArrayList<String> listaj72 = new ArrayList<>();
		listaj72.add("portalnorte");
		listaj72.add("toberin");
		listaj72.add("calle142");
		listaj72.add("prado");
		listaj72.add("calle100");
		listaj72.add("virrey");
		listaj72.add("heroes");
		listaj72.add("calle76");
		listaj72.add("calle72");
		listaj72.add("calle57");
		listaj72.add("av39");
		listaj72.add("universidades");
	}

	// Al arrancar el programa, se inicializa la ventana, las estaciones y las
	// rutas
	public static void main(String[] args) {
		inicializarGraficas();
		inicializarEstacionesYRutas();
	}

	// Carga un archivo de forma que las rutas, estaciones y troncales sean las
	// que estan en el archivo
	public static void cargar() {
		JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Archivos trans";
			}

			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(".trans");
			}
		});
		fc.showOpenDialog(ventana);
		File f = fc.getSelectedFile();
		if (f != null) {
			try {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(f));
				troncales = (ArrayList<Troncal>) stream.readObject();
				rutas = (ArrayList<Ruta>) stream.readObject();
				stream.close();
			} catch (Exception e) {
				aniadirTexto("El archivo no pudo ser cargado");
			}
		} else {
			// Nada
		}
		aniadirTexto("Carga exitosa");
	}

	// Guarda las actuales rutas, estaciones y troncales en un archivo
	public static void guardar() {
		String nombre = "";
		JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
		fc.showSaveDialog(ventana);
		File f = fc.getSelectedFile();
		if (f != null) {
			nombre = f.getAbsolutePath();
		}
		if (nombre.isEmpty()) {
			// Usuario cancelo
		} else {
			if (nombre.endsWith(".trans")) {
				// nada
			} else {
				nombre += ".trans";
			}
			try {
				f = new File(nombre);
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				try {
					oos.writeObject(troncales);
					oos.writeObject(rutas);
				} catch (IOException e) {
					e.printStackTrace();
					aniadirTexto("El archivo no pudo ser guardado exitosamente");
				}
				oos.close();
			} catch (Exception e) {
				aniadirTexto("El archivo no pudo ser guardado exitosamente");
			}
		}
	}

	// Recibe una troncal y muestra en orden todas la estaciones de la troncal,
	// si al recorrer
	// la lista de troncales no encuentra la troncal dada, escribe en pantalla
	// "Troncal invalida"
	public static void mostrarEstaciones(String troncal) {
		boolean troncalExiste = false;
		for (int i = 0; i < troncales.size(); i++) {
			if (troncales.get(i).obtenerNombre().equals(troncal)) {
				troncalExiste = true;
				troncales.get(i).mostrarEstaciones();
			}
		}
		if (!troncalExiste)
			aniadirTexto("Troncal invalida");
	}

	// Aniade a la ventana el string s
	public static void aniadirTexto(String s) {
		ventana.aniadirTexto(s);
	}

	// Recibe una troncal, una estacion y un indice donde se desea aniadir la
	// estacion,
	// busca en la lista de troncales la troncal dada y le dice que aniada la
	// estacion
	public static void aniadirEstacion(String troncal, String nombre, int indice) {
		for (int i = 0; i < troncales.size(); i++)
			if (troncales.get(i).obtenerNombre().equals(troncal))
				troncales.get(i).aniadirEstacion(nombre, indice);
	}

	// Recibe una troncal y una estacion que se desea remover,
	// busca en la lista de troncales la troncal dada y le dice que remueva la
	// estacion
	public static void removerEstacion(String troncal, String estacion) {
		for (int i = 0; i < troncales.size(); i++)
			if (troncales.get(i).obtenerNombre().equals(troncal))
				troncales.get(i).removerEstacion(estacion);
	}

	// Recibe una troncal y el indice de la estacion que se desea remover,
	// busca en la lista de troncales la troncal dada y le dice que remueva la
	// estacion
	public static void removerEstacion(String troncal, int indice) {
		for (int i = 0; i < troncales.size(); i++)
			if (troncales.get(i).obtenerNombre().equals(troncal))
				troncales.get(i).removerEstacion(indice);
	}

	// Alterna entre los roles de administrador y usuario
	public static void cambioRol() {
		ventana.cambioRol();
	}

	// Recibe una estacion y la busca en todas las troncales, al encontrarla en
	// una troncal, escribe en
	// pantalla en que troncal la encontro y cuales estaciones estan
	// antes/despues. Despues, busca la
	// estacion en todas las rutas, y dice en que rutas se encuentra y cual es
	// su numero. Si no encontro
	// la estacion en ninguna troncal ni ruta, entonces escribe que la estacion
	// no existe.
	public static void infoEstacion(String estacion) {
		boolean existe = false;
		for (int i = 0; i < troncales.size(); i++) {
			for (int j = 0; j < troncales.get(i).tamanio(); j++) {
				if (estacion.equals(troncales.get(i).obtenerEstacion(j))) {
					existe = true;
					if (j == 0)
						aniadirTexto("En la troncal " + troncales.get(i).obtenerNombre() + " la estacion " + estacion
								+ " es la primera estacion de la troncal");
					else
						aniadirTexto("En la troncal " + troncales.get(i).obtenerNombre() + " la estacion " + estacion
								+ " va despues de la estacion " + troncales.get(i).obtenerEstacion(j - 1));
					if (j == troncales.get(i).tamanio() - 1)
						aniadirTexto("En la troncal " + troncales.get(i).obtenerNombre() + " la estacion " + estacion
								+ " es la ultima estacion de la troncal");
					else
						aniadirTexto("En la troncal " + troncales.get(i).obtenerNombre() + " la estacion " + estacion
								+ " va antes de la estacion " + troncales.get(i).obtenerEstacion(j + 1));
				}
			}
		}

		for (int i = 0; i < rutas.size(); i++) {
			for (int j = 0; j < rutas.get(i).tamanio(); j++) {
				if (estacion.equals(rutas.get(i).obtenerParada(j))) {
					existe = true;
					aniadirTexto("La estacion " + estacion + " es la parada #" + j + " en la ruta "
							+ rutas.get(i).obtenerNombre());
				}
			}
		}

		if (!existe) {
			aniadirTexto("La estacion " + estacion + " no existe");
		}
	}

	// Recibe una lista de paradas y un nuevo nombre para una ruta, si alguna de
	// las paradas
	// no se encuentra en ninguna troncal entonces no crea la ruta. Si todas
	// existen, verifica
	// que el nombre de la ruta no este repetido antes de aniadir la ruta.
	public static void aniadirRuta(String nombre, ArrayList<String> paradas) {
		boolean paradasExisten = true;
		for (int k = 0; k < paradas.size(); k++) {
			boolean existe = false;
			for (int i = 0; i < troncales.size(); i++)
				for (int j = 0; j < troncales.get(i).tamanio(); j++)
					if (paradas.get(k).equals(troncales.get(i).obtenerEstacion(j)))
						existe = true;
			if (!existe)
				paradasExisten = false;
		}
		if (paradasExisten) {
			boolean nombreRepetido = false;
			for (int k = 0; k < rutas.size(); k++)
				if (rutas.get(k).obtenerNombre().equals(nombre))
					nombreRepetido = true;
			if (!nombreRepetido) {
				Ruta r = new Ruta(nombre, paradas);
				rutas.add(r);
			} else {
				aniadirTexto("Ya existe una ruta con el mismo nombre de la ruta que se intento crear");
			}
		} else
			aniadirTexto(
					"Una o mas de las paradas que suministro para la ruta no existen, agreguelas a una troncal antes de agregarlas a una ruta");
	}

	// Recibe el nombre de una ruta y la remueve de la lista de rutas de ser
	// posible, una vez hecho esto
	// se escribe en pantalla si la ruta pudo ser removida o si la ruta no
	// existe.
	public static void removerRuta(String nombre) {
		boolean removida = false;
		for (int i = 0; i < rutas.size(); i++)
			if (rutas.get(i).obtenerNombre().equals(nombre)) {
				rutas.remove(i);
				removida = true;
			}
		if (removida)
			aniadirTexto("La ruta " + nombre + " ha sido removida");
		else
			aniadirTexto("La ruta " + nombre + " no existe");
	}

	// Recibe el nombre de una ruta y el nombre de una estacion, y remueve la
	// estacion
	// dada de las paradas de la ruta
	public static void removerParada(String ruta, String parada) {
		for (int i = 0; i < rutas.size(); i++)
			if (rutas.get(i).obtenerNombre().equals(ruta))
				rutas.get(i).removerParada(parada);
	}

	// Recibe el nombre de una ruta y un indice, y remueve la estacion que se
	// encuentra
	// en ese indice de las paradas de la ruta
	public static void removerParada(String ruta, int indice) {
		for (int i = 0; i < rutas.size(); i++)
			if (rutas.get(i).obtenerNombre().equals(ruta))
				rutas.get(i).removerParada(indice);
	}

	// Recibe el nombre de una ruta y muestra en pantalla todas las paradas que
	// hace esa ruta, en orden.
	// Si la ruta no existe se muestra "Ruta invalida" en pantalla
	public static void mostrarParadas(String ruta) {
		boolean rutaExiste = false;
		System.out.println(rutas.size());
		for (int i = 0; i < rutas.size(); i++) {
			System.out.println(ruta + " " + rutas.get(i).obtenerNombre());
			if (rutas.get(i).obtenerNombre().equals(ruta)) {
				rutaExiste = true;
				rutas.get(i).mostrarParadas();
			}
		}
		if (!rutaExiste)
			aniadirTexto("Ruta invalida");
	}

	// Muestra todas las rutas en pantalla
	public static void mostrarRutas() {
		for (int i = 0; i < rutas.size(); i++)
			aniadirTexto(rutas.get(i).obtenerNombre() + " ");
	}

	// Recibe una ruta, el nombre de la nueva parada, una parada en la ruta para
	// usar como punto
	// de referencia y un booleano que determina si la nueva parada se coloca
	// antes o despues de la
	// parada de referencia. Busca en todas las rutas de la lista hasta
	// encontrar la ruta dada, y
	// llama el metodo apropiado de la ruta para aniadir la nueva parada.
	public static void aniadirParada(String ruta, String name, String parada, boolean b) {
		if (b == siguiente) {
			for (int i = 0; i < rutas.size(); i++)
				if (rutas.get(i).obtenerNombre().equals(ruta))
					rutas.get(i).aniadirSiguienteParada(name, parada);
		} else {
			for (int i = 0; i < rutas.size(); i++)
				if (rutas.get(i).obtenerNombre().equals(ruta))
					rutas.get(i).aniadirAnteriorParada(name, parada);
		}
	}

	// Recibe una ruta, una estacion y un indice donde se desea aniadir la
	// estacion como parada,
	// busca en la lista de rutas la ruta dada y le dice que aniada la parada
	public static void aniadirParada(String ruta, String nombre, int indice) {
		for (int i = 0; i < rutas.size(); i++)
			if (rutas.get(i).obtenerNombre().equals(ruta))
				rutas.get(i).aniadirParada(nombre, indice);
	}

	// Cierra el programa
	public static void salir() {
		System.exit(0);
	}

	// Muestra las rutas que van de una estacion de inicio a una estacion de
	// destino,
	// desde las que hacen menos paradas hasta las que hacen mas paradas.
	// Primero verifica
	// que ambas estaciones existan, si una de las dos no existe, se detiene y
	// escribe en pantalla
	// "Una o ambas de las estaciones dadas son invalidas". Si ambas son
	// validas, entonces en 2 arreglos
	// guarda la ruta y el numero de paradas que hace entre ambas estaciones,
	// mientras que la variable
	// distanciaMaxima tiene el maximo numero de paradas entre esas 2
	// estaciones. Finalmente, iniciando desde 0
	// hasta distanciaMaxima, se van mostrando todas las rutas que conectan
	// ambas estaciones parando ese numero de veces
	public static void planear(String inicio, String destino) {
		boolean inicioExiste = false;
		boolean destinoExiste = false;
		for (int i = 0; i < troncales.size(); i++)
			for (int j = 0; j < troncales.get(i).tamanio(); j++) {
				if (inicio.equals(troncales.get(i).obtenerEstacion(j)))
					inicioExiste = true;
				if (destino.equals(troncales.get(i).obtenerEstacion(j)))
					destinoExiste = true;
			}
		if (!inicioExiste || !destinoExiste)
			aniadirTexto("Una o ambas de las estaciones dadas son invalidas");
		else {
			ArrayList<Integer> rutasValidas = new ArrayList<>();
			ArrayList<Integer> numeroParadas = new ArrayList<>();
			int distanciaMaxima = -1;
			for (int i = 0; i < rutas.size(); i++) {
				int inicioIndice = -1;
				int destinoIndice = -1;
				for (int j = 0; j < rutas.get(i).tamanio(); j++) {
					if (rutas.get(i).obtenerParada(j).equals(inicio))
						inicioIndice = j;
					if (rutas.get(i).obtenerParada(j).equals(destino) && inicioIndice != -1)
						destinoIndice = j;
				}
				if (inicioIndice != -1 && destinoIndice != -1) {
					rutasValidas.add(i);
					numeroParadas.add(destinoIndice - inicioIndice);
					distanciaMaxima = Math.max(distanciaMaxima, destinoIndice - inicioIndice);
				}

			}
			for (int i = 0; i <= distanciaMaxima; i++) {
				for (int j = 0; j < rutasValidas.size(); j++) {
					if (numeroParadas.get(j) == i) {
						aniadirTexto("La ruta " + rutas.get(rutasValidas.get(j)).nombre + " requiere " + i
								+ " paradas para llegar desde " + inicio + " hasta " + destino);
					}
				}
			}
		}
	}

	private static Ventana ventana;
	private static ArrayList<Troncal> troncales;
	private static ArrayList<Ruta> rutas;

	public static final boolean siguiente = false;
	public static final boolean anterior = true;

}
