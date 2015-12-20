/*
 * Author: Filmon Ghezehey
 * Date: Oct-07-2015
 * Purpose: Getting agency data from the database 
 */
package dbase;

import static dbase.MySQLData.connectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 654556
 */
public class AgencyDB {
     public static List<Agency> getAgenncies()  
    {
        // Local variables
        String query = "select * from agencies";
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        
        List<Agency> agencies = new ArrayList<Agency>();

        try 
        {
            // Open db connection
            connection = connectDB();
            
            // Statements allow us to issue SQL queries to dbase
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
      
            // Add Agent objects to agents list
            while (resultSet.next()) 
            {
                Agency agency = new Agency();
                agency.setAgencyId(resultSet.getInt("agencyId"));
                agency.setAgncyAddress(resultSet.getString("AgncyAddress"));
                agency.setAgncyCity(resultSet.getNString("AgncyCity"));
                agency.setAgncyCountry(resultSet.getString("AgncyCountry"));
                agency.setAgncyFax(resultSet.getString("AgncyFax"));
                agency.setAgncyPhone(resultSet.getString("AgncyPhone"));
                agency.setAgncyPostal(resultSet.getString("AgncyPostal"));
                agency.setAgncyProv(resultSet.getString("AgncyCity"));              
                
                agencies.add(agency);
            }  
        } 
        catch ( SQLException e) {
             e.printStackTrace();
        } 
        finally {
            // Cleanup
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        // Return agents list
        return agencies;
    }

    
}
