package Excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException(String campos) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		System.err.println("El campo "+campos+" no puede estar vacio");
	}

}
