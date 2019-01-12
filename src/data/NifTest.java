package data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class NifTest {

    @Test
    public void testConstructorThrowsExceptionWithNullString() {

        Executable exception = () -> new Nif(null);

        assertThrows(NullPointerException.class, exception, Party.CONSTRUCTOR_EXCEPTION);
    }

    @Test
    public void testConstructorThrowsExceptionWithWrongSizeString() {

        Executable exception = () -> new Nif("49236726BB");

        assertThrows(IllegalArgumentException.class, exception, Party.CONSTRUCTOR_EXCEPTION);
    }

    @Test
    public void testConstructorThrowsExceptionMalformedNif1() {

        Executable exception = () -> new Nif("492367260");

        assertThrows(IllegalArgumentException.class, exception, Party.CONSTRUCTOR_EXCEPTION);
    }

    @Test
    public void testConstructorThrowsExceptionMalformedNif2() {

        Executable exception = () -> new Nif("492B6726B");

        assertThrows(IllegalArgumentException.class, exception, Party.CONSTRUCTOR_EXCEPTION);
    }

    @Test
    public void testConstructorCreatesCorrectInstance() {

        Nif nif = new Nif("49236726Z");

        assertEquals(Nif.class, nif.getClass());
    }
}
