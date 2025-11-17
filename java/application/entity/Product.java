@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Double price;
}