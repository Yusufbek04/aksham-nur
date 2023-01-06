package uz.pdp.akshamnurserver;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.akshamnurserver.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
