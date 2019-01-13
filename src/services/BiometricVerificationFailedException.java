package services;

/**
 * This class describes an exception thrown when a biometric verification fails.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public class BiometricVerificationFailedException extends Exception {

    public BiometricVerificationFailedException(String message) {
       super(message);
    }
}
