package uz.pdp.akshamnurserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.pdp.akshamnurserver.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);
}
