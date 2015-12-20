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

/**
 *
 * @author 654556
 */
public class CustomerDB {
       
    public static List<Customer> getAllAgents(String query)  
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;     
        
        List<Customer> customers = new ArrayList<Customer>();

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
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("CustomerId"));
                customer.setCustAddress((resultSet.getString("CustAddress")));
                customer.setCustBusPhone((resultSet.getString("CustBusPhone")));
                customer.setCustCity((resultSet.getString("CustCity")));
                customer.setCustCountry((resultSet.getString("CustCountry")));
                customer.setCustEmail((resultSet.getString("")));
                customer.setCustEmail((resultSet.getString("CustEmail")));
                customer.setCustFirstName((resultSet.getString("CustFirstName")));
                customer.setCustHomePhone((resultSet.getString("CustHomePhone")));                
                customer.setCustPostal((resultSet.getString("CustPostal")));
                customer.setCustProv((resultSet.getString("CustProv")));
                customer.setAgentId(resultSet.getInt("AgentId"));
                customers.add(customer);
                        
                        
                        
               
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
        return customers;
    }
    
        public static void updateCustomerAgent(String customerId, String AgentId) 
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
            String query = "UPDATE Customers SET " + 
                    "AgentId = ? WHERE CustomerID = ? " ;                  
              

            statement = connection.prepareStatement(query);
            //String temp = txtAgtFirstName.getText();
            statement.setString(1, customerId);
            statement.setString(2, AgentId);      
            
            
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
        

    public static String getStatus(String customerId)
    {
     // local variables        
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    Agent agent = new Agent();


   String query = "select AgentStatus from Agents a "
           + "inner join customers c on c.AgentId=a.AgentId "
           + "WHERE CustomerId= "+ customerId;



    String status = "";

    try
    {

        // Open db connection
        connection = connectDB();
        //statement = connection.prepareStatement(query);
        //statement.setString(1, agentId);
        statement = connection.createStatement();

       // resultSet = statement.executeQuery();
        resultSet = statement.executeQuery(query);

        while (resultSet.next())
        {
            status = resultSet.getString("AgentStatus");
     //     System.out.println(status); 

        }
//            if(resultSet !=null)
//            {
//                
//               status = resultSet.getString("AgentStatus").toString();
//               System.out.print(status);
//               
//            }
//            else
//            {
//                System.out.print("Not Found");
//            }


    }
    catch (Exception e) {
        e.printStackTrace();
       //System.out.print("resultset empty");
    } 
     finally {
        // Cleanup
        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    }
    //return status;
    return status;
    }
        
        
    
}
