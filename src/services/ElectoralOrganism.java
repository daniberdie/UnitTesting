package services;

import data.Party;
import data.Nif;
import data.DigitalSignature;

/**
 * This interface describes the methods that would implement
 * an external service for signing votes and manage the electoral roll.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface ElectoralOrganism {

    boolean canVote(Nif nif);

    void disableVoter(Nif nif);

    DigitalSignature askForDigitalSignature(Party party);

}
