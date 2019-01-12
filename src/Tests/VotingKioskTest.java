package Tests;

import Tests.Mocks.ElectoralOrganismEverythingValid;
import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import kiosk.VotingKiosk;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.ElectoralOrganism;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VotingKioskTest {

    private static VotingKiosk testVotingKiosk;
    private static Party testParty;
    private static Nif testingNif;
    private static MailAddress testMailAddress;
    private static ElectoralOrganism testElectoralOrganismEverythingOk;

    @BeforeAll
    public static void initElectoralOrganism()
    {
        testParty = new Party("AfD");
         testingNif = new Nif("49129125H");
        testMailAddress = new MailAddress("mail@mail.com");

        testVotingKiosk = new VotingKiosk();
        testElectoralOrganismEverythingOk = new ElectoralOrganismEverythingValid();

        testVotingKiosk.setElectoralOrganism(testElectoralOrganismEverythingOk);
    }

    @Test
    void testServerAnswers()
    {
        /*
        Executable exception = () -> {
            testVotingKiosk.vote(testParty, testingNif, testMailAddress, true);
        };
        */

        ElectoralOrganism electoralOrganismImpl = new ElectoralOrganism() {
            @Override
            public boolean canVote(Nif nif) {
                return true;
            }

            @Override
            public void disableVoter(Nif nif) {

            }

            @Override
            public DigitalSignature askForDigitalSignature(Party party) {
                return new DigitalSignature(party.getName().getBytes());
            }
        };

        
    }
}
