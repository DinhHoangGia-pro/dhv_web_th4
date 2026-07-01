package dhv.edu.demoSpring.models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dhv.edu.demoSpring.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository repository;

    public DataLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Chỉ khởi tạo dữ liệu nếu database đang rỗng
        if (repository.count() == 0) {

            for (int i = 1; i <= 20; i++) {

                Product product = new Product();
                product.setName("Sản phẩm " + i);
                product.setPrice(i * 100000);

                repository.save(product);
            }

            System.out.println("Đã khởi tạo 20 sản phẩm trong H2 Database.");
        }
    }
}