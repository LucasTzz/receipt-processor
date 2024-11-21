package receipt.dto;

import java.util.UUID;

/**
 * DTO used in response for process receipts API
 */
public class ReceiptIdDTO {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
