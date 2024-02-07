package sheridan.duttasah.assignment1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sheridan.duttasah.assignment1.beans.ShoppingCart;
import sheridan.duttasah.assignment1.database.ProductRepository;
import sheridan.duttasah.assignment1.database.ShoppingCartRepository;
import sheridan.duttasah.assignment1.beans.Product;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.lang.Iterable;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    private final ShoppingCart shoppingCart;


    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository)
    {
        this.shoppingCartRepository=shoppingCartRepository;
        this.productRepository=productRepository;
    }

    public Iterable<ShoppingCart> listCart()
    {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart addToCart(Long id)
    {Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            // Handle the case where product is not found
            return null;
        }

        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElse(null);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setId(id);
            shoppingCart.setName(product.getName());
            shoppingCart.setPrice(product.getPrice());
            shoppingCart.setNoOfItems(1); // Initialize with 1 item
        } else {
            // If the shopping cart item already exists, increment the number of items
            shoppingCart.setNoOfItems(shoppingCart.getNoOfItems() + 1);
        }

        return shoppingCartRepository.save(shoppingCart);





        /*Product product = productRepository.findById(id).get();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(product.getId());
        shoppingCart.setName(product.getName());
        shoppingCart.setPrice(product.getPrice());
        return shoppingCartRepository.save(shoppingCart);*/

    }

}
