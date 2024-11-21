package receipt.exception;

import java.util.UUID;

/**
 * exception class for receipt not found error
 */
public class ReceiptNotFoundException extends RuntimeException {
     public ReceiptNotFoundException(UUID id) {
        super("Could not find receipt " + id);
    }
}
