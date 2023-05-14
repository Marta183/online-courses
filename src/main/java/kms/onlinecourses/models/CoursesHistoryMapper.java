package kms.onlinecourses.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursesHistoryMapper implements RowMapper<CoursesHistory> {
    @Override
    public CoursesHistory mapRow(ResultSet resultSet, int i) throws SQLException {
        CoursesHistory coursesHistory = new CoursesHistory();

        Course course = new Course();
        course.setId(resultSet.getLong("course_id"));
        course.setName(resultSet.getString("course_name"));

        coursesHistory.setCourse(course);
        coursesHistory.setCourseMode(CourseMode.valueOf(resultSet.getString("course_mode").toUpperCase()));
        coursesHistory.setStartDate(resultSet.getDate("start_date"));
        coursesHistory.setEndDate(resultSet.getDate("end_date"));
        coursesHistory.setAvailableSeats(resultSet.getInt("available_seats"));
        coursesHistory.setPrice(resultSet.getDouble("price"));

        return coursesHistory;
    }
}