package data;

public class Nif {

    // TODO Control the arguments

    private final String nif;

    public Nif(String nif) {
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
