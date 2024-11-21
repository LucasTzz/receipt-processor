package receipt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import receipt.entity.Item;
import receipt.exception.ReceiptNotFoundException;
import receipt.exception.TotalPriceNotMatchException;
import receipt.repository.ReceiptRepository;
import receipt.entity.Receipt;

import java.time.LocalTime;
import java.util.UUID;

/**
 * receipt process services
 */
@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    /**
     * save receipt to db
     * @param receipt receipt
     * @return receipt
     */
    public Receipt saveReceipt(Receipt receipt) {
        double totalPrice = receipt.getItems().stream().mapToDouble(Item::getPrice).sum();
        if (totalPrice != receipt.getTotal()) {
            throw new TotalPriceNotMatchException();
        }
        receipt.setPoints(calculatePoints(receipt));
        return receiptRepository.save(receipt);
    }

    /**
     * get the receipt by id
     * @param id id
     * @return receipt
     */
    public Receipt getReceipt(UUID id) {
        return receiptRepository.findById(id).orElseThrow(() -> new ReceiptNotFoundException(id));
    }

    /**
     * calculate the points awarded by the receipt
     * @param receipt receipt
     * @return points
     */
    private int calculatePoints(Receipt receipt) {
        int points = 0;
        // One point for every alphanumeric character in the retailer name
        for (char c: receipt.getRetailer().toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                ++points;
            }
        }

        // 50 points if the total is a round dollar amount with no cents
        if (Math.floor(receipt.getTotal()) == receipt.getTotal()) {
            points += 50;
        }

        // 25 points if the total is a multiple of 0.25
        if (receipt.getTotal() * 4 % 1 == 0) {
            points += 25;
        }

        // 5 points for every two items on the receipt
        points += receipt.getItems().size() / 2 * 5;

        // If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer
        for (Item item: receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                points += (int) Math.ceil(item.getPrice() * 0.2);
            }
        }

        // 6 points if the day in the purchase date is odd
        if (receipt.getPurchaseDate().getDayOfMonth() % 2 == 1) {
            points += 6;
        }

        // 10 points if the time of purchase is after 2:00pm and before 4:00pm
        if (receipt.getPurchaseTime().isAfter(LocalTime.of(14, 0, 0))
                && receipt.getPurchaseTime().isBefore(LocalTime.of(16, 0, 0))) {
            points += 10;
        }

        return points;
    }
}
