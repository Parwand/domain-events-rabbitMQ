package net.parwand.producer.domain;

public class Product {
    private Long id;
    private String name;
    private Double weight;
    private Double price;

    public Product(Long id, String name, Double weight, Double price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
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
