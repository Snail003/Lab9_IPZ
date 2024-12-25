package Restaurant.Controller;

import Restaurant.Model.FormOrderData;
import Restaurant.Model.Order;
import Restaurant.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Class that represents controller.
 */

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/staff")
    public String listOrders(Model model) {
        model.addAttribute("orders",orderService.findAll());
        return "staff";
    }

    @PostMapping("/update-status")
    public String updateOrderStatus(@RequestParam("id") Long id) {
        orderService.updateOrderStatus(id, "Done");
        return "redirect:/staff";
    }

    @PostMapping("/delete-order")
    public String deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrder(id);
        return "redirect:/staff";
    }

    @GetMapping("/main")
    public String addOrder(Model model) {
        model.addAttribute("order",new Order());
        model.addAttribute("formData", new FormOrderData());
        return "main";
    }

    @PostMapping("/addOrder")
    public String saveOrder(@ModelAttribute Order order, @ModelAttribute FormOrderData formData) {
        if (formData.getSelectedOptions().isEmpty()) {
            return "redirect:/main";
        }
        orderService.saveOrder(order, formData.getSelectedOptions());
        return "success";
    }
}
