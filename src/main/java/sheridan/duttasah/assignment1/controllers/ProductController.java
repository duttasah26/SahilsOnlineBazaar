package sheridan.duttasah.assignment1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sheridan.duttasah.assignment1.services.ProductService;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/product")
    public String HomePage(Model model){
        model.addAttribute("products",productsService.)
        return "product";
    }

    @PostMapping("/product")
    public String addProduct(Product product, Model model){
        productService.save(product);
        return "redirect:/product";
    }

}
