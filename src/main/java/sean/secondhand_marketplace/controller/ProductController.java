package sean.secondhand_marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.secondhand_marketplace.Service.ProductService;
import sean.secondhand_marketplace.model.ProductDto;
import sean.secondhand_marketplace.product.AddProductForm;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<?> searchProduct(@RequestParam String productName) {
        return ResponseEntity.ok(productService.searchProduct(productName));
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestParam String seller, @RequestBody AddProductForm form) {
        return ResponseEntity.ok(ProductDto.from(productService.addProduct(seller, form)));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestParam Long id, @RequestBody AddProductForm form) {
        return ResponseEntity.ok(ProductDto.from(productService.updateProduct(id, form)));
    }

    @DeleteMapping("/delete")
    public void deleteCompany(@RequestParam Long id) {
        productService.deleteProduct(id);
    }
}
