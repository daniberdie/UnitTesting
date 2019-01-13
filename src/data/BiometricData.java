package data;

public class BiometricData {

    private final long facialKey;
    private final long fingerprintKey;

    public BiometricData(long facialKey, long fingerprintKey)
    {
        this.facialKey = facialKey;
        this.fingerprintKey = fingerprintKey;
    }

    public long getFacialKey() {
        return facialKey;
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

        return facialKey == ((BiometricData)other).facialKey &&
                fingerprintKey == ((BiometricData)other).fingerprintKey;
    }

    @Override
    public String toString() {
        return "BiometricData{" + "facial key='" + facialKey + ", fingerprint key='" + fingerprintKey + '\'' + '}';
    }

    // endregion
}
