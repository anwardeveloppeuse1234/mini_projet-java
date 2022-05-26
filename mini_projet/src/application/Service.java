package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Service implements Initializable{

	
	
	public void creerSalarier() {
		try{  			
			PreparedStatement ps=connexion.getCon().prepareStatement("insert into entreprise values(?,?,?,?,?,?,?,?)");  
			  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter matricule:");  
			int matricule=Integer.parseInt(br.readLine());
			System.out.println("enter nom:");  
			String nom=br.readLine();  
			System.out.println("enter email:");  
			String email=br.readLine();  
			
			System.out.println("enter dateEmbauche:");  
			double dateE=Double.parseDouble(br.readLine());
			System.out.println("enter valeur supplémentaire:");  
			double sup=Double.parseDouble(br.readLine());
			System.out.println("enter categorie:");  
			String categorie=br.readLine(); 
			
			if(categorie=="employe") {
				Employe s = new Employe(matricule,nom,email,dateE,sup);
				ps.setInt(1, s.matricule);
				ps.setString(2,s.nom);  
				ps.setString(3,s.email);
				ps.setDouble(4, s.Salaire);
				ps.setDouble(5, s.dateE);
				ps.setDouble(6, s.Sup);
				ps.setDouble(7, s.PrixSup);
				ps.setString(8, categorie);
			}else if(categorie=="vendeur"){
				vendeur s = new vendeur(matricule,nom,email,dateE,sup);
				ps.setInt(1, s.matricule);
				ps.setString(2,s.nom);  
				ps.setString(3,s.email);
				ps.setDouble(4, s.Salaire);
				ps.setDouble(5, s.dateE);
				ps.setDouble(6, s.Vente);
				ps.setDouble(7, s.Pourcentage);
				ps.setString(8, categorie);
			}
			int i=ps.executeUpdate();  
			System.out.println(i+" employe ajouté dans entreprise");  
			  
			connexion.getCon().close();  
			
		}catch(Exception e){ System.out.println(e);}
	}

	public List<salaire> tout;
	public void affichertout() {
		ArrayList<salaire> tout = new ArrayList<salaire>();
		try{
			Statement stmt=connexion.getCon().createStatement();  
			ResultSet rs=stmt.executeQuery("select * from entreprise");  
			while(rs.next())  
			tout.add(new Employe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(5), rs.getDouble(6)));
			connexion.getCon().close();  
		}catch(Exception e){ System.out.println(e);}
	}
	
	public List<salaire> affiche(){
		ArrayList<salaire> tout = new ArrayList<salaire>();
		try{
			Statement stmt=connexion.getCon().createStatement();  
			ResultSet rs=stmt.executeQuery("select * from entreprise");  
			while(rs.next())  
			tout.add(new Employe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(5), rs.getDouble(6))); 
		}catch(Exception e){ System.out.println(e);}
		return tout;
		
	}

	public void supprimerSalarier(int matricule) {
		try{  			
			PreparedStatement ps=connexion.getCon().prepareStatement("delete from entreprise where matriculeE=?");  
			ps.setInt(1, matricule);
			
			int i=ps.executeUpdate();  
			System.out.println(i+" emaploye from entreprise deleted");  
			  
			connexion.getCon().close();
		}catch(Exception e){ System.out.println(e);}
	}

	public void afficherDetailler(int matricule) {
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("select * from entreprise where matriculeE=?");
			ps.setInt(1, matricule);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getDouble(5)+"  ");  
			connexion.getCon().close();  
		}catch(Exception e){ System.out.println(e);}
	}

	public void listerParSalaire(){
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("select * from entreprise order by salaire asc");
			ResultSet rs=ps.executeQuery();  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getDouble(5)+"  ");  
			connexion.getCon().close();  
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void listerParCategorie(String cat){
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("select * from entreprise where category="+cat);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getDouble(5)+"  ");  
			connexion.getCon().close();  
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void listerParAncienette(){
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("select * from entreprise order by dateEmbauche asc");
			ResultSet rs=ps.executeQuery();  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getDouble(5)+"  ");  
			connexion.getCon().close();  
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void listerEntreDeux(double minimum, double maximum){
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("select * from entreprise where salaire between ? and ?");
			ps.setDouble(1, minimum);
			ps.setDouble(2, maximum);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getDouble(5)+"  ");  
			connexion.getCon().close();  
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void listerVendeurA(double minimum, double maximum){
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("select * from entreprise where category='vendeur' order by salaire desc");
			ResultSet rs=ps.executeQuery();  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getDouble(5)+"  ");   
		}catch(Exception e){ System.out.println(e);}
	}

	@FXML
	ChoiceBox ch;
	
	List<vendeur> listSal;
	List<String> listCat;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listSal = new ArrayList<vendeur>();
		listCat = new ArrayList<String>();
		String req = "select * from entreprise";
		try {
			Statement stmt = connexion.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(req);
			while(rs.next()) {
				listSal.add(new vendeur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(5), rs.getDouble(6)));
				listCat.add(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObservableList<vendeur> ob = FXCollections.observableArrayList(listSal);
		ObservableList<String> obC = FXCollections.observableArrayList(listCat);
		tableau.getItems().addAll(ob);
		tableauCat.getItems().addAll(obC);
		colMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
		colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colSalaire.setCellValueFactory(new PropertyValueFactory<>("Salaire"));
		colCategorie.setCellValueFactory(data -> new SimpleStringProperty());
		
		
		ch.getItems().add("Employe");
		ch.getItems().add("Vendeur");
		
		
		
		this.affiche();
	}
	public void a() {
		Iterator<String> it = listCat.iterator();
		while(it.next() != null) {
			colCategorie.setText(it.next().toString());
		}
	}
	
	@FXML
	TableView<String> tableauCat;
	
	@FXML
	TextField matricule;
	
	@FXML
	TextField nom;
	
	@FXML
	TextField Date;
	
	@FXML
	TextField email;
	@FXML
	TextField valeursup;

	@FXML
	TextField categorie;
	
	@FXML
	Button ajouter;
	
	@FXML
	Button modifier;
	
	@FXML
	Button supprimer;
	
	@FXML
	TableView<salaire> tableau;
	
	@FXML
	TableColumn<salaire, Integer> colMatricule;
	
	@FXML
	TableColumn<salaire, String> colNom;
	
	@FXML
	TableColumn<salaire, String> colEmail;
	
	@FXML
	TableColumn<salaire, Double> colSalaire;
	
	@FXML
	TableColumn colCategorie;
	public void ajout() {
		try{
			PreparedStatement ps=connexion.getCon().prepareStatement("insert into entreprise values(?,?,?,?,?,?,?,?)");  			
			int Matricule=Integer.parseInt(matricule.getText());
			String newNom=nom.getText();  
			String newEmail=email.getText();  
			double NewDateE=Double.parseDouble(Date.getText());
			double NewSup=Double.parseDouble(valeursup.getText());
			String newCategory=(String) ch.getValue();
			if(newCategory=="employe") {
				vendeur s = new vendeur(Matricule,newNom,newEmail,NewDateE,NewSup);
				ps.setInt(1, s.getMatricule());
				ps.setString(2,s.getNom());  
				ps.setString(3,s.getEmail());
				ps.setDouble(4, s.getSalaire());
				ps.setDouble(5, s.getDateE());
				ps.setDouble(6, s.getVente());
				ps.setDouble(7, s.getPourcentage());
				ps.setString(8, newCategory);
				}
			else {
				Employe s = new Employe(Matricule,newNom,newEmail,NewDateE,NewSup);
				ps.setInt(1, s.getMatricule());
				ps.setString(2,s.getNom());  
				ps.setString(3,s.getEmail());
				ps.setDouble(4, s.getSalaire());
				ps.setDouble(5, s.getDateE());
				ps.setDouble(6, s.getSup());
				ps.setDouble(7, s.getPrixSup());
				ps.setString(8, newCategory);
			}
			ps.executeUpdate();  
		}catch(Exception e){ System.out.println(e);}
	}
}