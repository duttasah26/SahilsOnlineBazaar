package sheridan.duttasah.assignment1.database;
import sheridan.duttasah.assignment1.beans.ShoppingCart;
import org.springframework.data.repository.CrudRepository;


public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>
{

}
