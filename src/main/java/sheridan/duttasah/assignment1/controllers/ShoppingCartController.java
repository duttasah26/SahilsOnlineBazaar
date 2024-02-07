package sheridan.duttasah.assignment1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import sheridan.duttasah.assignment1.beans.Product;
import sheridan.duttasah.assignment1.beans.ShoppingCart;
import sheridan.duttasah.assignment1.database.ProductRepository;
import sheridan.duttasah.assignment1.services.ProductService;
import sheridan.duttasah.assignment1.services.ShoppingCartService;

import java.util.Optional;

@Controller
public class ShoppingCartController {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ProductService productService, ShoppingCartService shoppingCartService)
    {
        this.productService = productService;
        this.shoppingCartService=shoppingCartService;
    }

    @GetMapping("/shopping")
    public String shoppingCart(Model model) {
        model.addAttribute("productList",productService.listProducts());
        model.addAttribute("itemsincart",shoppingCartService.listCart());
        return "shopping";
    }

    @GetMapping("/shopping/{id}")
    public String AddToCart(@PathVariable Long id, Model model)
    {
        ShoppingCart shoppingCart=shoppingCartService.addToCart(id);
        return "redirect:/shopping";
    }



    @GetMapping("/checkout")
    public String Checkout(Model model){
        model.addAttribute("cartList",shoppingCartService.listCart());
        return "checkout";
    }


}
