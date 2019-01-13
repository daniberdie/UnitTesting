package services;

public class BiometricVerificationFailedException extends Exception {

    private String message;

    public BiometricVerificationFailedException(String message) {
        this.message = message;
    }

}
