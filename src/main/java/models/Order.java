package models;

import java.util.UUID;
import javax.validation.constraints.*;

public class Order {
    @NotNull
    private UUID id;
    @NotNull
    private Customer customer;
    @NotNull
    private Product product;
    @NotNull
    private float totalAmount;
    @NotNull
    private boolean isDone;

    public Order() {
    }

    public Order(UUID id, Customer customer, Product product, float totalAmount, boolean isDone) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.totalAmount = totalAmount;
        this.isDone = isDone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}