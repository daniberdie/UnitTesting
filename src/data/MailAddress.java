package data;

public class MailAddress {

    private static final String CONSTRUCTOR_EXCEPTION_MSG_NULL = "Null string.";
    private static final String CONSTRUCTOR_EXCEPTION_MSG_NOT_EMAIL = "Not an email.";

    private final String mailAddress;

    public MailAddress(String mailAddress) {

        // Control null parameter
        if (mailAddress == null) {
            throw new NullPointerException(CONSTRUCTOR_EXCEPTION_MSG_NULL);
        }
        // Is an actual email
        if(!mailAddress.contains("@"))
        {
            throw new IllegalArgumentException(CONSTRUCTOR_EXCEPTION_MSG_NOT_EMAIL);
        }
        // Is an actual domain
        if(!mailAddress.contains(".")) {
            throw new IllegalArgumentException(CONSTRUCTOR_EXCEPTION_MSG_NULL);
        }

        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    // region Overridden methods

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return mailAddress.equals(((MailAddress) other).mailAddress);
    }

    @Override
    public int hashCode() {
        return mailAddress.hashCode();
    }

    @Override
    public String toString() {
        return "Mail address{" + "value='" + mailAddress + '\'' + '}';
    }

    // endregion
}
