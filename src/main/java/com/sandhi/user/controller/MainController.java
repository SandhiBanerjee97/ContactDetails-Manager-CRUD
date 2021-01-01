package com.sandhi.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sandhi.user.dao.UserDAO;
import com.sandhi.user.model.User;

@Controller
public class MainController 
{
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value="/")
	public ModelAndView listUsers(ModelAndView model)	/*Research-ModelAndView*/
	{
		List <User> userList=userDao.list();
		model.addObject("userListKey",userList);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/new", method =RequestMethod.GET) /*Research-RequestMethod.GET*/
	public ModelAndView newUser(ModelAndView model)
	{
		User user= new User();
		model.addObject("newUser",user);	//adding DTO class object to model
		model.setViewName("user-form");
		return model;
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user)
	{
		if(user.getId()==null)	//if id is null that means a new user is being added
		{
			userDao.save(user); // hence we save it
		}
		else					//else if it is not null
		{
			userDao.update(user); //we update the data of that row
		}
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request)
	{															 //fetching the id from URL(request)
		Integer id=Integer.parseInt(request.getParameter("id")); // and storing it in a variable 
		User user=userDao.get(id);								 //using that id to fetch that row(as a user Object) from DB
		
		ModelAndView model= new ModelAndView();
		model.addObject("newUser",user);
		model.setViewName("user-form");
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request)
	{															 //fetching the id from URL(request)
		Integer id=Integer.parseInt(request.getParameter("id")); // and storing it in a variable 
		User user=userDao.get(id);								 //using that id to fetch that row(as a user Object) from DB
		
		userDao.delete(user.getId());
		return new ModelAndView("redirect:/");
	}
}
