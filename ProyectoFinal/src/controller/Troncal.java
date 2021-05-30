package controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Troncal implements Serializable {

	private static final long serialVersionUID = 1L;

	// Constructor de la clase
	public Troncal(String nombre, ArrayList<String> estaciones) {
		this.estaciones = estaciones;
		this.nombre = nombre;
	}

	// Recibe una nueva estacion y la estacion anterior a esta, si la anterior
	// existe,
	// agrega la nueva estacion entre la estacion pasada y la siguiente a esta
	public void aniadirSiguienteEstacion(String estacion, String pasada) {
		boolean pasadaExiste = false;
		boolean repetida = false;
		int indice = -1;
		for (int i = 0; i < estaciones.size(); i++) {
			if (estaciones.get(i).equals(pasada)) {
				pasadaExiste = true;
				indice = i;
			}
			if (estaciones.get(i).equals(estacion))
				repetida = true;
		}
		if (repetida)
			Main.aniadirTexto("La estacion que queria agregar ya esta en la troncal, por lo que no se ha aniadido");
		else {
			if (pasadaExiste) {
				estaciones.add(indice + 1, estacion);
			} else
				Main.aniadirTexto("Estacion de referencia invalida");
		}
	}

	// Recibe una estacion y un indice, si la estacion ya existia, se mueve a
	// ese nuevo indice, si la
	// estacion no existia, se agrega en ese indice
	public void aniadirEstacion(String estacion, int indice) {
		if (indice >= 0 && indice < estaciones.size()) {
			estaciones.remove(estacion);
			estaciones.add(indice, estacion);
		} else {
			Main.aniadirTexto("Indice invalido, la estacion no se ha aniadido");
		}
	}

	// Recibe una nueva estacion y la estacion siguiente a esta, si la siguiente
	// existe,
	// agrega la nueva estacion entre la estacion siguiente y la anterior a esta
	public void aniadirAnteriorEstacion(String estacion, String siguiente) {
		boolean siguienteExiste = false;
		boolean repetida = false;
		int indice = -1;
		for (int i = 0; i < estaciones.size(); i++) {
			if (estaciones.get(i).equals(siguiente)) {
				siguienteExiste = true;
				indice = i;
			}
			if (estaciones.get(i).equals(estacion))
				repetida = true;
		}
		if (repetida)
			Main.aniadirTexto("La estacion que queria agregar ya esta en la troncal, por lo que no se ha aniadido");
		else {
			if (siguienteExiste) {
				estaciones.add(indice, estacion);
			} else
				Main.aniadirTexto("Estacion de referencia invalida");
		}
	}

	// Recibe el nombre de una estacion, si la estacion se encuentra en la
	// troncal, la remueve
	public void removerEstacion(String e) {
		int indice = 0;
		boolean existe = false;
		for (int i = 0; i < estaciones.size(); i++)
			if (estaciones.get(i).equals(e)) {
				existe = true;
				indice = i;
			}
		System.out.println(estaciones);
		estaciones.remove(indice);
		System.out.println(estaciones);
		if (existe) {
			Main.aniadirTexto("La estacion " + e + " ha sido removida exitosamente de la troncal " + nombre);
		} else
			Main.aniadirTexto("La estacion que queria remover no se encuentra en la troncal");
	}

	// Recibe un indice, si es un indice valido, remueve la estacion en ese
	// indice de la troncal
	public void removerEstacion(int indice) {
		if (indice >= 0 && indice < estaciones.size()) {
			estaciones.remove(indice);
		} else {
			Main.aniadirTexto("Indice invalido, la estacion no se ha removido");
		}
	}

	// Retorna el nombre de esta troncal
	public String obtenerNombre() {
		return nombre;
	}

	// Recibe un indice, si hay una estacion en ese indice, retorna el nombre de
	// la estacion
	public String obtenerEstacion(int indice) {
		if (indice >= 0 && indice < estaciones.size())
			return estaciones.get(indice);
		else {
			Main.aniadirTexto("Indice invalido");
			return "";
		}
	}

	// Muestra todas las estaciones que se encuentran en esta troncal en la
	// pantalla
	public void mostrarEstaciones() {
		String s = "";
		for (int i = 0; i < estaciones.size(); i++) {
			if (i != 0)
				s += " \n ";
			s += estaciones.get(i);
		}
		Main.aniadirTexto(s);
	}

	// Retorna el numero de estaciones que posee esta troncal
	public int tamanio() {
		return estaciones.size();
	}

	private ArrayList<String> estaciones;
	private String nombre;
}
