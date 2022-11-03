package sean.secondhand_marketplace.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sean.secondhand_marketplace.member.MemberRepository;
import sean.secondhand_marketplace.member.entity.Member;
import sean.secondhand_marketplace.model.Auth;
import sean.secondhand_marketplace.product.AddProductForm;
import sean.secondhand_marketplace.product.ProductRepository;
import sean.secondhand_marketplace.product.entity.Product;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(String seller, AddProductForm form) {
        return productRepository.save(Product.of(seller, form));
    }


}
