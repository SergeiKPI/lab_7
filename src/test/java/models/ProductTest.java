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

public class ProductTest {
    private static Product target;
    private static UUID targetId;
    private static Validator validator;

    @BeforeClass
    public static void initTargetProduct(){
        targetId = UUID.randomUUID();
        target = new Product(targetId, "Spinner",
                Size.Large, Color.Black, 10.5);
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
        UUID previousId = target.getId();
        target.setId(UUID.randomUUID());
        assertNotEquals(previousId, target.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Spinner", target.getName());
    }

    @Test
    public void setName() throws Exception {
        target.setName("Notebook");
        assertEquals("Notebook", target.getName());
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(Size.Large, target.getSize());
    }

    @Test
    public void setSize() throws Exception {
        target.setSize(Size.Medium);
        assertEquals(Size.Medium, target.getSize());
    }

    @Test
    public void getColor() throws Exception {
        target.setColor(Color.Black);
        assertEquals(Color.Black, target.getColor());
    }

    @Test
    public void setColor() throws Exception {
        target.setColor(Color.Green);
        assertEquals(Color.Green, target.getColor());
    }

    @Test
    public void getPrice() throws Exception {
        target.setPrice(10.5);
        assertEquals(10.5, target.getPrice(), 0);
    }

    @Test
    public void setPrice() throws Exception {
        target.setPrice(1.3);
        assertEquals(1.3, target.getPrice(), 0);
    }

    @Test
    public void testNotNull() throws Exception {
        Product testProduct = new Product();
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(testProduct);
        assertEquals(4, constraintViolations.size());
    }
}