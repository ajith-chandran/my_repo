@Component
public class ProductGraphQLResolver {

    @Autowired private ProductService service;
    @Autowired private InventoryRepository inventoryRepo;

    @QueryMapping
    public Product product(@Argument Long id) {
        return service.getProduct(id);
    }

    @QueryMapping
    public List<Inventory> inventories(@Argument Long productId) {
        return inventoryRepo.findByProductId(productId);
    }

    @MutationMapping
    public Product createProduct(@Argument String name,
                                 @Argument String description,
                                 @Argument Double price) {
        return service.create(new ProductRequest(name, description, price));
    }
}