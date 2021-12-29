package net.parwand.consumer.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Shipment {
    private UUID id;
    private LocalDate date;
    private Long productId;


    public Shipment(UUID id, LocalDate date, Long productId) {
        this.id = id;
        this.date = date;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", date=" + date +
                ", productId=" + productId +
                '}';
    }
}
