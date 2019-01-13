package kiosk;

import data.BiometricData;
import data.Nif;
import data.Party;
import data.MailAddress;
import services.*;

/**
 * This class describes simplification of the Use Case "Emit eVote".
 * This class is immutable.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
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


    public void setBiometricScanner(BiometricScanner biometricScanner) {
        this.biometricScanner = biometricScanner;
    }

    public void setBiometricReader(BiometricReader biometricReader) {
        this.biometricReader = biometricReader;
    }

    public void setBiometricSoftware(BiometricSoftware biometricSoftware) {
        this.biometricSoftware = biometricSoftware;
    }

    // endregion

    public void vote(Party party) {
        voteCounter.countParty(party);
    }

    /**
     * A method to implement the use case of voting. This method represents the voting using Nif.
     * If the mail is null, means that the voter did not give it and thus the receipt will not be sent.
     *
     * @param party       The party to vote.
     * @param nif         The ID of the voter.
     * @param mailAddress The mail address. Can be null.
     * @throws VotingRightsFailedException Throws this exception if the voter cannot vote for any reason.
     */
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

    /**
     * A method to implement the use case of voting. This method represents the voting using biometric data.
     * Is an overload of votingProcess using Nif.
     * If the mail is null, means that the voter did not give it and thus the receipt will not be sent.
     *
     * @param party       The party to vote.
     * @param mailAddress The mail address. Can be null.
     */
    public void votingProcess(Party party, MailAddress mailAddress)
            throws BiometricVerificationFailedException {
        // Read biometric data from the scanner
        BiometricData biometricData1 = new BiometricData(biometricScanner.scanFace(), biometricScanner.scanFingerprint());

        // Get the biometric data read by some electronic passport devide
        BiometricData biometricData2 = biometricReader.readBiometricData();

        // Check if the user can vote
        if (!biometricSoftware.verifyBiometricData(biometricData1, biometricData2)) {
            throw new BiometricVerificationFailedException("Biometric verification failed.");
        }

        // Send the vote and invalidate the voter using the nif
        vote(party);

        // Send the email if the voter have provided it
        if (mailAddress != null) {
            sendeReceipt(mailAddress, party);
        }

        System.out.println("Vote accepted successfully.");

    }

    public void sendeReceipt(MailAddress address, Party party) {
        mailerService.send(address, electoralOrganism.askForDigitalSignature(party));
    }
}

