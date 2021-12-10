package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) { 
		// attributeName: data/ attributeValue: hello!!
		model.addAttribute("data","hello!!");
		return "hello"; //resources-template의 hello.html 파일 return 
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		//required = false로 설정하면 파라미터 값(name)을 꼭 안넣어줘도된다.
		//설정안해주면 기본 값은 true 
		model.addAttribute("name",name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody //http Body부에 응답 내용을 직접 넣어주겠다는 의미 
	public String helloString(@RequestParam("name") String name) {
		return "hello "+name; //name=spring으로 해주면 "hello spring"
		//템플릿 방식은 html을 return해준다면 이 방식은 문자열 그대로를 전달해주는 것이다. 
	}
	
	@GetMapping("hello-api")
	@ResponseBody //http Body부에 응답 내용을 직접 넣어주겠다는 의미 
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}
	
	static class Hello{
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) { 
			this.name =name;			
		}		
	}
}
