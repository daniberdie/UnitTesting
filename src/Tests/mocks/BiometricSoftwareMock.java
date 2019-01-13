package Tests.mocks;

import data.BiometricData;
import services.BiometricSoftware;
import services.BiometricVerificationFailedException;

public class BiometricSoftwareMock implements BiometricSoftware {
    @Override
    public void verifyBiometricData(BiometricData biometricData) throws BiometricVerificationFailedException {
        // Do nothing
    }
}
