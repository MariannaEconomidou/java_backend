package JDBC;
import java.sql.*;
public class main {
    public static void print_country(ResultSet row) throws SQLException {
    	System.out.println(row.getString("Code"));
    	System.out.println(row.getString("Name"));
    	System.out.println(row.getString("Continent"));
    	System.out.println(row.getInt("Population"));
    	System.out.println(row.getBigDecimal("LifeExpectancy"));
        System.out.println("=".repeat(20));
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
     try(Connection conn=DriverManager.getConnection(
     "jdbc:mysql://localhost:3306/world","javauser","Marianna77E!"))
     {System.out.println(conn);
       
       Statement stmt=conn.createStatement();
       String query="SELECT * FROM country";
       ResultSet result=stmt.executeQuery(query);
       
       while(result.next())
       {
    	   print_country(result);  
    	   //System.out.println(result.getString("Name")+", ");
    	  // System.out.println(result.getInt("Population"));
       }
     
      stmt.close();
      result.close();
     
     
     
     
     
     
     
     
     
     
     
     
     
     
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("xx");
	}

}}
