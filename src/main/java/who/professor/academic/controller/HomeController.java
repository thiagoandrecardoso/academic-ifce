package who.professor.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import who.professor.academic.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	StudentService service;

	@GetMapping({"/"})
	public String home() {
		return "index";
	}
	
	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping({"/403"})
	public String deny() {
		return "deny";
	}
}
