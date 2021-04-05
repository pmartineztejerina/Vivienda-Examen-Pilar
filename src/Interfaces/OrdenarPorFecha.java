package Interfaces;

import java.util.Comparator;

import Modelo.Vivienda;

public class OrdenarPorFecha implements Comparator<Vivienda>{

	public OrdenarPorFecha() {
		// TODO Ap�ndice de constructor generado autom�ticamente
	}

	@Override
	public int compare(Vivienda viv1, Vivienda viv2) {
		// TODO Auto-generated method stub
		return viv1.getFecha().compareTo(viv2.getFecha());
	}

}
