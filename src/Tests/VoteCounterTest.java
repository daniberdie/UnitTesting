package Tests;

import data.Nif;
import data.Party;
import kiosk.VoteCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VoteCounterTest {

    private Party testParty = new Party("ERC");
    private Party testNonExistingParty = new Party("PACMA");
    private Party testNullVote = new Party(Party.NULL_VOTE);
    private Party testBlankVote = new Party(Party.BLANK_VOTE);

    private static VoteCounter testVoteCounter;
    private static Set<Party> testParties;

    @BeforeAll
    public static void initPartySet()
    {
        testParties = new HashSet<>();
        testParties.add(new Party("PP"));
        testParties.add(new Party("PSOE"));
        testParties.add(new Party("Ciudadanos"));
        testParties.add(new Party("Podemos"));
        testParties.add(new Party("ERC"));
        testParties.add(new Party("Vox"));
    }

    @BeforeEach
    public void initVoteCounter()
    {
        testVoteCounter = new VoteCounter(testParties);
    }

    // region Vote counting

    @Test
    void testCountParty() {
        testVoteCounter.countParty(testParty);
        assertEquals(1, testVoteCounter.getVotesFor(testParty));
    }

    @Test
    void testCountNull() {
        testVoteCounter.countNull();
        assertEquals(1, testVoteCounter.getNulls());
    }

    @Test
    void testCountBlank() {
        testVoteCounter.countBlank();
        assertEquals(1, testVoteCounter.getBlanks());
    }

    @Test
    void testGetTotal()
    {
        testVoteCounter.countParty(testParty);
        testVoteCounter.countNull();
        testVoteCounter.countBlank();
        assertEquals(3, testVoteCounter.getTotal());
    }

    // endregion

    // region Scrutinize all possibilities

    @Test
    void testScrutinizeParty() {
        testVoteCounter.scrutinize(testParty);
        assertEquals(1, testVoteCounter.getVotesFor(testParty));
    }

    @Test
    void testScrutinizeNull() {
        testVoteCounter.scrutinize(testNullVote);
        assertEquals(1, testVoteCounter.getNulls());
    }

    @Test
    void testScrutinizeBlank() {
        testVoteCounter.scrutinize(testBlankVote);
        assertEquals(1, testVoteCounter.getBlanks());
    }

    @Test
    void testScrutinizeNonExistingPartyThrowsException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    testVoteCounter.scrutinize(testNonExistingParty);
                }
        );
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    // endregion
}
