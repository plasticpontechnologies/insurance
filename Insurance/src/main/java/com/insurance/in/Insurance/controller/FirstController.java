package com.insurance.in.Insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.in.Insurance.model.DocumentRequest;
import com.insurance.in.Insurance.model.LoginUser;
import com.insurance.in.Insurance.model.User;
import com.insurance.in.Insurance.service.UserService;

@Controller
public class FirstController {

	@Autowired
	private UserService userService;

	
	  @RequestMapping("/") public ModelAndView firstUrl() { ModelAndView first =
	  new ModelAndView("index-3"); //first.addObject("loginUser", new LoginUser());
	  return first; }
	 

	@RequestMapping("/signup")
	public ModelAndView viewRegisterPage() {
		ModelAndView signUp = new ModelAndView("sign_up");
		signUp.addObject("user", new User());
		return signUp;
	}

	@RequestMapping("/login")
	public ModelAndView viewLoginPage() {
		ModelAndView signUp = new ModelAndView("sign_in");
		//signUp.addObject("user", new User());
		return signUp;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user) {
		// model.addAttribute("login", new Login());
		ModelAndView registerView = new ModelAndView();
		userService.saveUser(user);
		registerView.setViewName("success");
		return registerView;
	}
	
	@RequestMapping(value="/loginSuccess")
	public ModelAndView loginSuccess() {
		ModelAndView loginSuccess = new ModelAndView();
		//loginSuccess.setViewName("userInfoPage");client_dashboard
		loginSuccess.setViewName("dashboard_main");
		return loginSuccess;
	}
	
	@RequestMapping(value="/documentRequests")
	public ModelAndView getDocumentRequestData() {
		ModelAndView documentRequest = new ModelAndView();
		System.out.println("inside getDocumentRequestData()");
		//loginSuccess.setViewName("userInfoPage");client_dashboard
		List<DocumentRequest> documentList=userService.getAllDocumentData();
		for(DocumentRequest document : documentList) {
			System.out.println(document.getName());
		}
		documentRequest.addObject("documentList", documentList);
		documentRequest.setViewName("document");
		return documentRequest;
	}
}