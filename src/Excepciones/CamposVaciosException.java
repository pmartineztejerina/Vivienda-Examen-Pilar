package Excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException(String campos) {
		// TODO Apéndice de constructor generado automáticamente
		System.err.println("El campo "+campos+" no puede estar vacio");
	}

}
