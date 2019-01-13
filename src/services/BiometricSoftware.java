package services;

import data.BiometricData;

public interface BiometricSoftware {

    boolean verifyBiometricData(BiometricData biometricData) throws BiometricVerificationFailedException;

}
