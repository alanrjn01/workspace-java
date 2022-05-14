package default_package;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiJPanel {

	public MiJPanel() {
		//JPanel = un componente que funciona como contenedor para alojar otros componentes
		
				JLabel label = new JLabel("Holandeses");
				
				ImageIcon icon= new ImageIcon("clavo.png");
				
				label.setIcon(icon);
				label.setVerticalAlignment(JLabel.BOTTOM);
				label.setHorizontalAlignment(JLabel.RIGHT);
				
				JPanel redPanel = new JPanel();
				redPanel.setBackground(Color.red);
				redPanel.setBounds(0,0,250,250);
				redPanel.setLayout(new BorderLayout());
				
				JPanel bluePanel = new JPanel();
				bluePanel.setBackground(Color.blue);
				bluePanel.setBounds(250,0,250,250);
				redPanel.setLayout(null);
				
				JPanel greenPanel = new JPanel();
				greenPanel.setBackground(Color.green);
				greenPanel.setBounds(0,250,500,250);
				greenPanel.setLayout(new BorderLayout()); 
				//añadiendo borderlayout podemos mover la posición de los componentes dentro del panel a partir del panel
				//si añadimos un layout null podemos modificar libremente la posición de los componentes dentro con un setBounds
				
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				frame.setSize(500,500);
				frame.setVisible(true);
				redPanel.add(label);
				frame.add(redPanel);
				frame.add(bluePanel);
				frame.add(greenPanel);
	}
}
