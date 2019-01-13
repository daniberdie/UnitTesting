package Tests;

import data.DigitalSignature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitalSignatureTest {

    public static byte[] testEmptyArray;
    public static byte[] testArray;

    @BeforeAll
    public static void initDigitalSignatureTest()
    {
        testEmptyArray = new byte[0];
        testArray = new byte[1];
    }

    @Test
    public void testConstructorThrowsExceptionWithNullString() {

        Executable exception = () -> new DigitalSignature(null);

        assertThrows(NullPointerException.class, exception);
    }

    @Test
    public void testConstructorThrowsExceptionWithEmptyArray() {

        Executable exception = () -> new DigitalSignature(testEmptyArray);

        assertThrows(IllegalArgumentException.class, exception);
    }

    @Test
    public void testConstructorCreatesCorrectInstance() {

        DigitalSignature digitalSignature = new DigitalSignature(testArray);

        assertEquals(DigitalSignature.class, digitalSignature.getClass());
    }
}
