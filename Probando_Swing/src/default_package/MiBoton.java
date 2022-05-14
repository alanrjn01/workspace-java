package default_package;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MiBoton {

	JButton button;
	JLabel label;
	
	public MiBoton() {
		
		//para que funcionen los botones hace falta añadirlos a un frame
		
		ImageIcon icon = new ImageIcon("clavo.png");
		label = new JLabel();
		label.setIcon(icon);
		label.setBounds(150,150,150,150);
		label.setVisible(false);
		
		button = new JButton();
		
		button.setBounds(200,100,200,100);
		button.addActionListener(e -> {
			System.out.println("poo");
			button.setEnabled(false);
			label.setVisible(true);
		}); //usando lambda expresions para ActionListener
		button.setText("Apretar botón");
		button.setFocusable(false);
		button.setBorder(BorderFactory.createDashedBorder(null));
		
		
		
	}

}
