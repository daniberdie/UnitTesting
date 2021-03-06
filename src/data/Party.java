package data;

/**
 * This class describes the name of a party that participates in an election.
 * This class is immutable.
 *
 * @author Daniel Berdie Pardo
 * @version 1.0 13 Jan 2018
 */
public class Party {

    public static final String CONSTRUCTOR_EXCEPTION_MSG_NULL = "Null name string not allowed.";

    public static final String NULL_VOTE = "null";
    public static final String BLANK_VOTE = "";

    private final String name;

    public Party(String name) {

        // Control null parameter
        if (name == null) {
            throw new NullPointerException(CONSTRUCTOR_EXCEPTION_MSG_NULL);
        }

        this.name = name;
    }

    public String getName() {
        return name;
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

        return name.equals(((Party) other).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Party{" + "name='" + name + '\'' + '}';
    }

    // endregion
}
