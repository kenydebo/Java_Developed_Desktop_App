/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


public class ProductDB {
    

    /// <summary>
    /// Get List of Product and Supplier fields for specfied Package Id
    /// </summary>
    /// <param name="packageid">Package Id used to get Packages</param>
    /// <returns>DataSet of Product and Supplier fields  for specfied Package Id.</returns>
    public static List<List<String>> getProductSupplierInPackage(String packageId)
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        //PreparedStatement statement = null;
        Statement statement = null;
        
        List<List<String>> resultsList = new ArrayList<List<String>>();

        try
        {
            // Open db connection
            connection = connectDB();
            
            // Define query string 
            String query = "SELECT pr.ProductId, pr.ProdName, s.SupplierId, s.SupName " +
                " FROM Products pr " +
                " INNER JOIN Products_Suppliers ps ON pr.ProductId = ps.ProductId " + 
                " INNER JOIN Suppliers s ON s.SupplierId = ps.SupplierId " +
                " INNER JOIN Packages_Products_Suppliers pps ON pps.ProductSupplierId = ps.ProductSupplierId " +
                " INNER JOIN Packages pa ON pa.PackageId = pps.PackageId " +
                " WHERE pa.PackageId= " + packageId +  // ?";
                " ORDER BY pr.ProdName";
            
            //statement = connection.prepareStatement(query);
            //int pid = Integer.parseInt(packageId);
            //statement.setInt(1, pid);
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
            
            // Add Package objects to packages list
            while (resultSet.next()) 
            {
                List<String> result = new ArrayList<String>();
                result.add(String.valueOf(resultSet.getInt("ProductId")));
                result.add(resultSet.getString("ProdName"));
                result.add(String.valueOf(resultSet.getInt("SupplierId")));
                result.add(resultSet.getString("SupName"));
                resultsList.add(result); 
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
        // Return results list
        return resultsList;
    }

    
    /// <summary>    
    /// Gets list of Products objects NOT already included w/ specfied Package Id
    /// </summary>
    /// <param name="packageid">Package Id used to get Packages</param>
    /// <returns>List of Product objects available to add to specfied Package Id.</returns>
    public static List<Product> getProductsNotInPackage(String packageId)
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        //PreparedStatement statement = null;
        Statement statement = null;
        
        List<Product> products = new ArrayList<Product>();

        try 
        {
            // Open db connection
            connection = connectDB();
            
            // Define query string 
            String query = "SELECT DISTINCT pr.ProductId, pr.ProdName " +
                " FROM Products pr " +
                " INNER JOIN Products_Suppliers ps ON pr.ProductId = ps.ProductId " +
                " INNER JOIN Packages_Products_Suppliers pps ON pps.ProductSupplierId = ps.ProductSupplierId " +
                " INNER JOIN Packages pa ON pa.PackageId = pps.PackageId " +
                " WHERE pa.PackageId<> " + packageId + //<> ?";
                " ORDER BY pr.ProdName";
                
            //statement = connection.prepareStatement(query);
            //statement.setString(1, packageId);
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
            
            // Add Package objects to packages list
            while (resultSet.next()) 
            {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ProductId"));
                product.setProdName(resultSet.getString("ProdName"));
                products.add(product); 
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
        // Return packages list
        return products;
    }
        
        
    /// <summary>     
    /// Gets list of all Products in database
    /// </summary>
    /// <param name="packageid">Package Id used to get Packages</param>
    /// <returns>List of Product objects.</returns>
    public static List<Product> getProducts(String filter)
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        //PreparedStatement statement = null;
        Statement statement = null;
        
        List<Product> products = new ArrayList<Product>();

        try 
        {
            // Open db connection
            connection = connectDB();
            
            // Define query string 
            String query = "SELECT ProductId, ProdName " +
                " FROM Products " +
                " WHERE ProductId " + filter;  
       
            // Statements allow us to issue SQL queries to dbase
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
            
            // Add Package objects to packages list
            while (resultSet.next()) 
            {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ProductId"));
                product.setProdName(resultSet.getString("ProdName"));
                products.add(product); 
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
        // Return packages list
        return products;
    }

       
    /// <summary>
    /// Insert Product record in database
    /// </summary>
    /// <param name="package">Product object to insert.</param>
    /// <returns></returns>     
    public static void insertProduct(Product product) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;
        
        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "INSERT INTO Products " + 
                           "(ProdName) " +
                           "VALUES (?)";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getProdName());

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
    /// Update Product record in database
    /// </summary>
    /// <param name="product">Product object to update.</param>
    /// <returns></returns>     
    public static void updateProduct(Product product) 
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
            String query = "UPDATE Products SET " + 
                           "ProdName=? " +
                           "WHERE ProductId=?";
            
            statement = connection.prepareStatement(query);
            
            statement.setString(1, product.getProdName());
            statement.setInt(2,product.getProductId());
            
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
    /// Delete Product record in database
    /// </summary>
    /// <param name="productId">Product id of product record to delete.</param>
    /// <returns></returns>     
    public static void deleteProduct(String productId) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;

        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "DELETE FROM Products WHERE ProductId=? ";

            statement = connection.prepareStatement(query);
            statement.setString(1, productId);

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
