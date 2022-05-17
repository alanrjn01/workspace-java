package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import precios_irrisorios.LectorCsv;
import precios_irrisorios.Programa;

public class Ventana extends JFrame{
	
	//propiedades que voy a utilizar como parte de la ventana
	Programa p1 = new Programa(); //instancia de programa para ejecutar los métodos de la lógica
	LectorCsv lector1= new LectorCsv(); //instancia del lector de archivos para crear y leer los mismos
	JFileChooser fc = new JFileChooser(); //instancia de JFileChooser (ventana para seleccionar carpetas)
	JOptionPane op = new JOptionPane(); //instancia de JOptionPane (ventana con cuadros de diálogos)

	//defino los parámetros de la ventana (JFrame)
	public Ventana() {
		this.setTitle("Precios irrisorios");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400,350);
		this.setVisible(true);
		this.setLayout(null);
		this.cargarArchivoBloque();
	}
	
	//este método se encarga de cargar todo el panel de botones y la etiqueta con el nombre del archivo cargado
	public void cargarArchivoBloque() {
		
		//creo los botones y les agrego sus dimensiones y posición. Por defecto están inhabilitados a excepción del botón de carga de archivos
		JButton botonCargarArchivo = new JButton("Cargar archivo");
		JButton boton1 = new JButton("ordenar productos ascendentemente");
		JButton boton2 = new JButton("producto con precio más bajo");
		JButton boton3 = new JButton("producto precio más alto c/promo y s/promo");
		JButton boton4 = new JButton("productos en comercion con mejor precio");
		JButton boton5 = new JButton("precio promedio para cada producto");
		JButton boton6 = new JButton("cantidad de productos por comercio");
		botonCargarArchivo.setBounds(0,0,150,30);
		boton1.setBounds(45, 60, 290, 30);
		boton2.setBounds(45, 90, 290, 30);
		boton3.setBounds(45, 120, 290, 30);
		boton4.setBounds(45, 150, 290, 30);
		boton5.setBounds(45, 180, 290, 30);
		boton6.setBounds(45, 210, 290, 30);
		boton1.setEnabled(false);
		boton2.setEnabled(false);
		boton3.setEnabled(false);
		boton4.setEnabled(false);
		boton5.setEnabled(false);
		boton6.setEnabled(false);
		
		//metodo addActionListener para indicar que hace el botón al clickearlo
		botonCargarArchivo.addActionListener(e ->{
			 //crear objeto filechooser
			int seleccion = fc.showOpenDialog(this); // guardo la seleccion del usuario
			//si la seleccion es igual a approve option (seleccionó un archivo) entonces:
			if (seleccion == JFileChooser.APPROVE_OPTION) {
					//se habilitan los botones:
					boton1.setEnabled(true);
					boton2.setEnabled(true);
					boton3.setEnabled(true);
					boton4.setEnabled(true);
					boton5.setEnabled(true);
					boton6.setEnabled(true);
					lector1.leerArchivo(fc.getSelectedFile().getName().toString()); //cargo la ruta del archivo seleccionado y realizo la lectura 
					JLabel textoArchivoCargado = new JLabel(); //creo una label para mostrar el nombre del archivo
					textoArchivoCargado.setBounds(0, 0, 200, 100);
					this.add(textoArchivoCargado); //agrego el texto que indica el nombre del archivo
					textoArchivoCargado.setText(fc.getName(fc.getSelectedFile())); //setteo el nombre del archivo seleccionado en la etiqueta
					p1.setListaProductos(lector1.getArrayProductos()); //seteo el array de productos con los datos leídos anteriormente
			}
		});
		
		//funcionalidad de los botones:
		boton1.addActionListener(e->{
			try {
				lector1.escribirArchivoArrayList(p1.productosOrdenadosAscendentemente(), fc.getSelectedFile().getParent().toString());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			op.showMessageDialog(null,"Archivo creado correctamente");
		});
		boton2.addActionListener(e->{
			try {
				String producto = op.showInputDialog("Ingrese el nombre de producto:");
				p1.productosOrdenadosAscendentemente();
				lector1.escribirArchivoArrayList(p1.productoPrecioMasBajo(producto), fc.getSelectedFile().getParent().toString());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			op.showMessageDialog(null,"Archivo creado correctamente");
		});
		boton3.addActionListener(e->{
			try {
				String producto = op.showInputDialog("Ingrese el nombre de producto:");
				p1.productosOrdenadosAscendentemente();
				lector1.escribirArchivoArrayList(p1.productoPrecioMasAltoConPromocionYSinPromocion(producto), fc.getSelectedFile().getParent().toString());
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}
			op.showMessageDialog(null,"Archivo creado correctamente");
		});
		boton4.addActionListener(e->{
			try {
				String nombreComercio = op.showInputDialog("Ingrese el nombre de comercio:");
				p1.productosOrdenadosAscendentemente();
				lector1.escribirArchivoArrayList(p1.productosEnComerciosConMejorPrecio(nombreComercio), fc.getSelectedFile().getParent().toString());
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}
			op.showMessageDialog(null,"Archivo creado correctamente");
		});
		boton5.addActionListener(e->{
			try {
				p1.productosOrdenadosAscendentemente();
				lector1.escribirArchivoLinkedHashMap(p1.precioPromedioParaCadaProducto(), fc.getSelectedFile().getParent().toString());
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}
			op.showMessageDialog(null,"Archivo creado correctamente");
		});
		boton6.addActionListener(e->{
			try {
				String nombreComercio = op.showInputDialog("Ingrese el nombre de comercio:");
				p1.productosOrdenadosAscendentemente();
				lector1.escribirArchivoEntero(nombreComercio,p1.devolverCantidadDeProductosDeUnComercio(nombreComercio), fc.getSelectedFile().getParent().toString());
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}
			op.showMessageDialog(null,"Archivo creado correctamente");
		});
		//agrego los botones a la ventana
		this.add(botonCargarArchivo);
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(boton5);
		this.add(boton6);
		
		
	}

}
