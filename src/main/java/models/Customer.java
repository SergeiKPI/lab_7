package models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.UUID;

public class Customer {
    @NotNull
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Min(value = 1, message = "Min value is 1")
    @Max(value = 200, message = "Max value is 200")
    private int age;
    @NotNull
    private Calendar birthDate;
    @NotNull
    @Pattern(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "input doesn't match email pattern(email@example.com)")
    private String email;
    @NotNull
    @Pattern(regexp = "\\d{10}", message = "input doesn't match phone pattern(0123456789)")
    private String phone;

    public Customer() {
    }

    public Customer(UUID id, String firstName, String lastName, int age, Calendar birthDate, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
