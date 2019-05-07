package ru.itis.services;

import ru.itis.forms.FeedbackForm;
import ru.itis.models.Category;
import ru.itis.models.ProductName;
import ru.itis.models.Feedback;

import java.util.List;

public interface ProductService {
    List<ProductName> showProducts();
    List<Category> showCategories();
    List<ProductName> showProductsByCatId(Long categoryId);
    List<Feedback> showFeedback();
    void insertFeedback(FeedbackForm form);
    String get(Long productId);
    List<ProductName> addProductToUserBasket(String cookieValue, Long productId);

}
