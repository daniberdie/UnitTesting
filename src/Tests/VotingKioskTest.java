package Tests;

import Tests.mocks.*;
import data.*;
import kiosk.VoteCounter;
import kiosk.VotingKiosk;
import kiosk.VotingRightsFailedException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VotingKioskTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static VotingKiosk testVotingKiosk;

    private static Party testParty;
    private static Nif testingNif;
    private static MailAddress testMailAddress;

    @BeforeAll
    public static void initTest() {
        System.setOut(new PrintStream(outContent));

        Set<Party> testParties = new HashSet<>();
        testParties.add(new Party("PP"));
        testParties.add(new Party("PSOE"));
        testParties.add(new Party("Ciudadanos"));
        testParties.add(new Party("Podemos"));
        testParties.add(new Party("ERC"));
        testParties.add(new Party("Vox"));
        VoteCounter testVoteCounter = new VoteCounter(testParties);

        testParty = new Party("PP");
        testingNif = new Nif("49129125H");
        testMailAddress = new MailAddress("mail@mail.com");

        testVotingKiosk = new VotingKiosk();
        testVotingKiosk.setVoteCounter(testVoteCounter);
    }

    @BeforeEach
    public void clearOutContent() {
        // Reset the outputStream to avoid reading duplicities
        outContent.reset();
    }

    @Test
    void testVoteCorrectly() {

        testVotingKiosk.setElectoralOrganism(new ElectoralOrganismMock());
        testVotingKiosk.setMailerService(new MailerServiceMock());

        try {
            testVotingKiosk.votingProcess(testParty, testingNif, testMailAddress);
        } catch (VotingRightsFailedException e) {
            e.printStackTrace();
        }

        assertEquals("Vote accepted successfully.\n", outContent.toString());
    }

    @Test
    void testVotingWithDisabledNif() {

        ElectoralOrganism electoralOrganismImpl = new ElectoralOrganism() {
            @Override
            public boolean canVote(Nif nif) {
                return false;
            }

            @Override
            public void disableVoter(Nif nif) {
                // Do nothing
            }

            @Override
            public DigitalSignature askForDigitalSignature(Party party) {
                return new DigitalSignature(party.getName().getBytes());
            }
        };

        MailerService mailerServiceImpl = new MailerService() {
            @Override
            public void send(MailAddress address, DigitalSignature signature) {
                // Do nothing
            }
        };

        testVotingKiosk.setElectoralOrganism(electoralOrganismImpl);
        testVotingKiosk.setMailerService(mailerServiceImpl);

        assertThrows(VotingRightsFailedException.class,
                () -> testVotingKiosk.votingProcess(testParty, testingNif, testMailAddress));
    }

    @Test
    void testVotingBiometric() {

        testVotingKiosk.setBiometricScanner(new BiometricScannerMock());
        testVotingKiosk.setBiometricReader(new BiometricReaderMock());
        testVotingKiosk.setBiometricSoftware(new BiometricSoftwareMock());

        try {
            testVotingKiosk.votingProcess(testParty, testingNif, testMailAddress);
        } catch (VotingRightsFailedException e) {
            e.printStackTrace();
        }

        assertEquals("Vote accepted successfully.\n", outContent.toString());
    }

    @Test
    void testVotingBiometricFailure() {

        BiometricSoftware biometricSoftwareImpl = new BiometricSoftware() {
            @Override
            public boolean verifyBiometricData(BiometricData biometricData1, BiometricData biometricData2) {
                return false;
            }
        };

        testVotingKiosk.setBiometricScanner(new BiometricScannerMock());
        testVotingKiosk.setBiometricReader(new BiometricReaderMock());
        testVotingKiosk.setBiometricSoftware(biometricSoftwareImpl);
        testVotingKiosk.setMailerService(new MailerServiceMock());

        assertThrows(BiometricVerificationFailedException.class,
                () -> testVotingKiosk.votingProcess(testParty, testMailAddress));
    }
}
