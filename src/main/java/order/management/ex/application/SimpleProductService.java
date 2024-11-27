package order.management.ex.application;

import order.management.ex.domain.Product;
import order.management.ex.domain.ProductRepository;
import order.management.ex.presentation.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {

    private ProductRepository productRepository;

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productList = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();

        return productList;
    }
}
