package Tests;

import Tests.mocks.ElectoralOrganismMock;
import Tests.mocks.MailerServiceMock;
import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import kiosk.VoteCounter;
import kiosk.VotingKiosk;
import kiosk.VotingRightsFailedException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.ElectoralOrganism;
import services.MailerService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VotingKioskTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static VotingKiosk testVotingKiosk;
    private static VoteCounter testVoteCounter;

    private static Party testParty;
    private static Nif testingNif;
    private static MailAddress testMailAddress;

    private static Set<Party> testParties;

    @BeforeAll
    public static void initTest() {
        System.setOut(new PrintStream(outContent));

        testParties = new HashSet<>();
        testParties.add(new Party("PP"));
        testParties.add(new Party("PSOE"));
        testParties.add(new Party("Ciudadanos"));
        testParties.add(new Party("Podemos"));
        testParties.add(new Party("ERC"));
        testParties.add(new Party("Vox"));
        testVoteCounter = new VoteCounter(testParties);

        testParty = new Party("PP");
        testingNif = new Nif("49129125H");
        testMailAddress = new MailAddress("mail@mail.com");

        testVotingKiosk = new VotingKiosk();
        testVotingKiosk.setVoteCounter(testVoteCounter);
    }

    @Test
    void testVoteCorrectly() {

        testVotingKiosk.setElectoralOrganism(new ElectoralOrganismMock());
        testVotingKiosk.setMailerService(new MailerServiceMock());

        try {
            testVotingKiosk.votingProcess(testParty, testingNif, testMailAddress, true);
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

        Throwable exception = assertThrows(VotingRightsFailedException.class,
                () -> {
                    testVotingKiosk.votingProcess(testParty, testingNif, testMailAddress, true);
                }
        );
        assertEquals(VotingRightsFailedException.class, exception.getClass());
    }
}
