package services;

import data.BiometricData;

/**
 * This interface describes the methods that would implement a Biometric Reader.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface BiometricReader {

    // TODO Consider the eNif or electronic passport
    BiometricData readBiometricData();

}
