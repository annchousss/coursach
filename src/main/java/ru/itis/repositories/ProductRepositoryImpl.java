package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.forms.FeedbackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Category;
import ru.itis.models.ProductName;
import ru.itis.models.Feedback;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_READ_BY_ID =
            "SELECT title from product where id = ?";

    private static final String SQL_GET_ALL =
            "SELECT * FROM product";

    private static final String SQL_GET_ALL_CATEGORIES =
            "SELECT * FROM category";

    private static final String SQL_GET_ALL_BY_CATEGORY_ID =
            "SELECT * FROM product WHERE category_id = ?";

    private static final String SQL_GET_ALL_FEEDBACK =
            "select customer.first_name as firstName, content from customer inner join feedback on customer.id = feedback.customer_id";

    private static final String SQL_INSERT =
            "insert into feedback (customer_id, content) values (?, ?)";


    private RowMapper<Feedback> rowMapperFeedback = (rs, i) -> Feedback.builder()
                    .firstName(rs.getString("firstName"))
                    .content((rs.getString("content")))
                    .build();

    private RowMapper<Category> rowMapperAllCategories = (rs, i) -> Category.builder()
            .id(rs.getLong("id"))
            .title(rs.getString("title"))
//                    .image(rs.getString("img"))
            .build();

    private RowMapper<ProductName> rowMapperSearch = (rs, i) -> ProductName.builder()
            .title(rs.getString("title"))
            .id(rs.getLong("id"))
            .image(rs.getString("image"))
            .model(rs.getString("model"))
            .build();

    private RowMapper<ProductName> rowMapperAllProducts = (rs, i) -> ProductName.builder()
            .title(rs.getString("title"))
            .id(rs.getLong("id"))
            .image(rs.getString("image"))
            .model(rs.getString("model"))
            .numberOfPlaces(rs.getInt("number_of_places"))
            .price(rs.getInt("price"))
            .build();

    private RowMapper<String> rowMapper = new RowMapper<String>() {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("title");
        }
    };

    @Override
    public List<Feedback> showAllFeedback() {
        return jdbcTemplate.query(SQL_GET_ALL_FEEDBACK, rowMapperFeedback);
    }

    @Override
    public void save(FeedbackForm model) {
        jdbcTemplate.update(SQL_INSERT, model.getCustomer_id(), model.getContent());
    }

    public List<ProductName> getAllProducts() {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapperAllProducts);
    }

    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_GET_ALL_CATEGORIES, rowMapperAllCategories);
    }

    public String get(Long productId) {
        return jdbcTemplate.queryForObject(SQL_READ_BY_ID, rowMapper, productId);
    }

    public List<ProductName> getAllByCategoryId(Long categoryId) {
        return jdbcTemplate.query(SQL_GET_ALL_BY_CATEGORY_ID, rowMapperAllProducts, categoryId);
    }


}
