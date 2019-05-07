package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.models.ProductName;
import ru.itis.repositories.OrderRepositoryImpl;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private PasswordEncoder encoder;

    @Autowired
    private OrderRepositoryImpl orderRepository;

    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public void add(Long userId, Long productId) {
        orderRepository.add(userId, productId);
    }
    public void delete(Long userId, Long productId) {
        orderRepository.delete(userId, productId);

    }
    public List<ProductName> getProduct(Long userId) {
        return orderRepository.getProduct(userId);
    }

    public void insertAddress(String city, String street, int house) {
        orderRepository.insertAddress(city, street, house);
    }

    public void insertAddressId(Long addressId, Long userId) {
        orderRepository.insertAddressId(addressId, userId);
    }

}
