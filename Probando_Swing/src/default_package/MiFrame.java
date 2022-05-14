package default_package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiFrame extends JFrame{

	

	public MiFrame() {
		
				
				this.setTitle("Prueba de Jthis"); // titulo de la ventana
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Indica que hacer al momento de utilizar la "X" para cerrar
				this.setResizable(false); // hacer que el frame no sea redimensionado
				this.setSize(500,500); // settear el tamaño del this (x e y)
				this.setVisible(true); // hacer que el frame sea visible
				ImageIcon image = new ImageIcon("clavo.png"); //crea un icono a partir de una imagen
				this.setIconImage(image.getImage()); //cambia el icono del this por nuestra imagen
				this.getContentPane().setBackground(Color.gray); //cambia el color del background del frame
				this.getContentPane().setBackground(new Color(255,34,253)); //Creamos un color personalizado para el fondo (rgb, hex, etc)
			}
}
