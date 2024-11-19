package receipt.exception;

import java.util.UUID;

public class ReceiptNotFoundException extends RuntimeException {
     public ReceiptNotFoundException(UUID id) {
        super("Could not find receipt " + id);
    }
}
