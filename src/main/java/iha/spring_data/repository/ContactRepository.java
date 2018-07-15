package iha.spring_data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import iha.spring_data.entity.Contact;

import java.util.List;

/**
 * Date: 27.08.15
 * Time: 17:21
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findAll();
    @Query(value="select c from Contact c where c.id=:index")
    Contact findByIndex(@Param("index")Long index);
    
}
