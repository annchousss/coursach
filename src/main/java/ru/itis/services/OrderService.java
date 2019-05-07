package ru.itis.services;

import ru.itis.models.ProductName;

import java.util.List;

public interface OrderService {
    void add(Long productId, Long userId);
    void delete(Long id, Long productId);
    List<ProductName> getProduct(Long userId);
    void insertAddress(String city, String street, int house);
    void insertAddressId(Long addressId, Long userId);
}
