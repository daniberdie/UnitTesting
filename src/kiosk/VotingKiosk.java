package kiosk;

import data.BiometricData;
import data.Nif;
import data.Party;
import data.MailAddress;
import services.*;

/**
 * Implements a simplification of Use Case: Emit eVote
 */
public class VotingKiosk {

    private VoteCounter voteCounter;
    private ElectoralOrganism electoralOrganism;
    private MailerService mailerService;

    private BiometricScanner biometricScanner;
    private BiometricReader biometricReader;
    private BiometricSoftware biometricSoftware;

    // region Constructors

    public VotingKiosk() {
        voteCounter = null;
    }

    public VotingKiosk(VoteCounter voteCounter) {
        this.voteCounter = voteCounter;
    }

    public VotingKiosk(VoteCounter voteCounter, ElectoralOrganism electoralOrganism, MailAddress mailAddress) {
        this.voteCounter = voteCounter;
    }

    // endregion

    // region Setters

    public void setElectoralOrganism(ElectoralOrganism eO) {
        electoralOrganism = eO;
    }

    public void setMailerService(MailerService mService) {
        mailerService = mService;
    }

    public void setVoteCounter(VoteCounter voteCounter) {
        this.voteCounter = voteCounter;
    }

    public void setBiometricReader(BiometricReader biometricReader) {

    }

    // endregion

    public void vote(Party party) {
        voteCounter.countParty(party);
    }

    public void votingProcess(Party party, Nif nif, MailAddress mailAddress)
            throws VotingRightsFailedException {
        // Check if the user can vote
        if (electoralOrganism.canVote(nif)) {

            // Send the vote and invalidate the voter using the nif
            vote(party);
            electoralOrganism.disableVoter(nif);

            // Send the email if the voter have provided it
            if (mailAddress != null) {
                sendeReceipt(mailAddress, party);
            }

            System.out.println("Vote accepted successfully.");
        }
        // Notify that the voter cannot vote
        else {
            throw new VotingRightsFailedException("This voter cannot vote.");
        }
    }

    public void votingProcess(Party party, MailAddress mailAddress) {
        // Read biometric data
        BiometricData biometricData = new BiometricData(biometricScanner.scanFace(), biometricScanner.scanFingerprint());
        try {
            // Check if the user can vote
            biometricSoftware.verifyBiometricData(biometricData);

            // Send the vote and invalidate the voter using the nif
            vote(party);

            // Send the email if the voter have provided it
            if (mailAddress != null) {
                sendeReceipt(mailAddress, party);
            }

            System.out.println("Vote accepted successfully.");
        } catch (BiometricVerificationFailedException e) {
            System.out.println("Biometric verification failed.");
        }
    }

    public void sendeReceipt(MailAddress address, Party party) {
        mailerService.send(address, electoralOrganism.askForDigitalSignature(party));
    }
}
