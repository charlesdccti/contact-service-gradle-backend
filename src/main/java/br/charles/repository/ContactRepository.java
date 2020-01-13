package br.charles.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.charles.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {

}
