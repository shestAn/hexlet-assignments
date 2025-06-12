package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Product;
import exercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping
    public List<Product> showAll(@RequestParam(name = "min", required = false) Integer minPrice,
                                 @RequestParam(name = "max", required = false) Integer maxPrice) {
        var sort = Sort.by(Sort.Order.asc("price"));
        if (minPrice == null && maxPrice == null) {
            return productRepository.findAll(sort);
        }
        if (maxPrice == null) {
            return productRepository.findByPriceGreaterThanEqual(minPrice, sort);
        }
        if (minPrice == null) {
            return productRepository.findByPriceLessThanEqual(maxPrice, sort);
        }
        return productRepository.findByPriceBetween(minPrice, maxPrice, sort);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
