/*
 * Una lista de Automoviles, que muestre las imágenes de cada Automovil con su nombre y su tipo.
 * Obtienes un array (ese array tiene que ser de objetos tipo Automoviles, que va a ser una
 * clase abstracta de la que se genera cada Automovil), ese array hay que iterarlo con ciclos. 
 * Se debe generar un filtrados, como un buscador de nombre o de tipos. Al darle clic a cada uno,
 * te muestre más información del Automovil.
 */


package proyectoFinal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Automovil> autos = new ArrayList<>();
		autos.add(new TipoSport("Urban 4", 1398000));
		autos.add(new TipoSport("Urban 2", 1390000));
		autos.add(new TipoDefender("Defender X Ingenium 3", 2822158));
		autos.add(new TipoDefender("LAND ROVER Defender 2023", 2849150));
		
		boolean salir = false; 
		while (!salir) {
			System.out.println("****  MENU  ****");
			System.out.println("1. Mostrar todo el inventario");
			System.out.println("2. Mostrar por tipo de auto");
			System.out.println("3. Salir");
			 
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu opcion: "));
			switch(opcion) {			 		 
				 case 1:
					 mostrarTodos(autos);
					 break;
				 case 2:
					 mostrarTipo(autos);
					 break;
				 case 3:
					 salir = true;
					 break;
				default:
					System.out.println("Ingrese una opcion valida: ");
			 }	 
		 }
	}
	
	
	
	private static void mostrarTodos(ArrayList<Automovil> autos) {
        System.out.println("**** Lista Total de Automóviles ****");
        for (Automovil rangerover : autos) {
            System.out.println("Nombre: " + rangerover.getNombre());
            System.out.println("Tipo: " + rangerover.getTipo());
            System.out.println("Tipo: " + rangerover.getPrecio());
            System.out.println("Tipo: " + rangerover.descripcion());
            System.out.println();
        }
    }
	
	private static void mostrarTipo(ArrayList<Automovil> autos) {
		
		System.out.print("Digite el tipo de auto (Defender / Sport): ");
        Scanner teclado = new Scanner(System.in);
        String tipo = teclado.nextLine();
        System.out.println(" **** Automóviles Tipo " + tipo +" **** ");
		
        for (Automovil rangerover : autos) {
        	if (rangerover.getTipo().equalsIgnoreCase(tipo)) {
	            System.out.println("Nombre: " + rangerover.getNombre());
	            System.out.println("Tipo: " + rangerover.getPrecio());
	            System.out.println("Tipo: " + rangerover.descripcion());
	            System.out.println();
	    teclado.close();
        	}
        }
    }
}
