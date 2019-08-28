package controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class testController {

	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
  
		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload";
		System.out.println(path);
		file.transferTo(new File(path,nname));
		return "/upload/"+nname;
	}
	
	@RequestMapping("login1")
	@RequiresPermissions("user")
	public void login(String name,String pass) {
		Subject sub = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name,pass);
		System.out.println("开始登陆");
		 sub.login(token);    
	}
	
	@RequestMapping("index")
	public void index(ModelMap m) {
		m.put("arr", new String[] {"/upload/a199e322-5e86-44d9-980a-fb8828aa4385.jpg",
				"/upload/d3a03969-99c8-4537-926c-2ea512c8f866.jpg",
				"/upload/e683e8d4-f88e-4c93-b6c7-c955139b4b23.jpg"});
	}
	
	@RequestMapping("chart")
	public @ResponseBody ChartInfo wsss() {
		ChartInfo c=new ChartInfo();
		c.setTitle("ECharts 入门示例");
		c.setLegends("销量","数量");
		c.setxAxiss("衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子");
		Chart_series s1=new Chart_series("销量", "bar", 5, 20, 36, 10, 10, 20);
		Chart_series s2=new Chart_series("数量", "bar", 5, 10, 26, 14, 30, 20);
		c.setSeries(s1,s2);
		return c;
	}
}
