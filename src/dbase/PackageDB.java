/*
 * Purpose: Package database functions class for TravelExperts Database 
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
 * //Zahra
 * @author 696210
 */
public class PackageDB 
{
    //create function to get package information
    public static List<TravelPackage> getTravelPackages(String filter)  
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        
        String query = "SELECT PackageId, PkgName, PkgStartDate, PkgEndDate, PkgDesc, " + 
            "PkgBasePrice, PkgAgencyCommission " + 
            " FROM Packages " +
            " WHERE PackageId " + filter;  
         
        //create a list to put packages inside
        List<TravelPackage> travelPackages = new ArrayList<TravelPackage>();

        try 
        {
            // Open db connection(connected locally)
            connection = connectDB();
            
            // Statements allow us to issue SQL queries to dbase
            statement = connection.createStatement();

            // Execute SQL statement and get back a result set (or an exception)
            resultSet = statement.executeQuery(query);
      
            // Add Package objects to packages list
            while (resultSet.next()) 
            {
                TravelPackage travelPackage = new TravelPackage();
                travelPackage.setPackageId(resultSet.getInt("PackageId"));
                travelPackage.setPkgName(resultSet.getString("PkgName"));
                travelPackage.setPkgStartDate(resultSet.getDate("PkgStartDate"));
                travelPackage.setPkgEndDate(resultSet.getDate("PkgEndDate"));
                travelPackage.setPkgDesc(resultSet.getString("PkgDesc"));
                travelPackage.setPkgBasePrice(resultSet.getDouble("PkgBasePrice"));
                travelPackage.setPkgAgencyCommission(resultSet.getDouble("PkgAgencyCommission"));
                travelPackages.add(travelPackage); 
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
        return travelPackages;
    }

    
    /// <summary>
    /// Update Package record in database
    /// </summary>
    /// <param name="package">Package object to update.</param>
    /// <returns></returns>     
    public static void updateTravelPackage(TravelPackage travelPackage) 
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
            String query = "UPDATE Packages SET " + 
                           "PkgName=?, PkgStartDate=?, PkgEndDate=?, PkgDesc=?, PkgBasePrice=?,PkgAgencyCommission=? " +
                           "WHERE PackageId=?";

            statement = connection.prepareStatement(query);
            
            statement.setString(1,travelPackage.getPkgName());
            java.sql.Date sqlDateStart = new java.sql.Date(travelPackage.getPkgStartDate().getTime());
            statement.setDate(2, sqlDateStart);
            java.sql.Date sqlDateEnd = new java.sql.Date(travelPackage.getPkgEndDate().getTime());
            statement.setDate(3,sqlDateEnd);   
            statement.setString(4, travelPackage.getPkgDesc());
            statement.setDouble(5, travelPackage.getPkgBasePrice());
            statement.setDouble(6, travelPackage.getPkgAgencyCommission());
            statement.setInt(7, travelPackage.getPackageId());
            
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
    /// Insert package record in database
    /// </summary>
    /// <param name="package">package object to insert.</param>
    /// <returns></returns>     
    public static void insertTravelPackage(TravelPackage travelPackage) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;
        
        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "INSERT INTO Packages " + 
                           "(PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice,PkgAgencyCommission) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, travelPackage.getPkgName());
            java.sql.Date sqlDateStart = new java.sql.Date(travelPackage.getPkgStartDate().getTime());
            statement.setDate(2, sqlDateStart);
            java.sql.Date sqlDateEnd = new java.sql.Date(travelPackage.getPkgEndDate().getTime());
            statement.setDate(3,sqlDateEnd);   
            statement.setString(4, travelPackage.getPkgDesc());
            statement.setDouble(5, travelPackage.getPkgBasePrice());
            statement.setDouble(6, travelPackage.getPkgAgencyCommission());

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
    /// Delete Package record in database
    /// </summary>
    /// <param name="package">Package object to delete.</param>
    /// <returns></returns>     
    public static void deleteTravelPackage(String packageId) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;

        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "DELETE FROM Packages WHERE PackageId=? ";

            statement = connection.prepareStatement(query);
            statement.setString(1, packageId);

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
