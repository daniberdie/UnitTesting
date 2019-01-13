package Tests.mocks;

import data.BiometricData;
import services.BiometricSoftware;
import services.BiometricVerificationFailedException;

/**
 * A basic implementation of BiometricSoftware which does nothing.
 * Used in some tests to test a normal, expected behaviour of a successful event.
 */
public class BiometricSoftwareMock implements BiometricSoftware {
    @Override
    public void verifyBiometricData(BiometricData biometricData) throws BiometricVerificationFailedException {
        // Do nothing
    }
}
