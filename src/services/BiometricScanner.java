package services;

/**
 * This interface describes the methods that would implement a Biometric Scanner.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface BiometricScanner {

    long scanFace();

    long scanFingerprint();

}
