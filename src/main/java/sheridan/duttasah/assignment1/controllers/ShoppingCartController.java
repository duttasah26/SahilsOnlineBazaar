package sheridan.duttasah.assignment1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sheridan.duttasah.assignment1.beans.Product;
import sheridan.duttasah.assignment1.database.ProductRepository;
import sheridan.duttasah.assignment1.services.ProductService;
import java.util.Optional;

@Controller
public class ShoppingCartController {
    private final ProductService productService;

    @Autowired
    public ShoppingCartController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/shopping")
    public String shoppingCart(Model model) {
        model.addAttribute("productList",productService.listProducts());
        return "shopping";
    }

    @PostMapping("/shopping")
    public String AddToCart(Model model){
        return "redirect:/shopping";
    }

    @GetMapping("/checkout")
    public String Checkout(){
        return "checkout";
    }


}
