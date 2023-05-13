package kms.onlinecourses.models;

import javax.validation.constraints.NotEmpty;

public class CourseCategory {

    @NotEmpty
    private String name;

    public CourseCategory() {
    }

    public CourseCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
