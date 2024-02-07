package sheridan.duttasah.assignment1.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="ShoppingCart")
public class ShoppingCart {
    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private Double price;

}