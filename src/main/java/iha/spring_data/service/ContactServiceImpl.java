package iha.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iha.spring_data.entity.Contact;
import iha.spring_data.repository.ContactRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

	@Override
	public Contact findById(Long id) {
		return repository.findByIndex(id);
	}

	@Override
	public Contact findByIndex(Long index) {
		return repository.findByIndex(index);
	}
}
