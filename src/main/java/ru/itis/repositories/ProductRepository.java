package ru.itis.repositories;

import ru.itis.forms.FeedbackForm;
import ru.itis.models.Category;
import ru.itis.models.ProductName;
import ru.itis.models.Feedback;
import java.util.List;

public interface ProductRepository {
    List<ProductName> getAllProducts();
    List<Category> getAllCategories();
    String get(Long productId);
    void save(FeedbackForm model);
    List<ProductName> getAllByCategoryId(Long categoryId);
    List<Feedback> showAllFeedback();
}
