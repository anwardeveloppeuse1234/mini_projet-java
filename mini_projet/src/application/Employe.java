package application;

public class Employe  extends salaire{
	
	public Employe(int matricule, String nom, String email, double dateE, double sup) {
		super(matricule, nom, email, dateE);
		Sup = sup;
		PrixSup = setPrixSup(sup);
		Salaire = setSalaireDebut(dateE) +PrixSup;
	}
	double Sup;
	double PrixSup;
	public double getSup() {
		return Sup;
	}
	public void setSup(double sup) {
		Sup = sup;
	}
	public double getPrixSup() {
		return PrixSup;
	}
	public double setPrixSup(double sup) {
		return PrixSup = sup*14;
	}
	
	public double setSalaireDebut(double dateE) {
		if(dateE>2005) return 280;
		else return 400;
	}
	
}
