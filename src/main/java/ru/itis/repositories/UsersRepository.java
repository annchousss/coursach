package ru.itis.repositories;

import ru.itis.models.Customer;

import java.util.List;

public interface UsersRepository extends CrudRepository<Customer> {
    void update(Customer model);
    void delete(Long id);
    void save(Customer model);
    Customer find(Long id);
    List<Customer> findAll();
    Customer findByEmail(String email);
}
