package iha.spring_data.service;

import iha.spring_data.entity.ContactList;

import java.util.List;

public interface ContactListService {

    ContactList save(ContactList contactList);

    List<ContactList> findAll();

}
