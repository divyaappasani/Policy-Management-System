package org.hcl.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.hcl.entities.Policies;
import org.hcl.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/policyregistration")
public class PolicyController {
	@Autowired
	private PolicyService policyService;

	@GetMapping("/")
	public ModelAndView showUser() {
		ModelAndView mv = new ModelAndView("policies");
		Map<String, Object> model = mv.getModel();
		Policies policy = new Policies();
		model.put("policydetails", policy);
		model.put("policiesList",policyService.getAllPolicies());
		return mv;
	}

	@PostMapping("/process")
	public String processForm(@ModelAttribute("policydetails") @Valid Policies policy, BindingResult result,@RequestParam String action,
			Model model1,Map<String, Object> model) {

		Policies policyResult=new Policies();
		if (result.hasErrors())
			return "policies";
		else {
			switch(action.toLowerCase()) {
			case "add":
				policyService.insertPolicy(policy);
				policyResult=policy;
				break;
			case "update":
				policyService.update(policy);
				policyResult=policy;
				break;
				
			case "delete":
				policyService.delete(policy.getPid());
				policyResult=new Policies();
				break;
			case "search":
				Policies searchedPolicy =policyService.getPolicy(policy.getPid());
				policyResult=searchedPolicy;
				break;
			
			}
			model.put("Policy",policyResult);
			model.put("policiesList",policyService.getAllPolicies());

			model1.addAttribute("generatedid", policy.getPolicyName() + policy.getPid());
			model1.addAttribute("message", "Your details are submitted successfully");
			return "policies";
		}

	}
}
