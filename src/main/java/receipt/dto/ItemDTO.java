package receipt.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * DTO used in request for process receipts API
 */
public class ItemDTO {

    // input validation
    @NotBlank
    @Pattern(regexp = "^[\\w\\s\\-]+$", message = "invalid item description format")
    private String shortDescription;

    @NotBlank
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "invalid price format")
    private String price;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
