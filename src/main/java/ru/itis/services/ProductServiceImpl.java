package ru.itis.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.forms.FeedbackForm;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.models.Category;
import ru.itis.models.ProductName;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.ProductRepository;
import java.util.List;
import ru.itis.models.Feedback;

@Component
public class ProductServiceImpl implements ProductService {

    private PasswordEncoder encoder;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Feedback> showFeedback() {
        return productRepository.showAllFeedback();
    }

    @Override
    public void insertFeedback(FeedbackForm form) {

        FeedbackForm feedback = FeedbackForm.builder()
                .customer_id(form.getCustomer_id())
                .content(form.getContent())
                .build();
        productRepository.save(feedback);
    }

    @Override
    public String get(Long productId) {
        return null;
    }


    public List<ProductName> showProducts() {
        return productRepository.getAllProducts();
    }

    public List<Category> showCategories() {
        return productRepository.getAllCategories();
    }

    public List<ProductName> showProductsByCatId(Long categoryId) {
        return productRepository.getAllByCategoryId(categoryId);
    }


}
