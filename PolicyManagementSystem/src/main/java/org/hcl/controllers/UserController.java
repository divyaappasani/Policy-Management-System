package org.hcl.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hcl.entities.Policies;
import org.hcl.entities.User;
import org.hcl.services.PolicyService;
import org.hcl.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/userregistration")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PolicyService policyService;

	@GetMapping("/")
	public ModelAndView showUser() {
		ModelAndView mv = new ModelAndView("user");
		Map<String, Object> model = mv.getModel();
		User user = new User();
		model.put("userdetails", user);
		return mv;
	}

	@PostMapping("/process")
	public String processForm(@ModelAttribute("userdetails") @Valid User user, BindingResult result, Model model) {

		if (result.hasErrors())
			return "user";
		else {
			userService.insertUser(user);
			model.addAttribute("generatedid", user.getUserName() + user.getuId());
			model.addAttribute("message", "Your details are submitted successfully");
			return "user";
		}

	}

	@RequestMapping(value = "/processlogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String getLoginpage(@ModelAttribute("user") @Valid User user, BindingResult result,
			HttpServletRequest request, Model model) {
		User validUser = userService.verifyUser(user);
		if (validUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("validUser", validUser);
			model.addAttribute("validUser", session.getAttribute("validUser"));
			return "user-confirm";
		}
		return "login";

	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		redirectAttributes.addFlashAttribute("message", "you are sucessfully logged out");
		return "redirect:/";
	}

	@GetMapping("/policydetails")
	public String getPolicyDetails(Model model) {

		List<Policies> policies = policyService.getAllPolicies();
		model.addAttribute("policydetails", policies);
		return "user-confirm";
	}

	@PostMapping("/getpolicy")
	public String getForm() {

		return "policy-success";
	}
}
