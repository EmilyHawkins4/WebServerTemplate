package service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;


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

		System.out.println(ConnectToDatabase.displayPosts());
		return "fyp";

	}

	@GetMapping("/post")
	public String post(Model model) {
		model.addAttribute("post", new BumperStickerPost());
		return "post";}


	@PostMapping("/submit")
	public String post(@ModelAttribute BumperStickerPost post, Model model){
		model.addAttribute("post", post);
		System.out.println(post);
		return "submit";
		}

}