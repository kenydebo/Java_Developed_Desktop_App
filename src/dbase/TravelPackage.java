
package dbase;

import java.util.Date;

/**
 * Zahra
 * @author 696210
 */
public class TravelPackage 
{
    //fields
    private int PackageId;
    private String PkgName;
    private Date PkgStartDate; 
    private Date PkgEndDate;
    private String PkgDesc;
    private double PkgBasePrice;
    private double PkgAgencyCommission;

    
    //properties
    public int getPackageId() 
    {
        return PackageId;
    }
    public void setPackageId(int PackageId) 
    {
        this.PackageId = PackageId;
    }


    public String getPkgName() {
        return PkgName;
    }
    public void setPkgName(String PkgName) {
        this.PkgName = PkgName;
    }

    
    public String getPkgDesc() {
        return PkgDesc;
    }
    public void setPkgDesc(String PkgDesc) {
        this.PkgDesc = PkgDesc;
    }

    
    public double getPkgBasePrice() {
        return PkgBasePrice;
    }
    public void setPkgBasePrice(double PkgBasePrice) {
        this.PkgBasePrice = PkgBasePrice;
    }


    public double getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }
    public void setPkgAgencyCommission(double PkgAgencyCommission) {
        this.PkgAgencyCommission = PkgAgencyCommission;
    }


    public Date getPkgStartDate() {
        return PkgStartDate;
    }
    public void setPkgStartDate(Date PkgStartDate) {
        this.PkgStartDate = PkgStartDate;
    }


    public Date getPkgEndDate() {
        return PkgEndDate;
    }
    public void setPkgEndDate(Date PkgEndDate) {
        this.PkgEndDate = PkgEndDate;
    }
    
    //constructor
    public TravelPackage()
    {
        PackageId = 0;
        PkgName = "";
        PkgStartDate = null; 
        PkgEndDate = null ;
        PkgDesc = "";
        PkgBasePrice = 0.00;
        PkgAgencyCommission = 0.00;
    }
    
    public TravelPackage(int pID, String pName, Date pStartDate, Date pEndDate, String pDesc, 
                   double pBasePrice, double pAgencyCommission)
    {
        PackageId = pID;
        PkgName = pName;
        PkgStartDate = pStartDate;
        PkgEndDate = pEndDate;
        PkgDesc = pDesc;
        PkgBasePrice = pBasePrice;
        PkgAgencyCommission = pAgencyCommission;
    }
    
    // Constructor used to create a clone of a TravelPackage
    public TravelPackage(TravelPackage travelPackage)
    {
        this.PackageId = travelPackage.PackageId;
        this.PkgName = travelPackage.PkgName;
        this.PkgStartDate = travelPackage.PkgStartDate;
        this.PkgEndDate = travelPackage.PkgEndDate;
        this.PkgDesc = travelPackage.PkgDesc;
        this.PkgBasePrice = travelPackage.PkgBasePrice;
        this.PkgAgencyCommission = travelPackage.PkgAgencyCommission;
    }
}

