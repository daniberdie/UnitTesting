package services;

import data.Party;
import data.Nif;
import data.DigitalSignature;

/**
 * External service for signing votes and manage the electoral roll
 */
public interface ElectoralOrganism {

    boolean canVote(Nif nif);
    void disableVoter(Nif nif);
    DigitalSignature askForDigitalSignature(Party party);

}
