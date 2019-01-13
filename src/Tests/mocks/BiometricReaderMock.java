package Tests.mocks;

import data.BiometricData;
import services.BiometricReader;

public class BiometricReaderMock implements BiometricReader {

    @Override
    public BiometricData readBiometricData() {
        return new BiometricData(5,6);
    }
}
