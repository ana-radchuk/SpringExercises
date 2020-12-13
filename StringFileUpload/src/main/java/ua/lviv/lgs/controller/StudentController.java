package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService sService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("students", sService.findAllStudents());
		req.setAttribute("mode", "STUDENT_VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newStudent(HttpServletRequest req) {
		req.setAttribute("mode", "STUDENT_CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Student student, HttpServletRequest req) {
		sService.save(student);
		req.setAttribute("students", sService.findAllStudents());
		req.setAttribute("mode", "STUDENT_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest req) {
		req.setAttribute("student", sService.findOne(id));
		req.setAttribute("mode", "STUDENT_EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam int id, HttpServletRequest req) {
		sService.delete(id);
		req.setAttribute("students", sService.findAllStudents());
		req.setAttribute("mode", "STUDENT_VIEW");
		return "index";
	}
	
}
