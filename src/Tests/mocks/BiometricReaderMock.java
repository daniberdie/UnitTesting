package Tests.mocks;

import data.BiometricData;
import services.BiometricReader;

/**
 * A basic implementation of MailerService which does nothing.
 * Used in some tests to test a normal, expected behaviour of a successful event.
 */
public class BiometricReaderMock implements BiometricReader {

    @Override
    public BiometricData readBiometricData() {
        return new BiometricData(5,6);
    }
}
