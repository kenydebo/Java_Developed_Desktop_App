/*
 * Purpose: Agent class for TravelExperts Database 
 * Author: Filmon Ghezehey
 * Date: August 2015
 */

package dbase;

public class Agent {

    // Fields 
    private int agentId;
    private String agtFirstName;
    private String agtLastName;
    private String agtMiddleInitial;
    private String agtBusPhone;
    private String agtEmail;
    private String agtPosition;
    private int agencyId;
    private String agentStatus;

    // Properties
    public int getAgentId() {
        return agentId;
    }
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
    public String getAgtFirstName() {
        return agtFirstName;
    }
    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }
    public String getAgtLastName() {
        return agtLastName;
    }
    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }
    public String getAgtMiddleInitial() {
        return agtMiddleInitial;
    }
    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial = agtMiddleInitial;
    }
    public String getAgtBusPhone() {
        return agtBusPhone;
    }
    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }
    public String getAgtEmail() {
        return agtEmail;
    }
    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }
    public String getAgtPosition() {
        return agtPosition;
    }
    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }
    public int getAgencyId() {
        return agencyId;
    }
    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }
    public String getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(String agentStatus) {
        this.agentStatus = agentStatus;
    }



    // Constructors
    public Agent()
    {
        agentId = 0;
        agtFirstName = "";
        agtLastName = "";
        agtMiddleInitial = "";
        agtBusPhone = "";
        agtEmail = "";
        agtPosition = "";
        agencyId = 0;
        agentStatus ="";
    }

    public Agent(int agentId, String agtFirstName, String agtLastName,
            String agtMiddleInitial, String agtBusPhone, String agtEmail,
            String agtPosition, int agencyId, String agentStatus)
    {
        this.agentId = agentId;
        this.agtFirstName = agtFirstName;
        this.agtLastName = agtLastName;
        this.agtMiddleInitial = agtMiddleInitial;
        this.agtBusPhone = agtBusPhone;
        this.agtEmail = agtEmail;
        this.agtPosition = agtPosition;
        this.agencyId = agencyId;
        this.agentStatus = agentStatus;
    }

    
  

}

