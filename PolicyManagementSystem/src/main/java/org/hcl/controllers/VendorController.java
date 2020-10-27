package org.hcl.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hcl.entities.Policies;
import org.hcl.entities.Vendor;
import org.hcl.services.VendorService;
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
@RequestMapping("/vendorregistration")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@GetMapping("/")
	public ModelAndView showVendor() {
		ModelAndView mv = new ModelAndView("vendor");
		Map<String, Object> model = mv.getModel();
		Vendor vendor = new Vendor();
		model.put("vendordetails", vendor);
		return mv;
	}

	@PostMapping("/process")
	public String processForm(@ModelAttribute("vendordetails") @Valid Vendor vendor, BindingResult result,
			 Model model) {

		if (result.hasErrors())
			return "vendor";
		else {
			vendorService.insertVendor(vendor);
			
			model.addAttribute("message","Your details are submitted successfully");
			return "vendor-confirm";
		}

	}
	@RequestMapping(value="/processlogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String getLoginpage(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result,
			HttpServletRequest request, Model model) {
		Vendor validVendor = vendorService.verifyVendor(vendor);
		if (validVendor != null) {
			HttpSession session = request.getSession();
			session.setAttribute("validVendor", validVendor);
			model.addAttribute("validVendor", session.getAttribute("validVendor"));
			return "vendor-confirm";
		}
		else {
		return "vendor-login";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,RedirectAttributes redirectAttributes) {
	HttpSession session = request.getSession(false);
	session.invalidate();
	redirectAttributes.addFlashAttribute("message","you are sucessfully logged out");
	return"redirect:/";
	}

}
