package kiosk;

/**
 * This class describes an exception thrown when a non valid voter tries to vote.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public class VotingRightsFailedException extends Exception {

    public VotingRightsFailedException(String message) {
        super(message);
    }
}
