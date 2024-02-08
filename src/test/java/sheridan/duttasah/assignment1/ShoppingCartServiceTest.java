package sheridan.duttasah.assignment1;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import sheridan.duttasah.assignment1.beans.Product;
import sheridan.duttasah.assignment1.beans.ShoppingCart;
import sheridan.duttasah.assignment1.database.ProductRepository;
import sheridan.duttasah.assignment1.database.ShoppingCartRepository;
import sheridan.duttasah.assignment1.services.ShoppingCartService;
import java.util.List;

@SpringBootTest
class ShoppingCartServiceTest {
    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Test
    public void addToCartTest() {
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Test Product");
        mockProduct.setPrice(100.0);
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(mockProduct));
        shoppingCartService.addToCart(1L);
        verify(shoppingCartRepository, times(1)).save(any());
    }

    @Test
    public void CalculateTotalPriceTest() {
        List<ShoppingCart> cartItems = List.of(
                new ShoppingCart(1L, "Item 1", 50.00),
                new ShoppingCart(2L, "Item 2", 100.00)
        );
        when(shoppingCartRepository.findAll()).thenReturn(cartItems);
        List<Double> prices = shoppingCartService.totalprice();
        double expectedTotal = 150.00;
        double expectedTax = expectedTotal * 0.13;
        double expectedGrandTotal = expectedTotal + expectedTax;

        assertEquals(expectedTotal, prices.get(0));
        assertEquals(expectedTax, prices.get(1));
        assertEquals(expectedGrandTotal, prices.get(2));
    }





}
