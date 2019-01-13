package kiosk;

import data.Party;

import java.util.HashMap;
import java.util.Set;

/**
 * This class describes the result in an election site.
 * This class is immutable.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public class VoteCounter {

    private static final String EXCEPTION_MSG_NON_EXISTING_PARTY = "This party does not exist.";


    private int nullVotes = 0;
    private int blankVotes = 0;
    private HashMap<Party, Integer> partyVotes;

    public VoteCounter(Set<Party> validParties) {

        // Initialize the map with the parties, all starting from 0 votes
        partyVotes = new HashMap<>();
        for (Party party : validParties) {
            partyVotes.put(party, 0);
        }
    }

    public void countParty(Party party) {
        // Control that the party exists
        if (!partyVotes.containsKey(party))
        {
            throw new IllegalArgumentException(EXCEPTION_MSG_NON_EXISTING_PARTY);
        }
        partyVotes.put(party, partyVotes.get(party) + 1);
    }

    public void countNull() {
        nullVotes += 1;
    }

    public void countBlank() {
        blankVotes += 1;
    }

    public void scrutinize(Party party) {

        switch (party.getName()) {
            // Null vote
            case Party.NULL_VOTE:
                countNull();
                break;
            // Blank vote
            case Party.BLANK_VOTE:
                countBlank();
                break;
            // Valid vote, count corresponding party
            default:
                countParty(party);
                break;
        }
    }

    // region Getters

    public int getVotesFor(Party party) {
        return partyVotes.get(party);
    }

    public int getNulls() {
        return nullVotes;
    }

    public int getBlanks() {
        return blankVotes;
    }

    public int getTotal() {
        // Sum the total votes of every party
        int total = 0;
        for (Party party : partyVotes.keySet()) {
            total += getVotesFor(party);
        }
        // Return the party votes, plus the nulls and blanks
        return total + getNulls() + getBlanks();
    }

    // endregion
}
