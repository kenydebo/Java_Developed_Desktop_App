/*
 * Purpose: ProductSupplier class for TravelExperts Database 
 * Author: 
 * Date: August 2015
 */
package dbase;

public class ProductSupplier {
    

    // Fields & Properties
    private int productSupplierId;
    private int productId;
    private int supplierId;

    public int getProductSupplierId() {
        return productSupplierId;
    }
    public void setProductSupplierId(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }


    // Constructors
    public ProductSupplier()
    {
        this.productSupplierId = 0;
        this.productId = 0;
        this.supplierId = 0;
    }

    public ProductSupplier(int productSupplierId, int productId, int supplierId) {
        this.productSupplierId = productSupplierId;
        this.productId = productId;
        this.supplierId = supplierId;
    }
    
    
}
