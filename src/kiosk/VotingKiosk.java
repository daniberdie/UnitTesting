package kiosk;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import data.MailAddress;
import services.ElectoralOrganism;
import services.MailerService;

import java.util.Set;

/**
 * Implements a simplification of Use Case: Emit eVote
 */
public class VotingKiosk {

    private Set<Party> parties;
    private VoteCounter voteCounter;
    private ElectoralOrganism electoralOrganism;
    private MailerService mailerService;

    public VotingKiosk() {
        voteCounter = new VoteCounter(parties);
    }

    public void setElectoralOrganism(ElectoralOrganism eO) {
        electoralOrganism = eO;
    }

    public void setMailerService(MailerService mService) {
        mailerService = mService;
    }

    public void vote(Party party, Nif nif, MailAddress mailAddress, boolean wantsReceipt) {

        // Check if the user can vote
        if (electoralOrganism.canVote(nif)) {

            // Send the vote and invalidate the voter using the nif
            voteCounter.countParty(party);
            electoralOrganism.disableVoter(nif);

            // Send the email if the voter wants
            if (wantsReceipt) {
                sendeReceipt(mailAddress, electoralOrganism.askForDigitalSignature(party));
            }
            System.out.println("Everything OK dude.");
        }
        // Notify that the voter cannot vote
        else {
            throw new IllegalStateException("This voter cannot vote again.");
        }
    }

    public void sendeReceipt(MailAddress address, DigitalSignature digitalSignature) {
        mailerService.send(address, digitalSignature);
    }
}
