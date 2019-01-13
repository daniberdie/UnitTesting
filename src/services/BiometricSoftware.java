package services;

import data.BiometricData;

/**
 * This interface describes the methods that would implement a Biometric Verifier.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface BiometricSoftware {

    void verifyBiometricData(BiometricData biometricData) throws BiometricVerificationFailedException;

}
