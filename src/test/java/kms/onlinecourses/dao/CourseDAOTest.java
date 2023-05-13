package kms.onlinecourses.dao;

import kms.onlinecourses.models.Course;
import kms.onlinecourses.models.CourseCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class CourseDAOTest {

    private static JdbcTemplate jdbcTemplate;

    private static CourseDAO courseDAO;

    @BeforeAll
    static void setup(@Mock JdbcTemplate jdbcTemplateMock) {
        jdbcTemplate = jdbcTemplateMock;
        courseDAO = new CourseDAO(jdbcTemplate);
    }

    @Test
    void shouldReturnAllCourses() {
        List<Course> expected = courses();
        Collections.sort(expected);

        Mockito.when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(expected);

        List<Course> actualResult = courseDAO.getCourses();
        Collections.sort(actualResult);

        Assertions.assertNotNull(actualResult);
        Assertions.assertEquals(expected.size(), actualResult.size());
        Assertions.assertIterableEquals(expected, actualResult);
    }

    private List<Course> courses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "course1", 14, new CourseCategory("category1")));
        courses.add(new Course(2L, "course2", 24, new CourseCategory("category1")));
        courses.add(new Course(3L, "course3", 14, new CourseCategory("category2")));
        courses.add(new Course(4L, "course4", 0, new CourseCategory("category3")));
        courses.add(new Course(5L, null, 0, null));
        return courses;
    }

}