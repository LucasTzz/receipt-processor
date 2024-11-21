package receipt.exception;

/**
 * Exception class for total price not match
 */
public class TotalPriceNotMatchException extends RuntimeException {
    public TotalPriceNotMatchException() {
        super("Receipt total price not match");
    }
}
