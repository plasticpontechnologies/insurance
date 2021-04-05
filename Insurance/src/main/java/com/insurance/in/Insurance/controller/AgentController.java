package com.insurance.in.Insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.in.Insurance.model.Policies;
import com.insurance.in.Insurance.service.AgentService;

@Controller
public class AgentController {

	@Autowired
	AgentService agentService;

	 @RequestMapping(value = "/pendingtasks")
		public  ModelAndView getDocumentRequestData() {
			ModelAndView documentRequest = new ModelAndView();
			System.out.println("inside getDocumentRequestData()");
			// loginSuccess.setViewName("userInfoPage");client_dashboard
			List<Policies> documentList = agentService.getAllDocumentData();
			
			for(Policies p:documentList) {
				System.out.println(p);
			}
			/*
			 * documentRequest.addObject("documentList", documentList);
			 * documentRequest.setViewName("document");
			 */
			return documentRequest;
		}
	

}
