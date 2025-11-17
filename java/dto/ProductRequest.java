public interface ProductRepository extends JpaRepository<Product, Long> {}
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {}
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProductId(Long productId);
}