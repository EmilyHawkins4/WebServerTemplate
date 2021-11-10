package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@GetMapping("/content")
	public String content() {
		return "content";
	}

	@GetMapping("/fyp")
	public String fyp() {

		ConnectToDatabase.displayPosts();
		return "fyp";

	}

	@GetMapping("/post")
	public String post() { return "post"; }

	/*@PostMapping("/post")
		public String postForm(){

		}*/

}