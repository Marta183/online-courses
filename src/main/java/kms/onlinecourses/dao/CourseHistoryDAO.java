package kms.onlinecourses.dao;

import kms.onlinecourses.models.Course;
import kms.onlinecourses.models.CoursesHistory;
import kms.onlinecourses.models.CoursesHistoryMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CourseHistoryDAO {
    private JdbcTemplate jdbcTemplate;

    public CourseHistoryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CoursesHistory> getAllHistory() {
        return null; //getHistoryFromDate(LocalDate.MIN);
    }

    public List<CoursesHistory> getHistoryFromDate(LocalDate dateFrom) {
        return null; //jdbcTemplate.query("SELECT * FROM Courses_History WHERE ", new BeanPropertyRowMapper<>(CoursesHistory.class));
    }

    public List<CoursesHistory> getUpcomingCourses() {
        return jdbcTemplate.query(
                "SELECT ch.course_id, courses.name AS course_name, ch.course_mode, ch.start_date, ch.end_date, ch.available_seats, ch.price \n" +
                    "FROM Courses_History AS ch INNER JOIN Courses ON ch.course_id = courses.id \n" +
                    "WHERE start_date >= ?",
                new Object[]{LocalDate.now()},
                new CoursesHistoryMapper());
    }

    public List<CoursesHistory> getCompletedCourses() {
        return null;
    }

}
