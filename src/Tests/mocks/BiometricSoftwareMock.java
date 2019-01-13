package Tests.mocks;

import data.BiometricData;
import services.BiometricSoftware;
import services.BiometricVerificationFailedException;

/**
 * A basic implementation of BiometricSoftware which always returns as if everything works correctly..
 * Used in some tests to test a normal, expected behaviour of a successful event.
 */
public class BiometricSoftwareMock implements BiometricSoftware {
    @Override
    public void verifyBiometricData(BiometricData biometricData1, BiometricData biometricData2)
            throws BiometricVerificationFailedException {
        // Do nothing
    }
}
