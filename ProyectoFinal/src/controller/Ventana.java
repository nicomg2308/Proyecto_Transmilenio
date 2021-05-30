package controller;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	// Acomoda la ventana, creando 2 menus(Uno para el rol de ususario y otro
	// para el rol
	// de administrador) y un panel donde se escribira.
	public Ventana() {
		this.getContentPane().setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();

		menuUsuario = new MenuUsuario();
		menuAdmin = new MenuAdministrador();

		// Ubicacion menu de usuario
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.0;
		constraints.weighty = 0.05;
		this.getContentPane().add(menuUsuario, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;

		// Ubicacion menu de administrador
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.0;
		constraints.weighty = 0.05;
		this.getContentPane().add(menuAdmin, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;

		// Ubicacion Panel
		panelContenido = new PanelContenido();
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 2.2;
		constraints.weighty = 1.0;
		this.getContentPane().add(panelContenido, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;

		// Quita el menu de admin para que solo quede el de usuario
		this.getContentPane().remove(menuAdmin);
		rolUsuario = true;
	}

	// Aniade el texto dado al panel donde se muestra el texto
	public void aniadirTexto(String s) {
		panelContenido.addNewLine(s);
	}

	private MenuUsuario menuUsuario;
	private MenuAdministrador menuAdmin;
	private PanelContenido panelContenido;
	private boolean rolUsuario;

	private JScrollPane scrollPanel;
	private JScrollPane scrollConsola;
	private GridBagConstraints constraints;

	// Si el rol actual es usuario, el rol actual se vuelve administrador, se
	// oculta el menu
	// del usuario y aparece el menu del administrador, y visceversa
	public void cambioRol() {
		if (rolUsuario) {
			this.getContentPane().remove(menuUsuario);

			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 3;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.BOTH;
			constraints.weightx = 0.0;
			constraints.weighty = 0.05;
			this.getContentPane().add(menuAdmin, constraints);
			constraints.weightx = 0.0;
			constraints.weighty = 0.0;
			constraints.fill = GridBagConstraints.NONE;
			this.setBounds(0, 0, getWidth(), getHeight() + 1);
			repaint();
			getContentPane().repaint();
			this.setTitle("Proyecto 6 - Transmilenio(Modo administrador)");
			rolUsuario = false;
		} else {
			this.remove(menuAdmin);

			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 3;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.BOTH;
			constraints.weightx = 0.0;
			constraints.weighty = 0.05;
			this.getContentPane().add(menuUsuario, constraints);
			constraints.weightx = 0.0;
			constraints.weighty = 0.0;
			constraints.fill = GridBagConstraints.NONE;
			this.setBounds(0, 0, getWidth(), getHeight() + 1);
			repaint();
			getContentPane().repaint();
			this.setTitle("Proyecto 6 - Transmilenio(Modo usuario)");
			rolUsuario = true;
		}
	}

}
