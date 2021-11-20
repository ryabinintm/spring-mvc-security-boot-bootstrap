package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class UserController {

	final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path = {"/", "login"})
	public String loginPage() {
		return "login";
	}

	@GetMapping(path ="admin")
	public String getAdminPage(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello Admin!");
		messages.add("Let's edit users list?");
		model.addAttribute("message", messages);
		return "admin";
	}

	@GetMapping(path = "user")
	public String getUserPage(ModelMap modelmap,
							  Principal principal) {
		modelmap.addAttribute("name",
				userService.getUserByEmail(principal.getName())
		);
		return "user";
	}
}