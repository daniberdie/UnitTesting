package kiosk;

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

    private VoteCounter voteCounter;
    private ElectoralOrganism electoralOrganism;
    private MailerService mailerService;

    public void setElectoralOrganism(ElectoralOrganism eO) {
        electoralOrganism = eO;
    }

    public void setMailerService(MailerService mService) {
        mailerService = mService;
    }

    public void setVoteCounter(VoteCounter voteCounter)
    {
        this.voteCounter = voteCounter;
    }

    public void vote(Party party) {
        voteCounter.countParty(party);
    }

    public void votingProcess(Party party, Nif nif, MailAddress mailAddress, boolean wantsReceipt)
            throws VotingRightsFailedException {
        // Check if the user can vote
        if (electoralOrganism.canVote(nif)) {

            // Send the vote and invalidate the voter using the nif
            vote(party);
            electoralOrganism.disableVoter(nif);

            // Send the email if the voter wants
            if (wantsReceipt) {
                sendeReceipt(mailAddress, party);
            }
            System.out.println("Vote accepted successfully.");
        }
        // Notify that the voter cannot vote
        else {
            throw new VotingRightsFailedException("This voter cannot vote.");
        }
    }

    public void sendeReceipt(MailAddress address, Party party) {
        mailerService.send(address, electoralOrganism.askForDigitalSignature(party));
    }
}
