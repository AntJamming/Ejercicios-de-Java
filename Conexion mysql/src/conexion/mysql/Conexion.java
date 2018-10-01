/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion.mysql;

import java.sql.*;

/**
 *
 * @author anton
 */
public class Conexion {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
           
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testis","root","");
            st = con.createStatement();
            
            
        }catch(Exception ex){
            System.out.println("Error:" +ex);
        }
        
    }
    public void getData(){
        try{
            
            String query = "select * from alumnos";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String Nombre = rs.getString("Nombre");
                String Matricula = rs.getString("Matricula");
                String Edad = rs.getString("Edad");
                System.out.println("Nombre: "+Nombre+"    "+"Matricula: "+Matricula+"    "+"Edad: "+Edad);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
