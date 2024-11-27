package order.management.ex.presentation.dto.controller;

import order.management.ex.application.SimpleProductService;
import order.management.ex.presentation.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private SimpleProductService simpleProductService;

    public ProductRestController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @GetMapping(value = "/products")
    public List<ProductDto> findProducts() { return simpleProductService.findAll();}
}
