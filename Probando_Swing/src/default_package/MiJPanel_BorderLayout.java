package default_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiJPanel_BorderLayout {

	public MiJPanel_BorderLayout() {
		//BORDERLAYOUT: Borderlayout coloca los componentes en 5 areas: norte,sur,este,oeste y centro
		
				JFrame f1 = new JFrame();
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Indica que hacer al momento de utilizar la "X" para cerrar
				f1.setSize(500,500); // settear el tamaño del this (x e y)
				f1.setVisible(true); // hacer que el frame sea visible
				
				
				f1.setLayout(new BorderLayout(10,10)); //setteando borderlayout al layout del frame (podemos indicar en el constructor margenes en eje x e y
				
				
				//Creando 5 paneles
				JPanel p1= new JPanel();
				JPanel p2= new JPanel();
				JPanel p3= new JPanel();
				JPanel p4= new JPanel();
				JPanel p5= new JPanel();
				
				//colocando colores a los paneles
				p1.setBackground(Color.red);
				p2.setBackground(Color.green);
				p3.setBackground(Color.yellow);
				p4.setBackground(Color.magenta);
				p5.setBackground(Color.blue);
				
				//agregando tamaño a los paneles
				p1.setPreferredSize(new Dimension(20,100));
				p2.setPreferredSize(new Dimension(100,100));
				p3.setPreferredSize(new Dimension(100,100));
				p4.setPreferredSize(new Dimension(100,100));
				p5.setPreferredSize(new Dimension(100,100));
				
				//agregando los panales al frame colocando su posición en el layout
				
				//al estar posicionado en el norte se expande con el frame en el eje X y ocupa todo su espacio disponible
				f1.add(p1,BorderLayout.NORTH);
				
				//al estar posicionado en el oeste se expande con el frame en el eje Y y ocupa todo su espacio disponible
				f1.add(p2,BorderLayout.WEST);
				
				f1.add(p3,BorderLayout.EAST);
				f1.add(p4,BorderLayout.SOUTH);
				f1.add(p5,BorderLayout.CENTER);
				
	}

}
