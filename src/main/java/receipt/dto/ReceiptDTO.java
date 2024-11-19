package receipt.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.List;


public class ReceiptDTO {

    @NotBlank(message = "retailer cannot be blank")
    @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "invalid retailer format")
    private String retailer;

    @NotBlank(message = "purchase date cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "invalid date format")
    private String purchaseDate;

    @NotBlank(message = "purchase time cannot be blank")
    @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]$", message = "invalid time format")
    private String purchaseTime;

    @NotEmpty
    @Valid
    private List<ItemDTO> items;

    @NotBlank(message = "total price cannot be blank.")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "invalid price format")
    private String total;

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
