package Tests.mocks;

import services.BiometricScanner;

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
