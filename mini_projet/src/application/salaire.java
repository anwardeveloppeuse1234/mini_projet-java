package application;

public class salaire {
	int matricule;
	String nom;
	String email;
	double dateE;
	double Salaire;
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getDateE() {
		return dateE;
	}
	public void setDateE(double dateE) {
		this.dateE = dateE;
	}
	
	public double getSalaire() {
		return Salaire;
	}
		
	public salaire(int matricule, String nom, String email, double dateE) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.email = email;
		this.dateE = dateE;
		
	}
	@Override
	public String toString() {
		return "salaire [matricule=" + matricule + ", nom=" + nom + ", email=" + email + ", dateE=" + dateE
				+ "]";
	}
	
	
}
