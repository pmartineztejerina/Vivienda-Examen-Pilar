package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Excepciones.CamposVaciosException;
import Excepciones.CodViviendaException;
import Excepciones.DormitoriosException;
import Interfaces.OrdenarPorFecha;
import Modelo.Vivienda;

public class ViviendaController {
	List<Vivienda> listadoPisos;
	public ViviendaController() throws IOException, CamposVaciosException, ParseException, DormitoriosException, CodViviendaException {
		// TODO Ap�ndice de constructor generado autom�ticamente
		listadoPisos=new ArrayList<Vivienda>();
		File file=new File("inmobiliaria.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileReader fr=new FileReader("inmobiliaria.txt");
		BufferedReader br=new BufferedReader(fr);
		String linea="";
		String [] datosInmobiliaria=null;
		String idVivienda, idUsuario, precio, numDormitorios,poblacion, fecha, alquilado;
		Vivienda vivienda;
		while ((linea=br.readLine())!=null) {
			datosInmobiliaria=linea.split(",");
			idVivienda=datosInmobiliaria[0];
			idUsuario=datosInmobiliaria[1];
			precio=datosInmobiliaria[2];
			numDormitorios=datosInmobiliaria[3];
			poblacion=datosInmobiliaria[4];
			fecha=datosInmobiliaria[5];
			alquilado=datosInmobiliaria[6];
			vivienda=new Vivienda(idVivienda, idUsuario, precio, numDormitorios, poblacion, fecha, alquilado);
			listadoPisos.add(vivienda);
			
		}
		vivienda=null;
		fr.close();
		br.close();
		fr=null;
		br=null;
	}
	public List<Vivienda> getListadoPisos() {
		return listadoPisos;
	}
	public void setListadoPisos(List<Vivienda> listadoPisos) {
		this.listadoPisos = listadoPisos;
	}
	public Vivienda registrarVivienda(String idVivienda, String idUsuario, String precio, String numDormitorios,
			String poblacion, String fecha) throws CamposVaciosException, DormitoriosException, ParseException, CodViviendaException {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		Vivienda vivienda=new Vivienda(idVivienda, idUsuario, precio, numDormitorios, poblacion, fecha);
		
		if (!listadoPisos.contains(vivienda)) {
			listadoPisos.add(vivienda);
		}
		else {
			vivienda=null;
		}
		
		return vivienda;
	}
	public List<Vivienda> mostrarViviendas() throws IOException, CamposVaciosException, ParseException, DormitoriosException, CodViviendaException, NullPointerException {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		
		
		List<Vivienda> lista=null;;
		
		for (Vivienda vivienda : this.listadoPisos) {
			lista=getListadoPisos();
		}
		
		return lista;
	}
	public List<Vivienda> mostrarViviendasPoblacion(String poblacion) {
		// TODO Auto-generated method stub
		List<Vivienda> lista=new ArrayList();
		Collections.sort(lista, new OrdenarPorFecha());
		for (Vivienda vivienda : this.listadoPisos) {
			if ((vivienda.getPoblacion().equals(poblacion))&&(vivienda.isAlquilado()==false)) {
				lista.add(vivienda);
			}
		}
		if (lista.size()==0) {
			lista=null;
		}
		return lista;
	}
	public Vivienda buscarVivienda(String idVivienda) {
		// TODO Auto-generated method stub
		
		Vivienda vivienda=null;
		for (Vivienda viv : listadoPisos) {
			if (viv.getIdVivienda().equals(idVivienda)) {
				vivienda=viv;
				break;
			}
		}
		return vivienda;
	}
	public boolean alquilar(String idVivienda) throws CamposVaciosException {
		// TODO Auto-generated method stub
		boolean alquilado=false;
		Vivienda vivienda=null;
		vivienda=buscarVivienda(idVivienda);
		String alquilado2="true";
		if (vivienda != null) {
			vivienda.setAlquilado(alquilado2);
			alquilado=true;
		}
		
		return alquilado;
	}
	public boolean desalquilar(String idVivienda) throws CamposVaciosException {
		// TODO Auto-generated method stub
		boolean alquilado=false;
		Vivienda vivienda=null;
		String alquilado2="false";
		vivienda=buscarVivienda(idVivienda);
		if (vivienda != null) {
			vivienda.setAlquilado(alquilado2);
			alquilado=true;
		}
		
		return alquilado;
	}
	
	public List<Vivienda> mostrarViviendasUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		List<Vivienda> lista=new ArrayList<Vivienda>();
		for (Vivienda vivienda : this.listadoPisos) {
			if ((vivienda.getIdUsuario().equals(idUsuario))&&(vivienda.isAlquilado()==false)) {
				lista.add(vivienda);
			}
		}
		if (lista.size()==0) {
			lista=null;
		}
		
		return lista;
	}
	
	public boolean salvar(Vivienda viviendaGuardar) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw=new FileWriter("inmobiliaria2.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		String linea="";
		for (Vivienda vivienda : listadoPisos) {
			linea=vivienda.toString();
			bw.write(linea);
			bw.newLine();
		}
		fw.flush();
		bw.close();
		fw.close();
		bw=null;
		fw=null;
		
		
		return true;
	}

	

}
