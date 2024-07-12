package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "[a-zA-Z_0-9]+", message = "Name can contain only letters and/or numbers")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private String name;

    @Column(name = "lastName")
    @NotBlank(message = "Lastname cannot be empty")
    @Pattern(regexp = "[a-zA-Z_0-9]+", message = "Lastname can contain only letters and/or numbers")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private String lastName;

    @Column(name = "yearOfBirth")
    @NotNull(message = "Please enter correct year of birth")
    @Min(value = 1900, message = "Not less than 1900")
    @Max(value = 2005)
    private int yearOfBirth;

    public User() {
    }

    public User(String name, String lastName, int yearOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && yearOfBirth == user.yearOfBirth && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, yearOfBirth);
    }
}
