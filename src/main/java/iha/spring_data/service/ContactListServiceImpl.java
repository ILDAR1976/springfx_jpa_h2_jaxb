package iha.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iha.spring_data.entity.ContactList;
import iha.spring_data.repository.ContactListRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ContactListServiceImpl implements ContactListService {

    @Autowired
    private ContactListRepository repository;


    @Override
    public ContactList save(ContactList contactList) {
        return repository.save(contactList);
    }

    @Override
    public List<ContactList> findAll() {
        return repository.findAll();
    }
}
