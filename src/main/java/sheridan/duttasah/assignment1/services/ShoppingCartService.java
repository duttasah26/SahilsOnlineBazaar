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
import java.util.ArrayList;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;


    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository)
    {
        this.shoppingCartRepository=shoppingCartRepository;
        this.productRepository=productRepository;
    }

    public List<ShoppingCart> listCart()
    {
        List<ShoppingCart> cartlist = new ArrayList<>();
        shoppingCartRepository.findAll().forEach(cartlist::add);
        return cartlist;
    }


    public ShoppingCart addToCart(Long id)
    {

        Product product = productRepository.findById(id).get();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(product.getId());
        shoppingCart.setName(product.getName());
        shoppingCart.setPrice(product.getPrice());
        return shoppingCartRepository.save(shoppingCart);

    }

}
