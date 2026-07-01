package dhv.edu.demoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dhv.edu.demoSpring.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}