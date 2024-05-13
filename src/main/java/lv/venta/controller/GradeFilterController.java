package lv.venta.controller;

import lv.venta.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {
    @Autowired
    private IGradeFilterService gradeService;

    @GetMapping("/student")//localhost:8080/grade/filter/student?id=2
    public String getGradeStudent(@RequestParam("id") int id, Model model) {

        try {
            model.addAttribute("myobj", gradeService.selectGradesByStudentId(id));
            model.addAttribute("title", "Grades by Student id");
            return "show-all-grade-page";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }



    }

    @GetMapping("/course") //localhost:8080/grade/filter/course?id=2
    public String getCalculatedAVGGradeFilterCourseById(@RequestParam("id") int id, Model model) {
        try {
            model.addAttribute("myobj", gradeService.calculateAVGGradeInCourseId(id));
            model.addAttribute("title", "Average grades in course");
            return "average-grade-for-course";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/failed") //localhost:8080/course/filter/failed
    public String getFailedGrades(Model model) {
        try {
            model.addAttribute("myobj", gradeService.selectFailedGrades());
            model.addAttribute("title", "Failed Grades");
            return "failed-grades-page";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }

}
