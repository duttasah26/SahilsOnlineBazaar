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
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private Double price;

    @Column(name="NOOFITEMS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noofitems;

    public Integer getNoofitems() {
        return noofitems;
    }
    public void setNoofitems(Integer noofitems) {
        this.noofitems = noofitems;
    }
}