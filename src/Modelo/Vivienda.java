package Modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Excepciones.CamposVaciosException;
import Excepciones.CodViviendaException;
import Excepciones.DormitoriosException;

public class Vivienda implements Comparable<Vivienda>{
	
	private String idVivienda;
	private String idUsuario;
	private double precio;
	private int numDormitorios;
	private String poblacion;
	private java.sql.Date fecha;
	private boolean alquilado;
	
	public Vivienda() {
		// TODO Ap�ndice de constructor generado autom�ticamente
		this.idVivienda=null;
		this.idUsuario=null;
		this.precio=0;
		this.numDormitorios=0;
		this.poblacion=null;
		this.fecha=null;
		this.alquilado=false;
	}

	public Vivienda(String idVivienda, String idUsuario, String precio, String numDormitorios, String poblacion,
			String fecha) throws CamposVaciosException, DormitoriosException, ParseException, CodViviendaException {
		super();
		this.setIdVivienda(idVivienda);
		this.setIdUsuario(idUsuario);
		this.setPrecio(precio);
		this.setNumDormitorios(numDormitorios);
		this.setPoblacion(poblacion);
		this.setFecha(fecha);
		this.alquilado=false;
	}
	

	public Vivienda(String idVivienda, String idUsuario, String precio, String numDormitorios, String poblacion,
			String fecha, String alquilado) throws CamposVaciosException, ParseException, DormitoriosException, CodViviendaException {
		super();
		this.setIdVivienda(idVivienda);
		this.setIdUsuario(idUsuario);
		this.setPrecio(precio);
		this.setNumDormitorios(numDormitorios);
		this.setPoblacion(poblacion);
		this.setFecha(fecha);
		this.setAlquilado(alquilado);
	}

	public String getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(String idVivienda) throws CamposVaciosException, CodViviendaException {
		if (idVivienda.equals("")) {
			throw new CamposVaciosException("idVivienda");
		}
		String numCodigBarras=idVivienda.substring(0, 12);
		String digito=idVivienda.substring(12);
		boolean impar=true;
		int sumImpares=0;
		int sumPares=0;
		for (int x = 0; x < numCodigBarras.length(); x++) {
			if (impar) {
				sumImpares+=Integer.parseInt(Character.toString(numCodigBarras.charAt(x)));
				impar=!impar;
			}
			else {
				sumPares+=Integer.parseInt(Character.toString(numCodigBarras.charAt(x)))*3;
				impar=!impar;
			}
		}
		int suma=sumImpares+sumPares;
		int dig=10-(suma%10);
		if (dig==10) {
			dig=0;
		}
		String digit=String.valueOf(dig);
		if (digito.equals(digit)) {
			this.idVivienda = idVivienda;
		}
		else {
			throw new CodViviendaException();
		}
		
		
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) throws CamposVaciosException {
		if (idUsuario.equals("")) {
			throw new CamposVaciosException("idUsuario");
		}
		this.idUsuario = idUsuario;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws CamposVaciosException {
		if (precio.equals("")) {
			throw new CamposVaciosException("precio");
		}
		this.precio = Double.parseDouble(precio);
	}

	public int getNumDormitorios() {
		return numDormitorios;
	}

	public void setNumDormitorios(String numDormitorios) throws CamposVaciosException, DormitoriosException {
		if (numDormitorios.equals("")) {
			throw new CamposVaciosException("numDormitorios");
		}
		int numDorm=Integer.parseInt(numDormitorios);
		
		if (numDorm<0||numDorm>5) {
			throw new DormitoriosException();
		}
		else {
			this.numDormitorios = Integer.parseInt(numDormitorios);
		}
		
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) throws CamposVaciosException {
		if (poblacion.equals("")) {
			throw new CamposVaciosException("poblacion");
		}
		this.poblacion = poblacion;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) throws ParseException, CamposVaciosException {
		if (fecha.equals("")) {
			throw new CamposVaciosException("fecha");
		}
		
		java.util.Date fech=null;
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		fech=formateador.parse(fecha);		
		this.fecha = new java.sql.Date(fech.getTime());
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(String alquilado) throws CamposVaciosException {
		if (alquilado.equals("")) {
			throw new CamposVaciosException("alquilado");
		}
		this.alquilado = Boolean.parseBoolean(alquilado);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVivienda == null) ? 0 : idVivienda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vivienda other = (Vivienda) obj;
		if (idVivienda == null) {
			if (other.idVivienda != null)
				return false;
		} else if (!idVivienda.equals(other.idVivienda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idVivienda + "," + idUsuario + "," + precio+ "," + numDormitorios + "," + poblacion + "," + fecha
				+ "," + alquilado;
	}

	@Override
	public int compareTo(Vivienda vivienda) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return this.poblacion.compareTo(vivienda.getPoblacion());
	}

}
