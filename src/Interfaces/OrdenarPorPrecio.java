package Interfaces;

import java.util.Comparator;

import Modelo.Vivienda;

public class OrdenarPorPrecio implements Comparator<Vivienda>{

	public OrdenarPorPrecio() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Vivienda viv1, Vivienda viv2) {
		// TODO Auto-generated method stub
		return (String.valueOf(viv1.getPrecio()).compareTo(String.valueOf(viv2.getPrecio())));
	}

}
