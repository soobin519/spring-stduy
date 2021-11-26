package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		// attributeName: data/ attributeValue: hello!!
		model.addAttribute("data","hello!!");
		return "hello"; //resources-template의 hello.html 파일 return 
	}

}
