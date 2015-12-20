 /*Author: 
 * Date : Aug. 22-2015
 * Aim  : Customer class
 */

package dbase;

import static dbase.MySQLData.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 654556
 */
public class Customer {


	//private members
        private int      AgentId;
        private String  CustFirstName;
        private String  CustLastName;
	private String  CustHomePhone;
	private String  CustCity;
	private String  CustAddress;
	private String  CustProv;	
	private String  CustCountry;
	private String  CustBusPhone;
	private int     CustomerId;
	private String  CustPostal;
	private String  CustEmail;

    public void setCustFirstName(String CustFirstName) {
        this.CustFirstName = CustFirstName;
    }

    public void setCustLastName(String CustLastName) {
        this.CustLastName = CustLastName;
    }

	public String getCustFirstName() {
		return CustFirstName;
	}

    //Getters and Setters
    public String getCustLastName() {
        return CustLastName;
    }

    public void setAgentId(int AgentId) {
        this.AgentId = AgentId;
    }

    public int getAgentId() {
        return AgentId;
    }

    public String getCustHomePhone() {
        return CustHomePhone;
    }
	public void setCustHomePhone(String custHomePhone) {
		CustHomePhone = custHomePhone;
	}
	public String getCustCity() {
		return CustCity;
	}
	public void setCustCity(String custCity) {
		CustCity = custCity;
	}
	public String getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}
	public String getCustProv() {
		return CustProv;
	}
	public void setCustProv(String custProv) {
		CustProv = custProv;
	}
	public String getCustCountry() {
		return CustCountry;
	}
	public void setCustCountry(String custCountry) {
		CustCountry = custCountry;
	}
	public String getCustBusPhone() {
		return CustBusPhone;
	}
	public void setCustBusPhone(String custBusPhone) {
		CustBusPhone = custBusPhone;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustPostal() {
		return CustPostal;
	}
	public void setCustPostal(String custPostal) {
		CustPostal = custPostal;
	}
	public String getCustEmail() {
		return CustEmail;
	}
	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}

    public Customer(String CustFirstName, String CustLastName,
            String CustHomePhone, String CustCity, String CustAddress,
            String CustProv, String CustCountry, String CustBusPhone,
            int CustomerId, String CustPostal, String CustEmail)
    {
        this.CustFirstName = CustFirstName;
        this.CustLastName = CustLastName;
        this.CustHomePhone = CustHomePhone;
        this.CustCity = CustCity;
        this.CustAddress = CustAddress;
        this.CustProv = CustProv;
        this.CustCountry = CustCountry;
        this.CustBusPhone = CustBusPhone;
        this.CustomerId = CustomerId;
        this.CustPostal = CustPostal;
        this.CustEmail = CustEmail;
    }

    public Customer() 
    {
    }
	
    
    
}
