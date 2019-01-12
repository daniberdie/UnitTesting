package Tests.Mocks;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import services.ElectoralOrganism;

public class ElectoralOrganismEverythingValid implements ElectoralOrganism {

    @Override
    public boolean canVote(Nif nif) {
        // Always can vote
        return true;
    }

    @Override
    public void disableVoter(Nif nif) {
        // Do nothing
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) {
        // Return the party converted to bytes
        return new DigitalSignature(party.getName().getBytes());
    }
}
