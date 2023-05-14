package kms.onlinecourses.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Course implements Comparable<Course> {
    private long id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be between 1 and 100 characters")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 150, message = "Name should be between 1 and 100 characters")
    private double duration;

    @NotEmpty
    private CourseCategory courseCategory;

    public Course() {
    }

    public Course(long id, String name, double duration, CourseCategory courseCategory) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.courseCategory = courseCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public CourseCategory getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategory courseCategory) {
        this.courseCategory = courseCategory;
    }

    @Override
    public int compareTo(Course o) {
        return Long.compare(this.getId(), o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
