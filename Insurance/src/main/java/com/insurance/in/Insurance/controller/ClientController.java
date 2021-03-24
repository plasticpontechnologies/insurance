package com.insurance.in.Insurance.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.in.Insurance.model.BuyPolicy;
import com.insurance.in.Insurance.service.ClientService;

@Controller
public class ClientController 
{
	
	@Autowired
	ClientService clientService;

	@RequestMapping("/getCarView")
	public ModelAndView getCarView() 
	{
		ModelAndView carView = new ModelAndView();
		BuyPolicy carPolicy = new BuyPolicy();
		carView.addObject("carPolicy", carPolicy);
		carView.setViewName("car_reg");
		return carView;
	}
	
	@RequestMapping("/getBikeView")
	public ModelAndView getBikeView() 
	{
		ModelAndView bikeView = new ModelAndView();
		BuyPolicy bikePolicy = new BuyPolicy();
		bikeView.addObject("bikePolicy", bikePolicy);
		bikeView.setViewName("Bike_register");
		return bikeView;
	}
	
	@RequestMapping("/getMobileView")
	public ModelAndView getMobileView() 
	{
		ModelAndView mobileView = new ModelAndView();
		BuyPolicy mobilePolicy = new BuyPolicy();
		mobileView.addObject("mobilePolicy", mobilePolicy);
		mobileView.setViewName("mobile_reg");
		return mobileView;
	}
	
	@RequestMapping("/getGoldView")
	public ModelAndView getGoldView() 
	{
		ModelAndView goldView = new ModelAndView();
		BuyPolicy goldPolicy = new BuyPolicy();
		goldView.addObject("goldPolicy", goldPolicy);
		goldView.setViewName("gold_reg");
		return goldView;
	}
	
	@RequestMapping("/general")
	public ModelAndView getGeneralView() 
	{
		ModelAndView generalView = new ModelAndView();
		generalView.setViewName("general");
		return generalView;
	}
	
	@RequestMapping("/life")
	public ModelAndView getLifeView() 
	{
		ModelAndView generalView = new ModelAndView();
		generalView.setViewName("life");
		return generalView;
	}
	
	@RequestMapping(value = "/buyPolicy",method = RequestMethod.POST)
	public ModelAndView buyPolicy(@ModelAttribute("bikePolicy") BuyPolicy bikePolicy,Principal principal) 
	{
		ModelAndView buyPolicy = new ModelAndView();
		String name = principal.getName();
		bikePolicy.setUserId(name);
		bikePolicy.setPolicycategory("General");
		bikePolicy.setPolicytype("Bike");
		int savedRows = clientService.buyPolicy(bikePolicy);
		if(savedRows > 0) 
		{
			buyPolicy.setViewName("success");
		}
		else 
		{
			buyPolicy.setViewName("success");	
		}		
		return buyPolicy;
	}
	
	@RequestMapping(value = "/buyCarPolicy",method = RequestMethod.POST)
	public ModelAndView buyCarPolicy(@ModelAttribute("carPolicy") BuyPolicy carPolicy,Principal principal) 
	{
		ModelAndView buyPolicy = new ModelAndView();
		String name = principal.getName();
		carPolicy.setUserId(name);
		carPolicy.setPolicycategory("General");
		carPolicy.setPolicytype("Car");
		int savedRows = clientService.buyPolicy(carPolicy);
		if(savedRows > 0) 
		{
			buyPolicy.setViewName("success");
		}
		else
		{
			buyPolicy.setViewName("success");	
		}		
		return buyPolicy;
	}
	
	@RequestMapping(value = "/buyMobilePolicy",method = RequestMethod.POST)
	public ModelAndView buyMobilePolicy(@ModelAttribute("mobilePolicy") BuyPolicy mobilePolicy,Principal principal) {
		ModelAndView buyPolicy = new ModelAndView();
		String name = principal.getName();
		mobilePolicy.setUserId(name);
		mobilePolicy.setPolicycategory("General");
		mobilePolicy.setPolicytype("Mobile");
		int savedRows = clientService.buyPolicy(mobilePolicy);
		if(savedRows > 0) {
			buyPolicy.setViewName("success");
		}else {
			buyPolicy.setViewName("success");	
		}		
		return buyPolicy;
	}
	
	@RequestMapping(value = "/buyGoldPolicy",method = RequestMethod.POST)
	public ModelAndView buyGoldPolicy(@ModelAttribute("goldPolicy") BuyPolicy goldPolicy,Principal principal) {
		ModelAndView buyPolicy = new ModelAndView();
		String name = principal.getName();
		goldPolicy.setUserId(name);
		goldPolicy.setPolicycategory("General");
		goldPolicy.setPolicytype("Gold");
		int savedRows = clientService.buyPolicy(goldPolicy);
		if(savedRows > 0) {
			buyPolicy.setViewName("success");
		}else {
			buyPolicy.setViewName("success");	
		}		
		return buyPolicy;
	}


}
