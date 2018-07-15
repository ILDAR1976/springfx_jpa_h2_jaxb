package iha.spring_data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import iha.spring_data.entity.ContactList;

import java.util.List;


@Transactional(propagation = Propagation.MANDATORY)
public interface ContactListRepository extends CrudRepository<ContactList, Long> {

    List<ContactList> findAll();

}
