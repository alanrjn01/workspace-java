package default_package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MiLabel {

	public MiLabel() {
		//Jframe = una interfaz donde añadir componentes
				//JLabel = un area del display para el texto o imagen (etiquetas)
				//las labels por defecto toman todo el espacio que les sea posible
				
				ImageIcon image = new ImageIcon("clavo.png"); // creando una imagen
				
				Border border = BorderFactory.createLineBorder(Color.green,3); // creando un borde 
				
				JLabel label = new JLabel(); //al momento de crear la etiqueta podemos indicar en el constructor el texto
				label.setText("Hola, soy un texto feo"); //seteando un texto a la etiqueta
				label.setIcon(image); //agregando imagen a la etiqueta
				label.setHorizontalTextPosition(JLabel.CENTER); //settea el texto en la posición que querramos de la etiqueta
				label.setVerticalTextPosition(JLabel.TOP); //setea el texto en la posición que querramos de la etiqueta
				label.setForeground(Color.red); //cambiando el color del texto
				label.setFont(new Font("MV Boli",Font.PLAIN,20)); //le asignamos una fuente personalizada
				label.setIconTextGap(10); //modifica la distancia entre la imagen y el texto (gap)
				label.setBackground(Color.black); //modifica el color de fondo del background
				label.setOpaque(true); //activa el display del fondo de la etiqueta  
				label.setBorder(border); //agregandole el borde creado a la etiqueta
				label.setVerticalAlignment(JLabel.CENTER); //settea la posición vertical de los componentes en la etiqueta
				label.setHorizontalAlignment(JLabel.CENTER); //settea la posición vertical de los componentes en relación a la etiqueta
				//label.setBounds(0, 0, 255, 250); //si no tenemos un layout definido, con setbounds podemos manipular el margin y el tamaño de la etiqueta
				
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,500);
				//frame.setLayout(null); // modificando el layout modificamos la forma en como se acomodan las etiquetas
				frame.setVisible(true);
				frame.add(label); //agrega una etiqueta a nuestro frame
				frame.pack(); // hace que el frame se ajusta a el tamaño de nuestros componentes

	}
}
