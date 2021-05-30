package controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Ruta implements Serializable {

	private static final long serialVersionUID = 1L;

	// Constructor de la clase
	public Ruta(String nombre, ArrayList<String> paradas) {
		this.nombre = nombre;
		this.paradas = paradas;
	}

	// Recibe una nueva parada y la parada anterior a esta, si la anterior
	// existe,
	// agrega la nueva parada entre la parada pasada y la siguiente a esta
	public void aniadirSiguienteParada(String parada, String pasada) {
		boolean pasadaExiste = false;
		boolean repetida = false;
		int indice = -1;
		for (int i = 0; i < paradas.size(); i++) {
			if (paradas.get(i).equals(pasada)) {
				pasadaExiste = true;
				indice = i;
			}
			if (paradas.get(i).equals(parada))
				repetida = true;
		}
		if (repetida)
			Main.aniadirTexto("La parada que queria agregar ya esta en la ruta, por lo que no se ha aniadido");
		else {
			if (pasadaExiste) {
				paradas.add(indice + 1, parada);
			} else
				Main.aniadirTexto("Parada de referencia invalida");
		}
	}

	// Recibe una parada y un indice, si la parada ya existia, se mueve a ese
	// nuevo indice, si la
	// parada no existia, se agrega en ese indice
	public void aniadirParada(String parada, int indice) {
		if (indice >= 0 && indice < paradas.size()) {
			paradas.remove(parada);
			paradas.add(indice, parada);
		} else {
			Main.aniadirTexto("Indice invalido, la parada no se ha aniadido");
		}
	}

	// Recibe una nueva parada y la estacion parada a esta, si la siguiente
	// existe,
	// agrega la nueva parada entre la parada siguiente y la anterior a esta
	public void aniadirAnteriorParada(String parada, String siguiente) {
		boolean siguienteExiste = false;
		boolean repetida = false;
		int indice = -1;
		for (int i = 0; i < paradas.size(); i++) {
			if (paradas.get(i).equals(siguiente)) {
				siguienteExiste = true;
				indice = i;
			}
			if (paradas.get(i).equals(parada))
				repetida = true;
		}
		if (repetida)
			Main.aniadirTexto("La parada que queria agregar ya esta en la ruta, por lo que no se ha aniadido");
		else {
			if (siguienteExiste) {
				paradas.add(indice, parada);
			} else
				Main.aniadirTexto("Parada de referencia invalida");
		}
	}

	// Recibe el nombre de una parada, si se encuentra en esta ruta, la remueve
	public void removerParada(String parada) {
		int indice = 0;
		boolean existe = false;
		for (int i = 0; i < paradas.size(); i++)
			if (paradas.get(i).equals(parada)) {
				existe = true;
				indice = i;
			}
		paradas.remove(indice);
		if (existe) {
			Main.aniadirTexto("La parada " + parada + " ha sido removida exitosamente de la ruta " + nombre);
		} else
			Main.aniadirTexto("La parada que queria remover no se encuentra en la ruta");
	}

	// Recibe un indice, si es un indice valido, remueve la parada en ese indice
	// de la ruta
	public void removerParada(int indice) {
		if (indice >= 0 && indice < paradas.size()) {
			paradas.remove(indice);
		} else {
			Main.aniadirTexto("Indice invalido, la parada no se ha removido");
		}
	}

	// Retorna el nombre de esta ruta
	public String obtenerNombre() {
		return nombre;
	}

	// Recibe un indice, si hay una parada en ese indice, retorna el nombre de
	// la parada
	public String obtenerParada(int indice) {
		if (indice >= 0 && indice < paradas.size())
			return paradas.get(indice);
		else {
			Main.aniadirTexto("Indice invalido");
			return null;
		}
	}

	// Muestra todas las paradas por las que pasa esta ruta en la pantalla
	public void mostrarParadas() {
		String s = "La ruta " + nombre + " tiene las siguientes paradas:";
		s = s.toUpperCase();
		for (int i = 0; i < paradas.size(); i++) {
			if (i != 0)
				s += " \n ";
			s += paradas.get(i);
		}
		Main.aniadirTexto(s);
	}

	// Retorna el numero de paradas en las que para la ruta
	public int tamanio() {
		return paradas.size();
	}

	ArrayList<String> paradas;
	String nombre;
}
