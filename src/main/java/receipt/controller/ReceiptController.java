package receipt.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import receipt.dto.PointsDTO;
import receipt.dto.ReceiptDTO;
import receipt.dto.ReceiptIdDTO;
import receipt.entity.Receipt;
import receipt.service.ReceiptService;
import receipt.util.Convertor;

import java.util.UUID;

/**
 * API endpoints
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/process")
    ReceiptIdDTO newReceipt(@Valid @RequestBody ReceiptDTO newReceiptDTO) {
        Receipt newReceipt = Convertor.convertToReceipt(newReceiptDTO);
        Receipt receipt = receiptService.saveReceipt(newReceipt);
        ReceiptIdDTO receiptIdDTO = new ReceiptIdDTO();
        receiptIdDTO.setId(receipt.getId());
        return receiptIdDTO;
    }

    @GetMapping("/{id}/points")
    PointsDTO getPoints(@PathVariable UUID id) {
        Receipt receipt = receiptService.getReceipt(id);
        PointsDTO pointsDTO = new PointsDTO();
        pointsDTO.setPoints(receipt.getPoints());
        return pointsDTO;
    }
}
