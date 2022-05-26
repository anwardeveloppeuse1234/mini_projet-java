package application;

public class vendeur extends salaire {

	double Vente;
	double Pourcentage;
	public double getVente() {
		return Vente;
	}
		public vendeur(int matricule, String nom, String email, double dateE, double vente) {
		super(matricule, nom, email, dateE);
		// TODO Auto-generated constructor stub
		Vente = vente;
		Pourcentage = setPourcentage(Vente);
		Salaire =setSalaireDebut(dateE)+ Pourcentage;
	}
		
		public void setVente(double vente) {
			Vente = vente;
		}
		public double getPourcentage() {
			return Pourcentage;
		}
		public double setPourcentage(double vente) {
			return vente * 7.2;
		}
		
		public double setSalaireDebut(double dateE) {
			if(dateE>2005) return 280;
			else return 400;
		}
		
		
			
		
		@Override
		public String toString() {
			return "Vendeur [Vente=" + Vente + ", Pourcentage=" + Pourcentage + ", matricule=" + matricule + ", nom=" + nom
					+ ", email=" + email + ", dateF=" + dateE + ", Salaire=" + Salaire + "]";
		}

		
		
		
	}
