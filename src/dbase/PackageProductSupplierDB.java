/*
 * Purpose: PackageProductSupplier DB functions class for TravelExperts Database 
 * Author: Mark Poffenroth
 * Date: Sep 2015
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


public class PackageProductSupplierDB {


    /// <summary>
    /// Check if Packages_Products_Suppliers table has existing entry for specified Package Id, ProductSupplier Id
    /// </summary>
    /// <param name="packageID">Package Id to add to record</param>
    /// <param name="productID">ProductSupplier Id to add to record</param>
    /// <returns>Boolean to indicate check result</returns>
    public static boolean checkPackageProductSupplier(String packageID, int productSupplierID)
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        boolean result = false;
        
        try
        {
            // Open db connection
            connection = connectDB();
            
            // Define query string 
            String query = " SELECT COUNT(*) FROM Packages_Products_Suppliers " +
                " WHERE PackageId=? AND ProductSupplierId=?";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, packageID);
            statement.setInt(2, productSupplierID);
            
            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery();
            
            // Check if query returned a result (scalar query)
            int count = 0;
            while (resultSet.next()) 
            {
                count = resultSet.getInt(1);
            }

            // Check if record already exists in table
            if (count > 0)
            {
                result = true;
            }
            // Records does not exist
            else
                result = false;
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
        return result;
    }


    /// <summary>
    /// Insert new record in Packages_Products_Suppliers table for specified Package Id, ProductSupplier Id
    /// </summary>
    /// <param name="packageID">Package Id to add to record</param>
    /// <param name="productID">ProductSupplier Id to add to record</param>
    /// <returns>Boolean to indicate instert result</returns>
    public static boolean insertPackageProductSupplier(String packageID, int productSupplierID)
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        
        System.out.println("packageID" + packageID);
        System.out.println("productSupplierID" + productSupplierID);
        
        try
        {
            // Open db connection
            connection = connectDB();
            
            // Define query string 
            String query = " INSERT INTO Packages_Products_Suppliers " + 
                " (PackageId, ProductSupplierId) " +
                " VALUES (?, ?)";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, packageID);
            statement.setInt(2, productSupplierID);
            
            // Execute SQL statement and get back a result set (or an exception)
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
            //if (statement.execute()) {
                result = true;
                System.out.println("Insert successful!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Cleanup
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        return result;
    }



    /// <summary>
    /// Delete record Packages_Products_Suppliers table for specified Package Id, ProductSupplier Id
    /// </summary>
    /// <param name="packageID">Package Id to delete from record</param>
    /// <param name="productID">ProductSupplier Id to delete from record</param>
    /// <returns>Bool to indicate whether delete succeeded or failed.</returns>

    public static boolean deletePackageProductSupplier(String packageId, int productSupplierId)
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        
        try
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "DELETE FROM Packages_Products_Suppliers " +
                "WHERE PackageId = ? AND ProductSupplierId = ?";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, packageId);
            statement.setInt(2, productSupplierId);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                result = true;
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
        return result;
    }


}
