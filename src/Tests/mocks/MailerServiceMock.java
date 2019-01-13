package Tests.mocks;

import data.DigitalSignature;
import data.MailAddress;
import services.MailerService;

/**
 * A basic implementation of MailerService which does nothing.
 * Used in some tests to test a normal, expected behaviour of a successful event.
 */
public class MailerServiceMock implements MailerService {

    public boolean hasBeenCalled = false;

    /**
     * Does literally nothing.
     * @param address The address to send the hypothetical email.
     * @param signature The unused required signature.
     */
    @Override
    public void send(MailAddress address, DigitalSignature signature) {
        hasBeenCalled = true;
    }
}
