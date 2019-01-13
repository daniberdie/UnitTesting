package services;

import data.BiometricData;

public interface BiometricSoftware {

    void verifyBiometricData(BiometricData biometricData) throws BiometricVerificationFailedException;

}
