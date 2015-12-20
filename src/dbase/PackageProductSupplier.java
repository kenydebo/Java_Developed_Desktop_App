/*
 * Purpose: PackageProductSupplier class for TravelExperts Database 
 * Author: 
 * Date: August 2015
 */

package dbase;

/**
 * //Zahra
 * @author 696210
 */
public class PackageProductSupplier {
    
    // Fields
    private int packageId;
    private int productSupplierId;
   
    
    // Properties
    public int getPackageId() {
        return packageId;
    }
    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }
    public int getProductSupplierId() {
        return productSupplierId;
    }
    public void setProductSupplierId(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }
    
    
    // Constructors
    public PackageProductSupplier() {
        this.packageId = 0;
        this.productSupplierId = 0;
    }

    public PackageProductSupplier(int packageId, int productSupplierId) {
        this.packageId = packageId;
        this.productSupplierId = productSupplierId;        
    }
    

}