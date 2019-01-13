package Tests;

import data.MailAddress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MailAddressTest {

    @Test
    public void testConstructorThrowsExceptionWithNullString() {

        Executable exception = () -> new MailAddress(null);

        assertThrows(NullPointerException.class, exception);
    }

    @Test
    public void testConstructorThrowsExceptionWithNoAtSymbol() {

        Executable exception = () -> new MailAddress("test.mail.de");

        assertThrows(IllegalArgumentException.class, exception);
    }

    @Test
    public void testConstructorThrowsExceptionWithNoDomain() {

        Executable exception = () -> new MailAddress("test@mail");

        assertThrows(IllegalArgumentException.class, exception);
    }

    @Test
    public void testConstructorCreatesCorrectInstance() {

        MailAddress testMail = new MailAddress("test@gmail.de");

        assertEquals(MailAddress.class, testMail.getClass());
    }
}
