@Entity
public class Inventory {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Warehouse warehouse;

    private Integer quantity;
}