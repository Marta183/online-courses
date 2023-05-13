package kms.onlinecourses.models;

import javax.validation.constraints.*;

public class Student {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be between 1 and 100 characters")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Last name should be between 1 and 100 characters")
    private String lastName;

    @NotEmpty
    @Min(value = 5, message = "Age should be greater than 5")
    @Max(value = 100, message = "Age should be less than 100")
    private int age;

    @NotEmpty
    @Email
    private String email;

    public Student(Long id, String name, String lastName, int age, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
