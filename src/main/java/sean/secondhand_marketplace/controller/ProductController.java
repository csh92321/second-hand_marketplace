package sean.secondhand_marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.secondhand_marketplace.Service.ProductService;
import sean.secondhand_marketplace.model.ProductDto;
import sean.secondhand_marketplace.product.AddProductForm;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> searchProduct() {
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestParam String seller, @RequestBody AddProductForm form) {
        return ResponseEntity.ok(ProductDto.from(productService.addProduct(seller, form)));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestParam Long id, @RequestBody AddProductForm form) {
        return ResponseEntity.ok(ProductDto.from(productService.updateProduct(id, form)));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCompany() {
        return null;
    }
}
