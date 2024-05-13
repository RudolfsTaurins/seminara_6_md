package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.service.ICourseFilterService;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {
	
	@Autowired
	private ICourseFilterService courseService;
	
	@GetMapping("/student")//localhost:8080/course/filter/student?id=2
	public String getCourseFilterStudentById(@RequestParam("id") int id,
			Model model)
	{
		try {
			model.addAttribute("myobjs", courseService.selectCoursesByStudentId(id));
			model.addAttribute("mytitle", "Filtered by Student");
			return "show-course-all-page"; //parādīsies show-all-course-page.html lapa ar atlasītajiem kursiem
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";//parādīsies error-page.html lapa ar konkrēto izņemuma ziņu
		}
		
	}
	
	@GetMapping("/professor")//localhost:8080/course/filter/professor?id=2
	public String getCourseFilterProfessorById(@RequestParam("id") int id,
			Model model)
	{
		try {
			model.addAttribute("myobjs", courseService.selectCoursesByProfessorId(id));
			model.addAttribute("mytitle", "Filtered by Professor");
			return "show-course-all-page"; //parādīsies show-all-course-page.html lapa ar atlasītajiem kursiem
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";//parādīsies error-page.html lapa ar konkrēto izņemuma ziņu
		}
		
	}
	
	@GetMapping("/cp")//localhost:8080/course/filter/cp?cp=2
	public String getCourseFilterByCp(@RequestParam("cp") int cp,
			Model model)
	{
		try {
			model.addAttribute("myobjs", courseService.selectCoursesByCP(cp));
			model.addAttribute("mytitle", "Filtered by Professor");
			return "show-course-all-page"; //parādīsies show-all-course-page.html lapa ar atlasītajiem kursiem
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";//parādīsies error-page.html lapa ar konkrēto izņemuma ziņu
		}
		
	}






}
