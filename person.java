package airport;

public class person {
  private   String name;
    private String nathonalityId;
   private String nathonality;
   private int id;
    private static int count;
    public person(String name, String nathonalityId, String nathonality) {
        this.name = name;
        this.nathonalityId = nathonalityId;
        this.nathonality = nathonality;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNathonalityId() {
        return nathonalityId;
    }

    public void setNathonalityId(String nathonalityId) {
        this.nathonalityId = nathonalityId;
    }

    public String getNathonality() {
        return nathonality;
    }

    public void setNathonality(String nathonality) {
        this.nathonality = nathonality;
    }
    public void displayInfo(){
        System.out.println("the name :"+getName()+"the nathonality :"+getNathonality()+"the id nathonality is :"+getNathonalityId());
    }
}
