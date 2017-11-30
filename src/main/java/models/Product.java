package models;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Product {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private Size size;
    @NotNull
    private Color color;
    @NotNull
    private double price;

    public Product() {
    }

    public Product(UUID id, String name, Size size, Color color, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
