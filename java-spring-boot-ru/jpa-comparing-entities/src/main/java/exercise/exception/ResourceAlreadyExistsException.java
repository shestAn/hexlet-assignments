package exercise.exception;

// BEGIN
public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }
}
// END
