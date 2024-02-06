package sheridan.duttasah.assignment1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sheridan.duttasah.assignment1.database.ProductRepository;
import sheridan.duttasah.assignment1.beans.Product;

import java.util.List;
import java.util.Random;
import java.lang.Iterable;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Random random = new Random();

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Long generateUniqueId() {
        long id = 100000000 + random.nextInt(900000000);
        return id;
    }

    public Product saveProduct(Product product) {
        if (product.getId() == null)
        {
            product.setId(generateUniqueId());
        }
        return productRepository.save(product);

    }
}





