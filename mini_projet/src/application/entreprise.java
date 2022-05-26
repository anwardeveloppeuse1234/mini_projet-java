package application;


import java.util.*;

public class entreprise {
	String nomE;
	double Salaire;
	Map<Integer, salaire> salarié = new TreeMap<Integer,salaire>();
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public Map<Integer, salaire> getSalarié() {
		return salarié;
	}
	public void setSalarié(Map<Integer, salaire> salarié) {
		this.salarié = salarié;
	}
	public entreprise(String nomE, Map<Integer, salaire> listSalarié) {
		super();
		this.nomE = nomE;
		this.salarié = listSalarié;
	}  

}
