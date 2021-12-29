package net.parwand.producer.applicationservice;

import net.parwand.producer.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    // simulate the database
    private final Map<Long, Product> products = new HashMap<>();

    public List<Product> allProducts() {
        Product product1 = new Product(1L, "ADIDAS", 6.0, 55.99);
        Product product2 = new Product(2L, "NIKE", 8.2, 105.99);
        Product product3 = new Product(3L, "TOM TAILOR", 4.3, 250.99);
        Product product4 = new Product(4L, "BOSS", 0.3, 500.99);
        Product product5 = new Product(5L, "CALVIN", 3.4, 89.99);
        Product product6 = new Product(6L, "SKY SPORT", 10.1, 39.99);

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);
        products.put(product5.getId(), product5);
        products.put(product6.getId(), product6);
        return new ArrayList<>(products.values());
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }


}
