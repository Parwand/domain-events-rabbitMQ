package net.parwand.consumer.domain;

/**
 * @AUTHOR Parwand Alsino
 */
public class Product {
    private Long id;
    private String name;
    private int weight;
    private Double price;

    public Product(Long id, String name, int weight, Double price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
