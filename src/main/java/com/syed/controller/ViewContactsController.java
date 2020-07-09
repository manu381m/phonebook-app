package com.syed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syed.dto.Contact;
import com.syed.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService service;
	
	@GetMapping(value = "/editContact")
	public String handleEditHyperlink(@RequestParam("cid") int id, Model model) {
		Contact contact = service.getContactById(id);
		model.addAttribute("contact", contact);
		return "contactInfo";
	}
	
	@GetMapping(value = "/deleteContact")
	public String handleDeleteContact(@RequestParam("cid") int id, Model model) {
		service.deleteContact(id);	
		return "redirect:/viewContacts";
	}
}
