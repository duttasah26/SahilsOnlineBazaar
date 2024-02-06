package sheridan.duttasah.assignment1.database;
import sheridan.duttasah.assignment1.beans.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>
{
}
