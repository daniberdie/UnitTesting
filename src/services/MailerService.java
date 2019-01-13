package services;

import data.MailAddress;
import data.DigitalSignature;

/**
 * This interface describes the methods that would implement
 * an external service for sending mails.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public interface MailerService {

    void send(MailAddress address, DigitalSignature signature);

}
