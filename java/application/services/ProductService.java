@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    @Cacheable(value = "product", key = "#id")
    public Product getProduct(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product create(ProductRequest request) {
        Product p = new Product();
        p.setName(request.name());
        p.setDescription(request.description());
        p.setPrice(request.price());
        return repo.save(p);
    }

    public Product update(Long id, ProductRequest req) {
        Product p = getProduct(id);
        p.setName(req.name());
        p.setDescription(req.description());
        p.setPrice(req.price());
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.delete(getProduct(id));
    }
}