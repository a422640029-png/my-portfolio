package airport;

public class Pilot extends employy {
  private int  flighthours;
    private  String    certificate;
    private  String    licence;

    public Pilot(String name, String nathonalityId, String nathonality, double salary, double rewards,int flighthours ,String certificate, String licence) {
        super(name, nathonalityId, nathonality, salary, rewards);
        this.flighthours = flighthours;
        this.certificate = certificate;
        this.licence = licence;
    }

    public int getFlighthours() {
        return flighthours;
    }

    public void setFlighthours(int flighthours) {
        this.flighthours = flighthours;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
    @Override
    public  void displayInfo(){
        super.displayInfo();
        System.out.println("the flight  hours is :"+getFlighthours()+"the cerifcate is :"+getCertificate()+"the licence is :"+getLicence());
    }
}
