@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable Long id) {
        Product p = service.getProduct(id);
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest req) {
        Product p = service.create(req);
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest req) {
        Product p = service.update(id, req);
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}