package airport;

public class flightAtendant extends employy {
    private String language;
    private int tripsNumbers;

    public flightAtendant(String name, String nathonalityId, String nathonality, double salary, double rewards, String language, int tripsNumbers) {
        super(name, nathonalityId, nathonality, salary, rewards);
        this.language = language;
        this.tripsNumbers = tripsNumbers;
    }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public int getTripsNumbers() { return tripsNumbers; }
    public void setTripsNumbers(int tripsNumbers) { this.tripsNumbers = tripsNumbers; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | اللغات: " + getLanguage() + " | عدد الرحلات: " + getTripsNumbers());
    }
}