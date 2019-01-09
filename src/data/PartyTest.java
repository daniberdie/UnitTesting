package data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PartyTest {

    @Test
    public void testConstructorThrowsExceptionWithNullString() {

        Executable exception = () -> new Party(null);

        assertThrows(IllegalArgumentException.class, exception, Party.CONSTRUCTOR_EXCEPTION);
    }
}
