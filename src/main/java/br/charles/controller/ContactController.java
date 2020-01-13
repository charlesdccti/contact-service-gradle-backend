package br.charles.controller;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.charles.model.Contact;
import br.charles.repository.ContactRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Contact> listContacts() {
		return contactRepository.findAll();
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Contact> findById(@PathVariable Integer id) {
		return contactRepository.findById(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Contact createContact(@RequestBody Contact contact) {
		
		try {
			contactRepository.save(contact);
		} catch (Exception e) {
			System.out.println("\n\n======== erro no email ========");
		    System.out.println(e.getMessage());
			System.out.println("\n\n");
			throw new ConstraintViolationException("O campo 'email' não é válido.", null);
		}
		
		return contactRepository.save(contact);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Contact updateContact(@PathVariable String id, @RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable Integer id) {
		 contactRepository.deleteById(id);
	}
}