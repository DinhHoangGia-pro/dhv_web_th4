package dhv.edu.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dhv.edu.demoSpring.models.Product;
import dhv.edu.demoSpring.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class DHVController {

    @Autowired
    private ProductRepository repository;

    // ===========================
    // 1. Lấy danh sách sản phẩm
    // ===========================
    @GetMapping("/listsp")
    public List<Product> listsp() {
        return repository.findAll();
    }

    // ===========================
    // 2. Thêm sản phẩm
    // ===========================
    @PostMapping("/createsp")
    public Product createsp(@RequestBody Product product) {
        product.setId(0);     // Để H2 tự sinh ID
        return repository.save(product);
    }

    // ===========================
    // 3. Cập nhật sản phẩm
    // ===========================
    @PutMapping("/updatesp/{id}")
    public Product updatesp(@PathVariable int id,
                            @RequestBody Product newProduct) {

        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());

        return repository.save(product);
    }

    // ===========================
    // 4. Xóa sản phẩm
    // ===========================
    @DeleteMapping("/deletesp/{id}")
    public String deletesp(@PathVariable int id) {

        if (!repository.existsById(id)) {
            return "Không tìm thấy sản phẩm có id = " + id;
        }

        repository.deleteById(id);

        return "Đã xóa sản phẩm có id = " + id;
    }

}