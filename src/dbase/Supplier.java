/*
 * Purpose: Supplier class for TravelExperts Database 
 * Author: 
 * Date: August 2015
 */

package dbase;

/**
 * //Zahra
 * @author 696210
 */
public class Supplier 
{
    
    // Fields & Properties
    private int SupplierId;
    private String SupName;

    public int getSupplierId() {
        return SupplierId;
    }
    public void setSupplierId(int SupplierId) {
        this.SupplierId = SupplierId;
    }

    
    public String getSupName() {
        return SupName;
    }
    public void setSupName(String SupName) {
        this.SupName = SupName;
    }

    
    // Constructors
    public Supplier() {
        this.SupplierId = 0;
        this.SupName = "";
    }
     
    public Supplier(int SupplierId, String SupName) {
        this.SupplierId = SupplierId;
        this.SupName = SupName;
    }
      
}
