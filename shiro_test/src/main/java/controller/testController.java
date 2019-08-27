package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping("login")
	public void login(String name,String pass) {
		System.out.println("login");
	}
}
