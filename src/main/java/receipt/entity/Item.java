package receipt.entity;

import jakarta.persistence.*;

/**
 * Entity class for Item that will store in the db
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortDescription;

    private double price;

    // foreign key
    @ManyToOne
    private Receipt receipt;

    public Item() {}

    public String getShortDescription() {
        return shortDescription;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "receipt.entity.Item{" + ", shortDescription='" + this.shortDescription + '\'' + ", price='" + this.price + '\'' + '}';
    }
}
