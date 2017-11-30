package models;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

public class OrderTest {
    private static Order target;
    private static UUID targetId;
    private static Customer customer;
    private static Product product;
    private static Validator validator;

    @BeforeClass
    public static void initOrder(){
        targetId = UUID.randomUUID();
        customer = new Customer();
        product = new Product();
        target = new Order(targetId, customer, product, 100.4f, false);
    }

    @BeforeClass
    public static void setUpValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void getId() throws Exception {
        assertEquals(targetId, target.getId());
    }

    @Test
    public void setId() throws Exception {
        target.setId(UUID.randomUUID());
        assertNotEquals(targetId, target.getId());
    }

    @Test
    public void getCustomer() throws Exception {
        target.setCustomer(customer);
        assertEquals(customer, target.getCustomer());
    }

    @Test
    public void setCustomer() throws Exception {
        Customer testCustomer = new Customer();
        target.setCustomer(testCustomer);
        assertEquals(testCustomer, target.getCustomer());
    }

    @Test
    public void getProduct() throws Exception {
        target.setProduct(product);
        assertEquals(product, target.getProduct());
    }

    @Test
    public void setProduct() throws Exception {
        Product testProduct = new Product();
        target.setProduct(testProduct);
        assertEquals(testProduct, target.getProduct());
    }

    @Test
    public void getTotalAmount() throws Exception {
        assertEquals(100.4f , target.getTotalAmount(), 0);
    }

    @Test
    public void setTotalAmount() throws Exception {
        target.setTotalAmount(20.3f);
        assertEquals(20.3f, target.getTotalAmount(), 0);
    }

    @Test
    public void getIsDone() throws Exception {
        target.setDone(false);
        assertFalse(target.isDone());
    }

    @Test
    public void setIsDone() throws Exception {
        target.setDone(true);
        assertTrue(target.isDone());
    }

    @Test
    public void testNotNull() throws Exception {
        Order testOrder = new Order();
        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(testOrder);
        assertEquals(3, constraintViolations.size());
    }
}