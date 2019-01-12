package Tests.Mocks;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import services.ElectoralOrganism;

/**
 * A mock implementation of ElectoralOrganism which always returns as if everything works correctly.
 * Used in some tests to test a normal, expected behaviour of a successful event.
 */
public class ElectoralOrganismMock implements ElectoralOrganism {

    /**
     * Always returns true.
     * @param nif The nif of the voter.
     * @return Always true.
     */
    @Override
    public boolean canVote(Nif nif) {
        // Always can vote
        return true;
    }

    /**
     * Does nothing.
     * @param nif The nif of the voter.
     */
    @Override
    public void disableVoter(Nif nif) {
        // Do nothing
    }

    /**
     * Returns a "random" DigitalSignature.
     * @param party The party which the voter voted.
     * @return A DigitalSignature created using the byte value of Party.
     */
    @Override
    public DigitalSignature askForDigitalSignature(Party party) {
        // Return the party converted to bytes
        return new DigitalSignature(party.getName().getBytes());
    }
}
