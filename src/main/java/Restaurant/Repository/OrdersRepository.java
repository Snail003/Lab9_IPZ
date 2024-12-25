package Restaurant.Repository;

import Restaurant.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface that adds inbuilt functions of JpaRepository.
 */

public interface OrdersRepository extends JpaRepository<Order,Long> {
}
