/*
 * Purpose: Product class for TravelExperts Database 
 * Author: 
 * Date: August 2015
 */

package dbase;


/**
 * //Zahra
 * @author 696210
 */
public class Product {
    
    
    // Fields & Properties
    private int productId;
    private String prodName;

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    // Constructors
    public Product()
    {
        productId = 0;
        prodName = "";
    }
    
    public Product(int productId, String prodName) {
        this.productId = productId;
        this.prodName = prodName;
    }
     
}
