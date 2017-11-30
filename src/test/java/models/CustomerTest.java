package models;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

public class CustomerTest {
    private static UUID targetId;
    private static Customer target;
    private static Validator validator;
    private static Calendar targetBirthDate = Calendar.getInstance();

    @BeforeClass
    public static void initCustomer(){
        targetId = UUID.randomUUID();
        target = new Customer(targetId, "name", "surname", 18, targetBirthDate, "test@mail.ua", "0631231234");
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
    public void getFirstName() throws Exception {
        assertEquals("name", target.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        target.setFirstName("new name");
        assertEquals("new name", target.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        target.setLastName("surname");
        assertEquals("surname", target.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        target.setLastName("new surname");
        assertEquals("new surname", target.getLastName());
    }

    @Test
    public void getAge() throws Exception {
        assertEquals(18, target.getAge());
    }

    @Test
    public void setAge() throws Exception {
        target.setAge(19);
        assertEquals(19, target.getAge());
    }

    @Test
    public void getBirthDate() throws Exception {
        assertEquals(targetBirthDate, target.getBirthDate());
    }

    @Test
    public void setBirthDate() throws Exception {
        Calendar now = Calendar.getInstance();
        target.setBirthDate(now);
        assertEquals(now, target.getBirthDate());
    }

    @Test
    public void getEmail() throws Exception {
        target.setEmail("test@mail.ua");
        assertEquals("test@mail.ua", target.getEmail());
    }

    @Test
    public void setEmail() throws Exception {
        target.setEmail("qwe");
        assertEquals("qwe", target.getEmail());
    }

    @Test
    public void getPhone() throws Exception {
        target.setPhone("1234567890");
        assertEquals("1234567890", target.getPhone());
    }

    @Test
    public void setPhone() throws Exception {
        target.setPhone("1111");
        assertEquals("1111", target.getPhone());
    }

    @Test
    public void testNotNull() throws Exception {
        Customer testCustomer = new Customer();
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(testCustomer);
        assertEquals(7, constraintViolations.size());
    }

    @Test
    public void testAgeMax() throws Exception {
        Customer testCustomer = new Customer(UUID.randomUUID(), "", "", 210, Calendar.getInstance(), "test@mail.ua", "0123456789");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(testCustomer);
        assertEquals("Max value is 200", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testAgeMin() throws Exception {
        Customer testCustomer = new Customer(UUID.randomUUID(), "", "", -4, Calendar.getInstance(), "test@mail.ua", "0123456789");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(testCustomer);
        assertEquals("Min value is 1", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testEmailPattern() throws Exception {
        Customer testCustomer = new Customer(UUID.randomUUID(), "", "", 4, Calendar.getInstance(), "testmail.ua", "0123456789");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(testCustomer);
        assertEquals("input doesn't match email pattern(email@example.com)", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testPhonePattern() throws Exception {
        Customer testCustomer = new Customer(UUID.randomUUID(), "", "", 4, Calendar.getInstance(), "test@mail.ua", "ad23456789");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(testCustomer);
        assertEquals("input doesn't match phone pattern(0123456789)", constraintViolations.iterator().next().getMessage());
    }
}