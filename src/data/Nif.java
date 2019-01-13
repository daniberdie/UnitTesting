package data;

/**
 * This class describes a ID of a voter.
 * This class is immutable.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public class Nif {

    private static final String CONSTRUCTOR_EXCEPTION_MSG_NULL = "Null string.";
    private static final String CONSTRUCTOR_EXCEPTION_MSG_NOT_NIF = "Not a NIF: ";

    private static final short NIF_LENGTH = 9;
    private static final short NIF_DIGIT_LENGTH = 8;

    private final String nif;

    public Nif(String nif) {

        // Control null parameter
        if (nif == null) {
            throw new NullPointerException(CONSTRUCTOR_EXCEPTION_MSG_NULL);
        }

        // Check length
        if(nif.length() != NIF_LENGTH)
        {
            throw new IllegalArgumentException(CONSTRUCTOR_EXCEPTION_MSG_NOT_NIF + nif);
        }

        // Check last character is letter
        if(!Character.isAlphabetic(nif.charAt(nif.length()-1)))
        {
            throw new IllegalArgumentException(CONSTRUCTOR_EXCEPTION_MSG_NOT_NIF + nif);
        }
        // Check first 8 characters are digits
        for (char c : nif.substring(0, NIF_DIGIT_LENGTH -1).toCharArray())
        {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException(CONSTRUCTOR_EXCEPTION_MSG_NOT_NIF + nif);
        }

        this.nif = nif;
    }

    public String getNif() {
        return nif;
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

        return nif.equals(((Nif) other).nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }

    @Override
    public String toString() {
        return "Nif{" + "value='" + nif + '\'' + '}';
    }

    // endregion
}
