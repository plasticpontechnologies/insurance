package com.insurance.in.Insurance.controller;

import java.security.Principal;
import java.util.ArrayList;
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
import com.insurance.in.Insurance.utils.Constants;

@Controller
public class FirstController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView firstUrl() {
		ModelAndView first = new ModelAndView("index-3"); // first.addObject("loginUser", new LoginUser());
		return first;
	}

	@RequestMapping("/Home")
	public ModelAndView Home() {
		ModelAndView first = new ModelAndView("index-3"); // first.addObject("loginUser", new LoginUser());
		return first;
	}

	@RequestMapping("/signup")
	public ModelAndView viewRegisterPage() {
		ModelAndView signUp = new ModelAndView("sign_up");
		signUp.addObject("user", new User());
		return signUp;
	}

	@RequestMapping("/login")
	public ModelAndView viewLoginPage() {
		ModelAndView signUp = new ModelAndView("sign_in");
		// signUp.addObject("user", new User());
		return signUp;
	}

	@RequestMapping("/login1")
	public ModelAndView viewLoginPage1() {
		ModelAndView signUp = new ModelAndView("sign_in");

		return signUp;
	}

	@RequestMapping("/about-us")
	public ModelAndView viewaboutUs() {
		ModelAndView signUp = new ModelAndView("about-us");

		return signUp;
	}

	@RequestMapping("/contact-us")
	public ModelAndView viewContactUs() {
		ModelAndView signUp = new ModelAndView("contact-us");

		return signUp;
	}

	@RequestMapping("/blog-column-one")
	public ModelAndView viewUs() {
		ModelAndView signUp = new ModelAndView("blog-column-one");

		return signUp;
	}

	@RequestMapping("/blog-column-two")
	public ModelAndView viewBlogTwo() {
		ModelAndView signUp = new ModelAndView("blog-column-two");

		return signUp;
	}

	@RequestMapping("/blog-column-three")
	public ModelAndView viewBlogThree() {
		ModelAndView signUp = new ModelAndView("blog-column-three");

		return signUp;
	}

	@RequestMapping("/blog-left-sidebar")
	public ModelAndView viewBlogLeftSideBar() {
		ModelAndView signUp = new ModelAndView("blog-left-sidebar");

		return signUp;
	}

	@RequestMapping("/life-insurance")
	public ModelAndView viewBussinessInsurance() {
		ModelAndView signUp = new ModelAndView("life-insurance");

		return signUp;
	}

	@RequestMapping("/health-insurance")
	public ModelAndView viewHealthInsurance() {
		ModelAndView signUp = new ModelAndView("health-insurance");

		return signUp;
	}

	@RequestMapping("/car-insurance")
	public ModelAndView viewLifeInsurance() {
		ModelAndView signUp = new ModelAndView("car-insurance");

		return signUp;
	}

	@RequestMapping("/becomeinsurance")
	public ModelAndView viewBecomeInsurance() {
		ModelAndView signUp = new ModelAndView("become-insurance");

		return signUp;
	}

	@RequestMapping("/inverst")
	public ModelAndView viewInvesting() {
		ModelAndView signUp = new ModelAndView("inverst");

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

	@RequestMapping(value = "/loginSuccess")
	public ModelAndView loginSuccess(Principal principal) {
		ModelAndView loginSuccess = new ModelAndView();
		// loginSuccess.setViewName("userInfoPage");client_dashboard
		//
		System.out.println(principal.getName());
		String roleName = userService.getRoleByName(principal.getName());
		if (roleName.equalsIgnoreCase(Constants.role_user)) {
			loginSuccess.setViewName("dashboard_main");
		} else if (roleName.equalsIgnoreCase(Constants.role_admin)) {
			loginSuccess.setViewName("AgentDashBoard");
		}

		return loginSuccess;
	}

	@RequestMapping(value = "/documentRequests", method = RequestMethod.GET)
	public ModelAndView getDocumentRequestData() {
		ModelAndView documentRequest = new ModelAndView();
		System.out.println("inside getDocumentRequestData()");
		// loginSuccess.setViewName("userInfoPage");client_dashboard
		List<DocumentRequest> documentList = userService.getAllDocumentData();

		for (DocumentRequest document : documentList) {
			System.out.println(document.getName());
		}

		documentRequest.addObject("documentList", documentList);
		documentRequest.setViewName("document");
		return documentRequest;
	}

	@RequestMapping(value = "/logoutSuccessfulPage")
	public ModelAndView logoutSuccessfulPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logoutSuccessfulPage");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/documentRequests") public ModelAndView getNames() {
	 * ModelAndView modelAndView = new ModelAndView(); List<User> user =
	 * userService.getAllNames(); List l1 =new ArrayList(); for(User u:user) {
	 * String name=u.getName(); l1.add(name); } System.out.println(l1); return
	 * modelAndView; }
	 */

	//@RequestMapping(value = "/documentRequests", method = RequestMethod.GET)
	public ModelAndView getNames() {
		ModelAndView modelAndView = new ModelAndView();
		List<String> names =  userService.getAllNames();
		/*
		 * List list = new ArrayList(); for (User u : li) { String name = u.getName();
		 * list.add(name); } System.out.println(list); modelAndView.addObject("list",
		 * list);
		 */
		System.out.println(names);
		return modelAndView;
	}

}
