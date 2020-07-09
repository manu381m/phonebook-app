package com.syed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syed.dto.Contact;
import com.syed.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService service;

	@GetMapping(value = { "/", "/addContact" })
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";
	}

	@PostMapping(value = "/saveContact")
	public String handleSaveContactForm(Model model, @ModelAttribute("contact") Contact c,
			RedirectAttributes attribute) {
		boolean saveContact = service.saveContact(c);
		if (saveContact) {
			attribute.addFlashAttribute("succMsg", "Contact saved");
			return "redirect:/addContact";
		}
		model.addAttribute("errMsg", "Failed to save contact");
		return "contactInfo";
	}

	@GetMapping(value = "/viewContacts")
	public String handleViewContactsHyperLink(Model model) {
		List<Contact> contacts = service.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "viewContacts";
	}

}
