package kms.onlinecourses.controllers;

import kms.onlinecourses.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class MainController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping()
    public String showCourses(Model model) {
        model.addAttribute("coursesList", courseDAO.getCourses());
        return "courses/all_courses";
    }

}

