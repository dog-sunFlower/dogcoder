package com.rl.controller;

import com.rl.domain.User;
import com.rl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="register")
	public ModelAndView editPerson(@RequestParam(value="id",required=false) Integer id) {
		logger.debug("Received request to register user id : "+id);
		ModelAndView mav = new ModelAndView();		
 		mav.setViewName("register");
 		User user = null;
 		if (id == null) {
			user = new User();
 		} else {
			user = userService.findUserById(id);
 		}
 		
 		mav.addObject("user", user);
		return mav;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="register")
	public String savePerson(@ModelAttribute User user) {
		logger.debug("Received postback on user "+user);
		userService.saveUser(user);
		return "redirect:list";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="list")
	public ModelAndView listPeople() {
		logger.debug("Received request to list users");
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.findUsers();
		logger.debug("users Listing count = "+users.size());
		mav.addObject("users",users);
		mav.setViewName("list");
		return mav;
		
	}

}
