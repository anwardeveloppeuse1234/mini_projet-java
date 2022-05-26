package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {
static Connection con = null ;
static {
	
	
	try{
	String url="jdbc:mysql://localhost:3306/mini_projet";
	
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url,"root","");
	}catch(ClassNotFoundException | SQLException e){
	}
	}
		
	public static Connection getCon(){
	return con ;}}
