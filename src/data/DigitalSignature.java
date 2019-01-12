package data;

import java.util.Arrays;

public class DigitalSignature {

    private static final String ConstructorExceptionMsgNull = "Null array.";
    private static final String ConstructorExceptionMsgEmpty = "Empty array.";

    private final byte[] digitalSignature;

    public DigitalSignature(byte[] digitalSignature) {

        // Control null parameter
        if (digitalSignature == null) {
            throw new NullPointerException(ConstructorExceptionMsgNull);
        }

        // Check array is not empty
        if (digitalSignature.length == 0) {
            throw new IllegalArgumentException(ConstructorExceptionMsgEmpty);
        }

        this.digitalSignature = digitalSignature;
    }

    public byte[] getDigitalSignature() {
        return digitalSignature;
    }

    // region Overridden methods

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return Arrays.equals(digitalSignature, ((DigitalSignature) other).digitalSignature);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(digitalSignature);
    }

    @Override
    public String toString() {
        return "Digital Signature{" + "value='" + Arrays.toString(digitalSignature) + '\'' + '}';
    }

    // endregion
}
