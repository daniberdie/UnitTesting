package data;

/**
 * The name of a party that participates in an election.
 */
public class Party {

    private final String name;

    public Party(String name) {

        // Control null parameter
        if(name == null)
        {
            throw new IllegalArgumentException("Null name string not allowed.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return name.equals(((Party)other).name);
    }
}
