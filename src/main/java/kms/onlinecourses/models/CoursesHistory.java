package kms.onlinecourses.models;

import javax.validation.constraints.NotEmpty;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class CoursesHistory implements Comparable<CoursesHistory> {

    @NotEmpty
    private Course course;

    @NotEmpty
    private CourseMode courseMode;

    @NotEmpty
    private Date startDate;
    private Date endDate;

    private int availableSeats;
    private double price;

    public CoursesHistory() {
    }

    // TODO: impl builder, impl comparable


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(CourseMode courseMode) {
        this.courseMode = courseMode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CoursesHistory that = (CoursesHistory) o;
        return Objects.equals(getCourse(), that.getCourse())
                && Objects.equals(getCourseMode(), that.getCourseMode())
                && Objects.equals(getStartDate(), that.getStartDate()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getCourseMode(), getStartDate());
    }

    @Override
    public int compareTo(CoursesHistory other) {
        return Comparator.comparing(CoursesHistory::getCourse)
                .thenComparing(CoursesHistory::getCourseMode)
                .thenComparing(CoursesHistory::getStartDate)
                .compare(this, other);
    }
}
