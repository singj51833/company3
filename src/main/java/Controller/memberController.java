package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Dao.implDao;
import Factory.Fact;
import Model.member;

@Controller
@RequestMapping("/member")
public class memberController {
	static Fact f=implDao.a1.getBean("SF",Fact.class);
	
	
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) throws Exception
	{
		List<Object> l=f.getMd().login(username, password);
		
		if(l.size()==0)
		{
			return "member/addmember";
		}
		else
		{
			member[] m=l.toArray(new member[l.size()]);
			
			session.setAttribute("M",m[0]);
			
			return "porder/porderManager";
		}
	}
	
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
	
	@RequestMapping("/testjson1")
	@ResponseBody
	public member getMember() {
		member m = new member("cc","ccc","cccc","ccccc","ccc",true);
		return m;
	}
	
	@RequestMapping("/testjson2")
	@ResponseBody
	public List<Object> getML(){
		//List<Object> l = new ArrayList();
		List<Object> l = Arrays.asList(
				new member("cc1","ccc","cccc","ccccc","ccc",true),
				new member("cc2","ccc","cccc","ccccc","ccc",true),
				new member("cc3","ccc","cccc","ccccc","ccc",true),
				new member("cc4","ccc","cccc","ccccc","ccc",true),
				new member("cc5","ccc","cccc","ccccc","ccc",true)
				);
		return l;
	}
	
	@RequestMapping("/queryAll")
	@ResponseBody
	public List<Object> getAll() throws IOException{
		return f.getMd().queryAll();
	}
	
	
	

}