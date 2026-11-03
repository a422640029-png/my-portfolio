package airport;

public class travilar extends person {
    private String passbortId;
    private String finishedDate;
    private String destination;

    public travilar(String name, String nathonalityId, String nathonality, String passbortId, String finishedDate, String destination) {
        super(name, nathonalityId, nathonality);
        this.passbortId = passbortId;
        this.finishedDate = finishedDate;
        this.destination = destination;
    }

    public String getPassbortId() {
        return passbortId;
    }

    public void setPassbortId(String passbortId) {
        this.passbortId = passbortId;
    }

    public String getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(String finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("the passport id is :"+getPassbortId()+"the finishal dte is :"+getFinishedDate()+"the destination is :"+getDestination());
    }
}
