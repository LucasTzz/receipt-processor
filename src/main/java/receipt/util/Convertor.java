package receipt.util;

import receipt.dto.ItemDTO;
import receipt.dto.ReceiptDTO;
import receipt.entity.Item;
import receipt.entity.Receipt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Convertor {

    /**
     * convert to Receipt object and convert types of fields
     * @param receiptDTO receiptDTO
     * @return receipt
     */
    public static Receipt convertToReceipt(ReceiptDTO receiptDTO) {
        Receipt receipt = new Receipt();
        receipt.setRetailer(receiptDTO.getRetailer());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        receipt.setPurchaseDate(LocalDate.parse(receiptDTO.getPurchaseDate(), dateFormatter));

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        receipt.setPurchaseTime(LocalTime.parse(receiptDTO.getPurchaseTime(), timeFormatter));

        receipt.setTotal(Double.parseDouble(receiptDTO.getTotal()));
        List<Item> items = receiptDTO.getItems().stream().map(Convertor::convertToItem).toList();
        receipt.setItems(items);
        return receipt;
    }

    /**
     * convert to Item object
     * @param itemDTO itemDTO
     * @return item
     */
    private static Item convertToItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setShortDescription(itemDTO.getShortDescription());
        item.setPrice(Double.parseDouble(itemDTO.getPrice()));
        return item;
    }
}
