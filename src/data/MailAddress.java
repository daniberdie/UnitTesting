package data;

public class MailAddress {

    // TODO Control the arguments

    private final String mailAddress;

    public MailAddress(String mailAddress) {
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
