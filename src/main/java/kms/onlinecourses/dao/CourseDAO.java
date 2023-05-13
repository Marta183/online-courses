package kms.onlinecourses.dao;

import kms.onlinecourses.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDAO {

    private JdbcTemplate jdbcTemplate;

    public CourseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Course> getCourses() {
        return jdbcTemplate.query("SELECT * FROM Courses", new BeanPropertyRowMapper<>(Course.class));
    }


}
