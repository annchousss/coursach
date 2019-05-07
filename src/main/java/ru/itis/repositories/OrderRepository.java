package ru.itis.repositories;

import ru.itis.models.ProductName;

import java.util.List;

public interface OrderRepository {
    void add(Long productId, Long userId);
    void delete(Long userId, Long productId);
    List<ProductName> getProduct(Long userId);
    void insertAddress(String city, String street, int house);
}
