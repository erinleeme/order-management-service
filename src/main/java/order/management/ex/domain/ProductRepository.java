package order.management.ex.domain;


import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
