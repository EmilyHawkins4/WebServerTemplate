package service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
	public String content(@RequestParam(name="name", required=false) String name, Model model) {
		model.addAttribute("posts", ConnectToDatabase.displayPosts(name));
		System.out.println(name);
		model.addAttribute("name", name);
		return "content";
	}

	@GetMapping("/post")
	public String post(Model model) {
		model.addAttribute("post", new BumperStickerPost());
		return "post";}


	@PostMapping("/submit")
	public String post(@ModelAttribute BumperStickerPost post, Model model, @RequestParam MultipartFile file){
		StorageService f = new StorageService();
		String url;
		try {
			url = f.StorageServices(file);
		} catch (IOException e) {
			e.printStackTrace();
			url="it didn't work";
		}
		post.setImage(url);
		model.addAttribute("post", post);
		DatabaseConnect d = new DatabaseConnect();
		d.saveData(post);
		return "submit";
		}

}