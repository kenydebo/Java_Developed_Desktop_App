/*
 * Purpose: Supplier database functions class for TravelExperts Database 
 * Author: 
 * Date: August 2015
 */

package dbase;

import static dbase.MySQLData.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Zahra
 * @author 696210
 */
public class SupplierDB 
{
    
    //create function to get Suppliers information
    public static List<Supplier> getSupplier(String query)  
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        
        //craete a list to put suppliers inside
        List<Supplier> suppliers = new ArrayList<Supplier>();

        try 
        {
            // Open db connection(connected locally)
            connection = connectDB();
            
            // Statements allow us to issue SQL queries to dbase
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
      
            // Add Suppliers objects to suppliers list
            while (resultSet.next()) 
            {
                
                Supplier supplier = new Supplier();
                supplier.setSupplierId(resultSet.getInt("SupplierId"));
                supplier.setSupName(resultSet.getString("SupName"));
                suppliers.add(supplier);
             
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
        // Return suppliers list
        return suppliers;
    }

    
    /// <summary>
    /// Get suppliers records for specified product id
    /// </summary>
    /// <param name="productId">ProductId to get suppliers for.</param>
    /// <returns></returns>     
    public static List<Supplier> getSupplierForProduct(String productId)  
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        //PreparedStatement statement = null;
        
        List<Supplier> suppliers = new ArrayList<Supplier>();

        try 
        {
            // Open db connection
            connection = connectDB();
            
              // Define query string 
            String query = "SELECT s.SupplierId, s.SupName " +
                " FROM Suppliers s " +
                " INNER JOIN Products_Suppliers ps ON ps.SupplierId = s.SupplierId " +
                " WHERE ps.ProductId = " + productId + //<> ?";
                " ORDER BY s.SupName ";
            
            //statement = connection.prepareStatement(query);
            //statement.setInt(1, 2);
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
      
            // Add Suppliers objects to suppliers list
            while (resultSet.next()) 
            {
                Supplier supplier = new Supplier();
                supplier.setSupplierId(resultSet.getInt("SupplierId"));
                supplier.setSupName(resultSet.getString("SupName"));
                suppliers.add(supplier);
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
        // Return suppliers list
        return suppliers;
    }
    
    
    /// <summary>
    /// Update suppliers record in database
    /// </summary>
    /// <param name="suppliers">supplier object to update.</param>
    /// <returns></returns>     
    public static void updateSupplier(Supplier supplier) 
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        
        try 
        {
            // Open db connection
            connection = connectDB();
            
            // Statements allow us to issue SQL queries to dbase
            String query = "UPDATE Suppliers SET " + 
                           "SupName=? " +
                           "WHERE SupplierId=?";

            statement = connection.prepareStatement(query);
            
            statement.setString(1, supplier.getSupName());
            statement.setInt(2, supplier.getSupplierId());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Update successful!");
            }    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Cleanup
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }
    
    
    /// <summary>
    /// Insert supplier record in database
    /// </summary>
    /// <param name="supplier">supplier object to insert.</param>
    /// <returns></returns>     
    public static void insertSupplier(Supplier supplier) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;
        
        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "INSERT INTO Suppliers " + 
                           "SupName " +
                           "VALUES (?)";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, supplier.getSupName());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Insert successful!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Cleanup
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }

    
    /// <summary>
    /// Delete  record in database
    /// </summary>
    /// <param name="suppliers">Suppliers object to delete.</param>
    /// <returns></returns>     
    public static void deleteSupplier(String SupplierId) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;

        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "DELETE FROM Suppliers WHERE SupplierId=? ";

            statement = connection.prepareStatement(query);
            statement.setString(1, SupplierId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Delete successful!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Cleanup
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }

   
    
}
