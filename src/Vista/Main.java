package Vista;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Controlador.ViviendaController;
import Excepciones.CamposVaciosException;
import Excepciones.CodViviendaException;
import Excepciones.DormitoriosException;
import Interfaces.OrdenarPorFecha;
import Interfaces.OrdenarPorPrecio;
import Modelo.Vivienda;

public class Main {

	public Main() {
		// TODO Ap�ndice de constructor generado autom�ticamente
	}

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		//Instancio objeto
		String idVivienda,idUsuario,precio,numDormitorios,poblacion,fecha,alquilado;
		idVivienda="8411145678900";
		idUsuario="pepeTrebujena";
		precio="800.5";
		numDormitorios="4";
		poblacion="Jerez";
		fecha="2020-06-24";
		
		Vivienda vivienda=null;
		try {
			vivienda=new Vivienda(idVivienda, idUsuario, precio, numDormitorios, poblacion, fecha);
			//System.out.println(vivienda);
			
		} catch (CamposVaciosException | DormitoriosException | ParseException | CodViviendaException |NumberFormatException e) {
			// TODO Bloque catch generado autom�ticamente
			System.err.println(e.getMessage());
		}
		vivienda=null;
		
		//instancio controller
		ViviendaController inmobiliaria=null;
		try {
			inmobiliaria=new ViviendaController();
			List<Vivienda> listadoPisos=inmobiliaria.getListadoPisos();
			
			for (Vivienda vivienda2 : listadoPisos) {
				//System.out.println(vivienda2);
			}
			
			
			
		} catch (IOException | CamposVaciosException | ParseException | DormitoriosException | CodViviendaException e) {
			// TODO Bloque catch generado autom�ticamente
			System.err.println(e.getMessage());
		}
		
		//Menu
		Scanner leer=new Scanner (System.in);
		int opcion=0;
		
		do {
			System.out.println("1. Dar de alta a un nuevo piso");
			System.out.println("2. Mostrar todos los pisos. Ordenados por poblacion");
			System.out.println("3. Mostrar pisos de una poblacion que no esten alquilados. Ordenado por fecha");
			System.out.println("4. Alquilar un piso");
			System.out.println("5. Desalquilar un piso");
			System.out.println("6. Mostrar pisos de un usuario que no esten alquilados. Ordenados por precio");
			System.out.println("7. Salvar datos");
			System.out.println("8. Salir");
			opcion=leer.nextInt();
			switch (opcion) {
			case 1: //alta
				
				System.out.println("Por favor, ingrese los datos de la vivienda");
				idVivienda="8411145678900";
				idUsuario="piliJerez";
				precio="800";
				numDormitorios="4";
				poblacion="Jerez";
				fecha="2020-06-24";
				try {
					vivienda=new Vivienda(idVivienda, idUsuario, precio, numDormitorios, poblacion, fecha);
					vivienda=inmobiliaria.registrarVivienda(idVivienda, idUsuario, precio, numDormitorios, poblacion, fecha);
					if (vivienda != null) {
						System.out.println("ha agregado correctamente la vivienda");
					}
					else {
						System.err.println("Ha ocurrido un error al guardar la vivienda");
					}
					
					
				} catch (CamposVaciosException | DormitoriosException | ParseException | CodViviendaException e) {
					// TODO Bloque catch generado autom�ticamente
					System.err.println(e.getMessage());
				}
				
				
				break;
			case 2://mostrar pisos ordenados por poblacion
				
				List<Vivienda> listadoPisos;
				try {
					listadoPisos=inmobiliaria.mostrarViviendas();
					Collections.sort(listadoPisos);
					if (listadoPisos != null) {
						for (Vivienda vivienda2 : listadoPisos) {
							System.out.println(vivienda2);
						}
					}
					else {
						System.err.println("No hay vivendas en la inmobiliaria");
					}
				} catch (IOException | CamposVaciosException | ParseException | DormitoriosException |NullPointerException
						| CodViviendaException e) {
					// TODO Bloque catch generado autom�ticamente
					System.err.println(e.getMessage());
				}
				
				
				break;
					
			case 3://mostrar pisos de una poblacion que no esten alquilados
				
				System.out.println("Indica la poblacion por la que quieres filtrar los pisos");
				poblacion="Chipiona";
				List<Vivienda> listaPoblacion;
				listaPoblacion=inmobiliaria.mostrarViviendasPoblacion(poblacion);
				
				if (listaPoblacion != null) {
					for (Vivienda vivienda2 : listaPoblacion) {
							System.out.println(vivienda2);
					}
				}
				else {
						System.err.println("No hay vivendas en la inmobiliaria");
				}
	
				break;
				
			case 4://alquilar un piso
				System.out.println("Introduzca el idVivienda de la casa que quiere alquilar");
				idVivienda="8412345678912";
				try {
					if (inmobiliaria.alquilar(idVivienda)) {
						System.out.println("Piso alquilado");
						vivienda=inmobiliaria.buscarVivienda(idVivienda);
						System.out.println(vivienda);
					}
				} catch (CamposVaciosException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
				
			case 5://desalquilar un piso
				System.out.println("Introduzca el idVivienda de la casa que quiere desalquilar");
				idVivienda="8412345678929";
				try {
					if (inmobiliaria.desalquilar(idVivienda)) {
						System.out.println("Piso desalquilado");
						vivienda=inmobiliaria.buscarVivienda(idVivienda);
						System.out.println(vivienda);
					}
				} catch (CamposVaciosException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
				
			case 6://mostrar pisos de un usuario que no esten alquilados ordenados por precio
				System.out.println("Diga el usuario del que quiere mostrar pisos");
				idUsuario="pepeTrebujena";
				List<Vivienda> listaUsuario=null;
				listaUsuario=inmobiliaria.mostrarViviendasUsuario(idUsuario);
				Collections.sort(listaUsuario, new OrdenarPorPrecio());
				if (listaUsuario != null) {
					for (Vivienda vivienda2 : listaUsuario) {
						System.out.println(vivienda2);
					}
				}
				else {
					System.err.println("Este usuario no tiene ningu piso");
				}
				break;
				
			case 7://salvar datos
				System.out.println("vamos a guardar el fichero");
				try {
					inmobiliaria=new ViviendaController();
					Vivienda viviendaGuardar=null;
					if (inmobiliaria.salvar(viviendaGuardar)) {
						System.out.println("La copia se ha realizado correctamente");
					}
					else {
						System.err.println("Guardado fallido");
					}
					
				} catch (IOException | CamposVaciosException | ParseException | DormitoriosException
						| CodViviendaException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());;
				}
				
				break;
				
			case 8:
				System.out.println("Gracias por su visita");
				break;
			
			}
			
		} while (opcion!=8);
		 if (opcion<0 && opcion>8) {
			System.err.println("no es una opcion correcta");
		}
		

	}

}
