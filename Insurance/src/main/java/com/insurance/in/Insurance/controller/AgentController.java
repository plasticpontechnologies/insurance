package com.insurance.in.Insurance.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.in.Insurance.model.CompletedSubmissions;
import com.insurance.in.Insurance.model.Policies;
import com.insurance.in.Insurance.service.AgentService;

@Controller
public class AgentController {

	@Autowired
	AgentService agentService;

	@RequestMapping(value = "/pendingtasks")
	public ModelAndView getDocumentRequestData() {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("inside getDocumentRequestData()");
		// loginSuccess.setViewName("userInfoPage");client_dashboard
		List<Policies> policies = agentService.getAllDocumentData();

		for (Policies p : policies) {
			System.out.println(p);
		}
		/*
		 * documentRequest.addObject("documentList", documentList);
		 * documentRequest.setViewName("document");
		 */
		return modelAndView;
	}

	@RequestMapping(value = "/completedsubmissions")
	public ModelAndView getCompletedSubmissions() {
		ModelAndView modelAndview = new ModelAndView();
		System.out.println("inside getDocumentRequestData()");
		// loginSuccess.setViewName("userInfoPage");client_dashboard
		List<CompletedSubmissions> completedSubmissions = agentService.getCompletedSubmissions();

		for (CompletedSubmissions p : completedSubmissions) {
			System.out.println(p);
		}
		/*
		 * documentRequest.addObject("documentList", documentList);
		 * documentRequest.setViewName("document");
		 */
		return modelAndview ;
	}

	@RequestMapping(value = "/policiesSold")
	public ModelAndView getPoliciesSold() {
		ModelAndView modelAndView = new ModelAndView();
		List list = agentService.getPoliciesSold();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			/*
			 * List<Policies> l1 = (List<Policies>) itr.next(); if (itr.next().equals(l1)) {
			 * List<Policies> p1 = (List<Policies>) itr.next(); for (Policies policies : p1)
			 * { System.out.println(policies); } }
			 */
			System.out.println(itr.next());
		}
		return modelAndView;
	}

}
