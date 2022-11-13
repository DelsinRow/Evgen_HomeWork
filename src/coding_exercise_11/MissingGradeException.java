package coding_exercise_11;

public class MissingGradeException extends Exception {

    public MissingGradeException() {
    }

    public MissingGradeException(String message) {
        super(message);
    }

    public MissingGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingGradeException(Throwable cause) {
        super(cause);
    }

    public MissingGradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
