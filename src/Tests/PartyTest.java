package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import data.Party;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PartyTest {

    @Test
    public void testConstructorThrowsExceptionWithNullString() {

        Executable exception = () -> new Party(null);

        assertThrows(NullPointerException.class, exception, Party.CONSTRUCTOR_EXCEPTION_MSG_NULL);
    }
}
