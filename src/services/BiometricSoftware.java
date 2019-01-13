package services;

import data.BiometricData;

/**
 * This interface describes the methods that would implement a Biometric Verifier.
 * Compares two BiometricData values an throws an exception if it fails.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface BiometricSoftware {

    void verifyBiometricData(BiometricData biometricData1, BiometricData biometricData2)
            throws BiometricVerificationFailedException;

}
