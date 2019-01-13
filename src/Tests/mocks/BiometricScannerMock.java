package Tests.mocks;

import services.BiometricScanner;

/**
 * A basic implementation of BiometricScannerMock which gives a predictable, constant result.
 * Used in some tests to test a normal, expected behaviour of a successful event.
 */
public class BiometricScannerMock implements BiometricScanner {
    @Override
    public long scanFace() {
        return 5;
    }

    @Override
    public long scanFingerprint() {
        return 6;
    }
}
