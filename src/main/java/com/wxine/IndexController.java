package com.wxine;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxine.domain.User;
import com.wxine.repository.UserDao;

@Controller
public class IndexController {
	@Resource
	private UserDao userdao;
	
	@RequestMapping("/")
	public String isfriend(Model m) {
		List<User> user = userdao.findAllIsFriend();
		int count = userdao.countFriend();
		m.addAttribute("user", user);
		m.addAttribute("count",count);
		return "index";
	}
	@RequestMapping("/findAllnofriend")
	public String nofriend(Model m) {
		List<User> user = userdao.findAllnoFriend();
		m.addAttribute("user", user);
		return "addfriend";
	}
	@RequestMapping("/addfriend")
	public String addfriend(String id,boolean isfriend) {
		User user =  userdao.findById(id);
		user.setIsfriend(true);
		userdao.merge(user);
		return "redirect:/findAllnofriend";
	}
	@RequestMapping("/deletefriend")
	public String deletefriend(String id,boolean isfriend) {
		User user =  userdao.findById(id);
		user.setIsfriend(false);
		userdao.merge(user);
		return "redirect:/";
	}
	@RequestMapping("/newfriend")
	public String newfriend() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		String chars = "abcdefghijklmnopqrstuvwxyz";
		user.setAccount(chars.charAt((int)(Math.random() * 26)));
		user.setLocation("深圳");
		String sax = "男女";
		user.setSax(sax.charAt((int)(Math.random() * 2)));
		int x=1+(int)(Math.random()*50);
		user.setAge(x);
		user.setIsfriend(false);
		userdao.insert(user);
		return "redirect:/findAllnofriend";
	}
	@RequestMapping("/details")
	public String details(String id,Model m) {
		User user = userdao.findById(id); 
		m.addAttribute("user", user);
		return "details";
	}
	@RequestMapping("/nodetails")
	public String nodetails(String id,Model m) {
		User user = userdao.findById(id); 
		m.addAttribute("user", user);
		return "nodetails";
	}
	
	
}
