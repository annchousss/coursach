package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.models.Address;
import ru.itis.models.ProductName;

import javax.sql.DataSource;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static final String SQL_INSERT_PRODUCT =
            "INSERT INTO order_history (customer_id, product_id) VALUES (?, ?)";

    private static final String SQL_DELETE_PRODUCT =
            "DELETE FROM order_history where customer_id = ? and id = ?";

    private static final String SQL_GET_PRODUCT =
            "SELECT * FROM order_history JOIN product on order_history.product_id = product.id WHERE customer_id = ?";

    private static final String SQL_INSERT_ADDRESS =
            "INSERT INTO address (city, street, house) VALUES (?, ?, ?)";

    private static final String SQL_INSERT_ADDRESS_ID =
            "UPDATE order_history SET address_id = ? WHERE id = ?";

    private RowMapper<ProductName> rowMapperProduct = (rs, i) -> ProductName.builder()
            .title(rs.getString("title"))
            .id(rs.getLong("id"))
            .image(rs.getString("image"))
            .model(rs.getString("model"))
            .numberOfPlaces(rs.getInt("number_of_places"))
            .price(rs.getInt("price"))
            .build();

//    private RowMapper<Address> rowMapperAddress = (resultSet, i) -> Address.builder()
//            .id(resultSet.getLong("id"))
//            .city(resultSet.getString("city"))
//            .street(resultSet.getString("street"))
//            .house(resultSet.getInt("house"))
//            .build();

    public void add(Long userId, Long productId){
        jdbcTemplate.update(SQL_INSERT_PRODUCT, userId, productId);
    }

    public void insertAddressId(Long addressId, Long userId) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS_ID, addressId, userId);
    }

    public void insertAddress(String city, String street, int house) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS, city, street, house);
    }

    public void delete(Long userId, Long productId){
        jdbcTemplate.update(SQL_DELETE_PRODUCT, userId, productId);
    }

    public List<ProductName> getProduct(Long userId) {
        return jdbcTemplate.query(SQL_GET_PRODUCT, rowMapperProduct, userId);
    }


}
