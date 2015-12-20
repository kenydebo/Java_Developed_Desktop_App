/*
 * Purpose: ProductSupplier database functions class for TravelExperts Database 
 * Author: Mark Poffenroth
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


public class ProductSupplierDB {
    
    
    
    /// <summary>
    /// Get ProductSupplier object for specified Product and Supplier IDs
    /// </summary>
    /// <param name="productId"> Product ID used to select ProductSupplier ID.</param>
    /// <param name="supplierId"> Supplier ID used to select ProductSupplier ID.</param>
    /// <returns>Int of ProductSupplier ID for specified Product and Supplier IDs.</returns>
    public static ProductSupplier getProductSupplier(String productId, String supplierId)
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        
        ProductSupplier productSupplier = new ProductSupplier();
        
        try 
        {
            // Open db connection
            connection = connectDB();
            
            // Define query string 
            String query = "SELECT * FROM Products_Suppliers " +
                " WHERE ProductId=? and SupplierId=?";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, productId);
            statement.setString(2, supplierId);

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery();
            
            // Add Package objects to packages list
            while (resultSet.next()) 
            {
                //Product product = new Product();
                productSupplier.setProductSupplierId(resultSet.getInt("ProductSupplierId"));
                productSupplier.setProductId(resultSet.getInt("ProductId"));
                productSupplier.setSupplierId(resultSet.getInt("SupplierId"));
                //products.add(product); 
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
        // Return list
        return productSupplier;
    }

  
}
