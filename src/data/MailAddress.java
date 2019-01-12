package data;

public class MailAddress {

    private static final String ConstructorExceptionMsgNull = "Null string.";
    private static final String ConstructorExceptionMsgNotAnEmail = "Not an email.";

    private final String mailAddress;

    public MailAddress(String mailAddress) {

        // Control null parameter
        if (mailAddress == null) {
            throw new NullPointerException(ConstructorExceptionMsgNull);
        }
        // Is an actual email
        if(!mailAddress.contains("@"))
        {
            throw new IllegalArgumentException(ConstructorExceptionMsgNotAnEmail);
        }
        // Is an actual domain
        if(!mailAddress.contains(".")) {
            throw new IllegalArgumentException(ConstructorExceptionMsgNull);
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
