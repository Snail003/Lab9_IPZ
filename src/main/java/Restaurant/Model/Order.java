package Restaurant.Model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * A model that represents an order.
 */

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String time;
    private String listOfDishes;
    private String status = "Not Done";
}
