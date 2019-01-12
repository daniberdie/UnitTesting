package data;

public class Nif {

    private static final String ConstructorExceptionNull = "Null string.";
    private static final String ConstructorException = "Malformed NIF: ";

    private static final short NifLength = 9;
    private static final short NifDigitLength = 8;

    private final String nif;

    public Nif(String nif) {

        // Control null parameter
        if (nif == null) {
            throw new NullPointerException(ConstructorExceptionNull);
        }

        // Check length
        if(nif.length() != NifLength)
        {
            throw new IllegalArgumentException(ConstructorException + nif);
        }

        // Check last character is letter
        if(!Character.isAlphabetic(nif.charAt(nif.length()-1)))
        {
            throw new IllegalArgumentException(ConstructorException + nif);
        }
        // Check first 8 characters are digits
        for (char c : nif.substring(0, NifDigitLength-1).toCharArray())
        {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException(ConstructorException + nif);
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
