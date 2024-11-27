package order.management.ex.infrastructure;

import jakarta.annotation.PostConstruct;
import order.management.ex.domain.Product;
import order.management.ex.domain.ProductRepository;
import order.management.ex.domain.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ListProductRepository implements ProductRepository {

    private List<Product> products = new CopyOnWriteArrayList<>();

    @PostConstruct
    void initProducts() {
        Product product1 = new Product(1L, "상품1", 10000, 100);
        Product product2 = new Product(2L, "상품2", 20000, 200);
        Product product3 = new Product(3L, "상품3", 30000, 300);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product를 찾지 못했습니다."));
    }
}
