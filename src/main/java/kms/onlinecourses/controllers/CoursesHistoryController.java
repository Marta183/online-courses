package kms.onlinecourses.controllers;

import kms.onlinecourses.dao.CourseHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesHistoryController {

    @Autowired
    private CourseHistoryDAO courseHistoryDAO;

    @GetMapping("/upcoming")
    public String showUpcomingCourses(Model model) {
        model.addAttribute("upcomingCoursesList", courseHistoryDAO.getUpcomingCourses());
        return "courses/upcoming_courses";
    }
}
