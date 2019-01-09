package kiosk;

import data.Party;
import data.MailAddress;
import services.ElectoralOrganism;
import services.MailerService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

/**
 * Implements a simplification of Use Case: Emit eVote
 */
public class VotingKiosk {

    Set<Party> parties;
    VoteCounter voteCounter;
    ElectoralOrganism electoralOrganism;
    MailerService mailerService;

    public VotingKiosk() {
        voteCounter = new VoteCounter(parties);
    }

    public void setElectoralOrganism(ElectoralOrganism eO) {
        electoralOrganism = eO;
    }

    public void setMailerService(MailerService mService) {
        mailerService = mService;
    }

    public void vote(Party party) {

        // Check if the user can vote

        // Send the vote

        // Send the email

    }

    public void sendeReceipt(MailAddress address) {

    }

}
