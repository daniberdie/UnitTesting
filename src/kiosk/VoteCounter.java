package kiosk;

import data.Party;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Set;

/**
 * A class that represents the result in an election site
 */
public class VoteCounter {

    private int nullVotes = 0;
    private int blankVotes = 0;
    private HashMap<String,Integer> partyVotes;

    public VoteCounter(Set<Party> validParties) {

        // Initialize the map with the parties, all starting from 0
        partyVotes = new HashMap<>();
        for(Party party: validParties)
        {
            partyVotes.put(party.getName(), 0);
        }
    }

    public void countParty(Party party) {
        partyVotes.put(
                party.getName(),
                partyVotes.get(party.getName()) + 1);
    }

    public void countNull() {
        nullVotes+=1;
    }

    public void countBlank() {
        blankVotes+=1;
    }

    public void scrutinize(Party party) {

    }

    // region Getters

    public int getVotesFor(Party party) {
        throw new NotImplementedException();
    }

    public int getNulls() {
        throw new NotImplementedException();
    }

    public int getBlanks() {
        throw new NotImplementedException();
    }

    public int getTotal() {
        throw new NotImplementedException();
    }

    // endregion
}
