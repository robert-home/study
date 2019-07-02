package pl.rbudner.learn.littlegrid.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Person implements Serializable {

    private int id;
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String ccy;
    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // NOSONAR
        if (o == null || getClass() != o.getClass()) return false; // NOSONAR

        Person person = (Person) o;

        return email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " (" + getEmail() + ")";
    }

}
