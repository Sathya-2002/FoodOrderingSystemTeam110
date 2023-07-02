package com.externshipproject.FoodOrderingSystemTeam110.controller;

import java.util.ArrayList;
import java.util.List;

import com.externshipproject.FoodOrderingSystemTeam110.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.Order;
import com.externshipproject.FoodOrderingSystemTeam110.model.OrderItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.User;
import com.externshipproject.FoodOrderingSystemTeam110.model.CreateOrderRequest;
import com.externshipproject.FoodOrderingSystemTeam110.repository.FoodItemRepository;
import com.externshipproject.FoodOrderingSystemTeam110.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    
	@Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
	@Autowired
	private FoodItemRepository foodItemRepository;
    private final List<OrderItem> items = new ArrayList<>();
    private long userId;
    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody CreateOrderRequest request) {

        long userId = request.getUserId();
        
        List<Long> itemIDs = request.getFoodItemIds();// Create order items based on request details

        for(Long itemID:itemIDs) {
        	List<FoodItem> foodItems = foodItemRepository.findByRestaurantsId(itemID);
            for (FoodItem FIitem : foodItems) {
                if (itemID==FIitem.getId()){
                    OrderItem item = new OrderItem();
                    item.setFoodItem(FIitem);
                    item.setQuantity(1);
                    item.setPrice(FIitem.getPrice());
                    items.add(item);
                }
            }
        }

        return ResponseEntity.ok("Added to cart");
        
    }
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(){
        User user = new User();
        user.setId(userId);
        Order order = orderService.createOrder(user, items);
        return ResponseEntity.ok(order);
    }
        @DeleteMapping("/{orderId}")
        public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
            orderService.deleteOrder(orderId);
            return ResponseEntity.ok("Order deleted successfully");
        }

        @DeleteMapping("/{orderId}/{itemId}")
        public ResponseEntity<String> deleteOrderItem(@PathVariable Long orderId, @PathVariable Long itemId) {
            orderService.deleteOrderItem(orderId, itemId);
            return ResponseEntity.ok("Order item deleted successfully");
        }

        @GetMapping("/{orderId}")
        public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
            Order order = orderService.getOrder(orderId);
            return ResponseEntity.ok(order);
        }
        @GetMapping
        public ResponseEntity<List<Order>> getAllOrders() {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        }

}

