package com.syed.service;

import java.util.List;

import com.syed.dto.Contact;

public interface ContactService {
	
	boolean saveContact(Contact c);
	
	List<Contact> getAllContacts();
	
	Contact getContactById(Integer id);
	
	boolean deleteContact(Integer id);

}
