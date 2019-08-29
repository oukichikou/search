package controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
@RequestMapping("inlogin")
public String login() {
	 UsernamePasswordToken token = new  UsernamePasswordToken("admin",  "21232f297a57a5a743894a0e4a801fc3");
     token.setRememberMe(false);
      SecurityUtils.getSubject().login(token);
      return "index";
}
@RequestMapping("outlogin")
public String outlogin() {
      SecurityUtils.getSubject().logout();
      return "redirect:login.html";
}

@RequestMapping("login")
public String loginindex() {
	return "login";
}

}
