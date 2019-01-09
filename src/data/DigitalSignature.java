package data;

public class DigitalSignature {

    private final byte[] digitalSignature;

    public DigitalSignature(byte[] digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    public byte[] getDigitalSignature() {
        return digitalSignature;
    }
}
