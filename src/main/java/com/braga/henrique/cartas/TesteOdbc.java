package com.braga.henrique.cartas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteOdbc {
	
	public static Connection getConnection() throws SQLException {
		
		String url="jdbc:postgresql://127.0.0.1:5432/artigos";   
	    String driver="org.postgresql.Driver";   
	    String usuario="postgres";   
	    String senha="postgres";
	        try { 
	            System.out.println(url);
	            Class.forName(driver);   
	            System.out.println("Conectando ao banco...");   
	            return DriverManager.getConnection(url,usuario,senha);   
	        } catch (Exception e ) {   
	            System.out.println(e.getMessage());   
	        }
			return null;   
	    }  
	


	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		 // change this to whatever your DSN is
		 String dataSourceName = "C:\\Users\\roger\\eclipse-workspace\\listagem-artigos\\listagem-artigos\\Openviewer.mdb";
		 String dbURL = "jdbc:ucanaccess://" + dataSourceName;
		 
		 // variables
	        Connection connection = null;
	        Statement statement = null;
	        Statement statement2 = null;
	        ResultSet resultSet = null;
	        ResultSet resultSet2 = null;
	        Connection connectionPostres = null;
		 try { 
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		

        connection = DriverManager.getConnection(dbURL); 
        connectionPostres = getConnection();
		// Step 2.B: Creating JDBC Statement 
        statement = connection.createStatement();
        statement2 = connectionPostres.createStatement();

        // Step 2.C: Executing SQL and 
        // retrieve data into ResultSet
        resultSet = statement.executeQuery("SELECT d.DocId, trim(d.indice1), p.Arquivo FROM Documentos_Arm01 d, Paginas_Arm01 p where d.DocId = p.DocId");

        System.out.println("ID\tName\t\t\tAge\tMatches");
        System.out.println("==\t================\t===\t=======");

        // processing returned data and printing into console
        while(resultSet.next()) {
            String rs = "INSERT INTO artigo(id_doc, nome, endereco_pdf) values (" + resultSet.getInt(1) + ",'" + 
                    resultSet.getString(2) + "','" + 
                    resultSet.getString(3) + "');";
            
            statement2.executeUpdate(rs);
            
        }
    }
    catch(SQLException sqlex){
        sqlex.printStackTrace();
    }
    finally {
        // Step 3: Closing database connection
        try {
            if(null != connection) {
                // cleanup resources, once after processing
                resultSet.close();
                statement.close();

                // and then finally close connection
                connection.close();
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
	}
		 
}
	
	   
         
         


