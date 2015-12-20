
/**Author: Filmon Ghezehey
 * Date: Oct-07-2015
 * Purpose: Agency Class
 *
 * @author 654556
 */

package dbase;
public class Agency
{
     private int AgencyId;
     private String AgncyAddress;
     private String AgncyCity;
     private String AgncyProv;
     private String AgncyPostal;
     private String AgncyCountry;
     private String AgncyPhone;
     private String AgncyFax;

    public int getAgencyId() {
        return AgencyId;
    }

    public String getAgncyAddress() {
        return AgncyAddress;
    }

    public String getAgncyCity() {
        return AgncyCity;
    }

    public String getAgncyProv() {
        return AgncyProv;
    }

    public String getAgncyPostal() {
        return AgncyPostal;
    }

    public String getAgncyCountry() {
        return AgncyCountry;
    }

    public String getAgncyPhone() {
        return AgncyPhone;
    }

    public String getAgncyFax() {
        return AgncyFax;
    }

    public void setAgencyId(int AgencyId) {
        this.AgencyId = AgencyId;
    }

    public void setAgncyAddress(String AgncyAddress) {
        this.AgncyAddress = AgncyAddress;
    }

    public void setAgncyCity(String AgncyCity) {
        this.AgncyCity = AgncyCity;
    }

    public void setAgncyProv(String AgncyProv) {
        this.AgncyProv = AgncyProv;
    }

    public void setAgncyPostal(String AgncyPostal) {
        this.AgncyPostal = AgncyPostal;
    }

    public void setAgncyCountry(String AgncyCountry) {
        this.AgncyCountry = AgncyCountry;
    }

    public void setAgncyPhone(String AgncyPhone) {
        this.AgncyPhone = AgncyPhone;
    }

    public void setAgncyFax(String AgncyFax) {
        this.AgncyFax = AgncyFax;
    }

    public Agency(int AgencyId, String AgncyAddress, String AgncyCity, 
            String AgncyProv, String AgncyPostal, String AgncyCountry,
            String AgncyPhone, String AgncyFax)
    {
        this.AgencyId = AgencyId;
        this.AgncyAddress = AgncyAddress;
        this.AgncyCity = AgncyCity;
        this.AgncyProv = AgncyProv;
        this.AgncyPostal = AgncyPostal;
        this.AgncyCountry = AgncyCountry;
        this.AgncyPhone = AgncyPhone;
        this.AgncyFax = AgncyFax;
    }

    public Agency() {
        this.AgencyId = -1;
        this.AgncyAddress = "";
        this.AgncyCity = "";
        this.AgncyProv = "";
        this.AgncyPostal = "";
        this.AgncyCountry = "";
        this.AgncyPhone = "";
        this.AgncyFax = "";
        
    }
    
}
