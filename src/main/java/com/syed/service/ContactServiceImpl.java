package com.syed.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syed.dto.Contact;
import com.syed.entity.ContactEntity;
import com.syed.repository.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDtlsRepository repository;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity contactEntity = repository.save(entity);
		return contactEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities = repository.findAll();
		
//		List<Contact> contacts = new ArrayList<>();
//		for (ContactEntity entity : entities) {
//			Contact contact = new Contact();
//			BeanUtils.copyProperties(entity, contact);
//			contacts.add(contact);
//		}
		return entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
	}

	@Override
	public Contact getContactById(Integer id) {
		Optional<ContactEntity> entity = repository.findById(id);
		ContactEntity contactEntity = entity.get();
		if(contactEntity !=null) {
		Contact c = new Contact();
		BeanUtils.copyProperties(contactEntity, c);
			return c;
		}
		return null;
	}

	@Override
	public boolean deleteContact(Integer id) {
		repository.deleteById(id);
		return true;
	}

}
