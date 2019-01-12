package kiosk;

public class VotingRightsFailedException extends Exception {

    private String message;

    public VotingRightsFailedException(String message) {
        this.message = message;
    }
}
