/*
    by 전성환
    상품 등록과 관련된 컨틀롤러 구현.
 */

package sean.secondhand_marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.secondhand_marketplace.Service.ProductService;
import sean.secondhand_marketplace.model.ProductDto;
import sean.secondhand_marketplace.model.AddProductForm;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //상품 등록
    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestParam String seller, @RequestBody AddProductForm form) {
        return ResponseEntity.ok(ProductDto.from(productService.addProduct(seller, form)));
    }

    //상품 정보 수정
    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestParam Long id, @RequestBody AddProductForm form) {
        return ResponseEntity.ok(ProductDto.from(productService.updateProduct(id, form)));
    }

    //상품 삭제
    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

    //상품 검색
    @GetMapping("/search")
    public ResponseEntity<?> searchProduct(@RequestParam String productName) {
        return ResponseEntity.ok(productService.searchProduct(productName));
    }
}
