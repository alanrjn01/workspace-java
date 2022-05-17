package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import precios_irrisorios.LectorCsv;
import precios_irrisorios.Programa;

public class Ventana extends JFrame{
	Programa p1 = new Programa();
	LectorCsv lector1= new LectorCsv();
	JFileChooser fc = new JFileChooser();

	public Ventana() {
		this.setTitle("Precios irrisorios");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400,500);
		this.setVisible(true);
		this.setLayout(null);
		this.cargarArchivoBloque();
	}
	
	public void cargarArchivoBloque() {
		JButton botonCargarArchivo = new JButton("Cargar archivo");
		botonCargarArchivo.addActionListener(e ->{
			 //crear objeto filechooser
			int seleccion = fc.showOpenDialog(this); // guardo la seleccion del usuario
			//si la seleccion es igual a approve option entonces:
			if (seleccion == JFileChooser.APPROVE_OPTION) {
					lector1.leerArchivo(fc.getSelectedFile().getName().toString()); //cargo la ruta del archivo seleccionado parseado a string
					JLabel textoArchivoCargado = new JLabel(); //creo una label para mostrar el nombre del archivo
					textoArchivoCargado.setBounds(0, 0, 200, 100);
					this.add(textoArchivoCargado);
					textoArchivoCargado.setText(fc.getName(fc.getSelectedFile())); //setteo el nombre del archivo seleccionado en la etiqueta
					p1.setListaProductos(lector1.getArrayProductos());
			}
			
		});
		this.add(botonCargarArchivo);
		botonCargarArchivo.setBounds(0,0,150,30);
		JButton boton1 = new JButton("ordenar productos ascendentemente");
		JButton boton2 = new JButton("producto con precio más bajo");
		JButton boton3 = new JButton("producto precio más alto c/promo y s/promo");
		JButton boton4 = new JButton("productos en comercion con mejor precio");
		JButton boton5 = new JButton("precio promedio para cada producto");
		JButton boton6 = new JButton("cantidad de productos por comercio");
		boton1.setBounds(45, 60, 290, 30);
		boton1.addActionListener(e->{
			try {
				lector1.escribirArchivoArrayList(p1.productosOrdenadosAscendentemente(), fc.getSelectedFile().getParent().toString());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		boton2.setBounds(45, 90, 290, 30);
		boton3.setBounds(45, 120, 290, 30);
		boton4.setBounds(45, 150, 290, 30);
		boton5.setBounds(45, 180, 290, 30);
		boton6.setBounds(45, 210, 290, 30);
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(boton5);
		this.add(boton6);
		
		
	}

}
