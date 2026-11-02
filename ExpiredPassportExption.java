package airport;

public class ExpiredPassportExption extends Exception {
    public ExpiredPassportExption(String message) {
        super(message);
    }
}
