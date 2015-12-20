/*
 * Purpose: Agent database functions class for TravelExperts Database 
 * Author: Filmon Ghezehey
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

public class AgentDB {
    
    
    /// <summary>
    /// Get list of Agents from database
    /// </summary>
    /// <param name="query">SQL command to be run.</param>
    /// <returns>List of Agent objects.</returns>
    public static List<Agent> getAllAgents()  
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String query = "select * from Agents" ;
        
        List<Agent> agents = new ArrayList<Agent>();

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
                Agent agent = new Agent();
                agent.setAgentId(resultSet.getInt("agentId"));
                agent.setAgtFirstName(resultSet.getString("agtFirstName"));
                agent.setAgtLastName(resultSet.getString("agtLastName"));
                agent.setAgtMiddleInitial(resultSet.getString("agtMiddleInitial"));
                agent.setAgtBusPhone(resultSet.getString("agtBusPhone"));
                agent.setAgtEmail(resultSet.getString("agtEmail"));
                agent.setAgtPosition(resultSet.getString("agtPosition"));
                agent.setAgencyId(resultSet.getInt("agencyId"));
                agent.setAgentStatus(resultSet.getString("AgentStatus"));
                agents.add(agent);
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
        return agents;
    }

     public static List<Agent> getAllAgents(String query)  
    {
        // Local variables
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;     
        
        List<Agent> agents = new ArrayList<Agent>();

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
                Agent agent = new Agent();
                agent.setAgentId(resultSet.getInt("agentId"));
                agent.setAgtFirstName(resultSet.getString("agtFirstName"));
                agent.setAgtLastName(resultSet.getString("agtLastName"));
                agent.setAgtMiddleInitial(resultSet.getString("agtMiddleInitial"));
                agent.setAgtBusPhone(resultSet.getString("agtBusPhone"));
                agent.setAgtEmail(resultSet.getString("agtEmail"));
                agent.setAgtPosition(resultSet.getString("agtPosition"));
                agent.setAgencyId(resultSet.getInt("agencyId"));
                agent.setAgentStatus(resultSet.getString("AgentStatus"));
               // agent.setAgentId(resultSet.getI("AgentId"));
                agents.add(agent);
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
        return agents;
    }
    
    
    /// <summary>
    /// Update Agent record in database
    /// </summary>
    /// <param name="agent">Agent object to update.</param>
    /// <returns></returns>     
    public static void updateAgent(Agent agent) 
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
            String query = "UPDATE Agents SET " + 
                "AgtFirstName=?, AgtMiddleInitial=?, AgtLastName=?, AgtBusPhone=?, AgtEmail=?, " + 
                "AgtPosition=?, AgencyId=?, AgentStatus=? WHERE AgentId=?";

            statement = connection.prepareStatement(query);
            //String temp = txtAgtFirstName.getText();
            statement.setString(1, agent.getAgtFirstName());
            statement.setString(2, agent.getAgtMiddleInitial());
            statement.setString(3, agent.getAgtLastName());
            statement.setString(4, agent.getAgtBusPhone());
            statement.setString(5, agent.getAgtEmail());
            statement.setString(6, agent.getAgtPosition());
            statement.setInt(7, agent.getAgencyId());
            statement.setString(8, agent.getAgentStatus());
            statement.setString(9,agent.getAgentId()+"");
            
            
            
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
    /// Insert Agent record in database
    /// </summary>
    /// <param name="agent">Agent object to insert.</param>
    /// <returns></returns>     
    public static void insertAgent(Agent agent) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;
        
        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "INSERT INTO Agents " + 
                "(AgtFirstName, AgtMiddleInitial, AgtLastName, AgtBusPhone, AgtEmail, " + 
                "AgtPosition, AgencyId,AgentStatus) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

            statement = connection.prepareStatement(query);
            statement.setString(1, agent.getAgtFirstName());
            statement.setString(2, agent.getAgtMiddleInitial());
            statement.setString(3, agent.getAgtLastName());
            statement.setString(4, agent.getAgtBusPhone());
            statement.setString(5, agent.getAgtEmail());
            statement.setString(6, agent.getAgtPosition());
            statement.setInt(7, agent.getAgencyId());
            statement.setString(8,agent.getAgentStatus());

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
    /// Delete Agent record in database
    /// </summary>
    /// <param name="agent">Agent object to delete.</param>
    /// <returns></returns>     
    public static void deleteAgent(String agentId) 
    {
        // Local variables
        Connection connection = null;
        PreparedStatement statement = null;

        try 
        {
            // Open db connection
            connection = connectDB();

            // Statements allow us to issue SQL queries to dbase
            String query = "DELETE FROM Agents WHERE AgentId=?";

            statement = connection.prepareStatement(query);
            statement.setString(1, agentId);

            int rowsDeleted = statement.executeUpdate();
           
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

  /*  public static Agent getAgentByID(String agentId)
    {
       /*  // local variables        
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        
        Agent agent = new Agent();
       
     
       String query = "SELECT * FROM Agents WHERE AgentId=1";
        
   
        //agents = getAgents(query);

        try
        {
            
            // Open db connection
            connection = connectDB();
            statement = connection.prepareStatement(query);
            //statement.setString(1, agentId);
            System.out.print("resultset empty");
            resultSet = statement.executeQuery();
            
            
            
            // Fill agent field w/ the result data
          /*
              agent.setAgtFirstName(resultSet.getString("AgtFirstName"));
              agent.setAgtMiddleInitial(resultSet.getString("AgtMiddleInitial"));
              agent.setAgtLastName(resultSet.getString("AgtLastName"));
              agent.setAgtBusPhone(resultSet.getString("AgtBusPhone"));
              agent.setAgtEmail(resultSet.getString("AgtEmail"));
              agent.setAgtPosition(resultSet.getString("AgtPosition"));
              agent.setAgencyId(Integer.getInteger(resultSet.getString("AgencyId")));
              agent.setAgentStatus(resultSet.getString("AgentStatus"));
           *
               if (resultSet !=null)
              {
                agent.setAgentId(resultSet.getInt("agentId"));
                agent.setAgtFirstName(resultSet.getString("agtFirstName"));
                agent.setAgtLastName(resultSet.getString("agtLastName"));
                agent.setAgtMiddleInitial(resultSet.getString("agtMiddleInitial"));
                agent.setAgtBusPhone(resultSet.getString("agtBusPhone"));
                agent.setAgtEmail(resultSet.getString("agtEmail"));
                agent.setAgtPosition(resultSet.getString("agtPosition"));
                agent.setAgencyId(resultSet.getInt("agencyId"));
                agent.setAgentStatus(resultSet.getString("AgentStatus"));
              }
               else System.out.print("resultset empty");
                     
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
         return agent ; 
         
    }
    */
}
