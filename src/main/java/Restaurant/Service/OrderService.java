package Restaurant.Service;

import Restaurant.Model.Order;
import Restaurant.Repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service class that is responsible for logic and working with database.
 */

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    /**
     * Returns all orders in database.
     */

    public List<Order> findAll(){
        return ordersRepository.findAll();
    }

    /**
     * Sets order time, list of ordered dishes and saves order in database.
     */

    public void saveOrder(Order order, List<String> dishesList){
        Date date = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String time = timeFormat.format(date);
        order.setTime(time);
        StringBuilder dishList = new StringBuilder();
        String prefix = "";
        for (String dish : dishesList) {
            dishList.append(prefix);
            prefix = ", ";
            dishList.append(dish);
        }
        order.setListOfDishes(dishList.toString());
        System.out.println(order);
        ordersRepository.save(order);
    }

    /**
     * Updates status of order.
     */

    public void updateOrderStatus(Long id, String status) {
        Optional<Order> orderOptional = ordersRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(status);
            ordersRepository.save(order);
        }
    }

    /**
     * Deletes order from database.
     */

    public void deleteOrder(Long id) {
        Optional<Order> orderOptional = ordersRepository.findById(id);
        if (orderOptional.isPresent()) {
            ordersRepository.delete(orderOptional.get());
        }
    }

}
