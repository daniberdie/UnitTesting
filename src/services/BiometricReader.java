package services;

import data.BiometricData;
import data.Nif;

/**
 * This interface describes the methods that would implement a Biometric Reader.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface BiometricReader {

    BiometricData readBiometricData();

}
