@Entity
public class Warehouse {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String location;
}