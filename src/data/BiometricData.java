package data;

public class BiometricData {

    private final long faceKey;
    private final long fingerprintKey;

    public BiometricData(long facialKey, long fingerprintKey)
    {
        this.faceKey = facialKey;
        this.fingerprintKey = fingerprintKey;
    }

    public long getFaceKey() {
        return faceKey;
    }

    public long getFingerprintKey() {
        return fingerprintKey;
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

        return faceKey == ((BiometricData)other).faceKey &&
                fingerprintKey == ((BiometricData)other).fingerprintKey;
    }

    @Override
    public String toString() {
        return "BiometricData{" + "facial key='" + faceKey + ", fingerprint key='" + fingerprintKey + '\'' + '}';
    }

    // endregion
}
