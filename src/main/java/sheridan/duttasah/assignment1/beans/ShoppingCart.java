package sheridan.duttasah.assignment1.beans;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="SHOPPINGCART")
@Table(name="SHOPPINGCART")
public class ShoppingCart {
    @Id
    @Column(name="UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private Double price;

    public ShoppingCart(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }



}