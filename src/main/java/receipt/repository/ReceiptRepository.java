package receipt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import receipt.entity.Receipt;

import java.util.UUID;

public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {
}
