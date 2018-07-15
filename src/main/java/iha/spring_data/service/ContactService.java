package iha.spring_data.service;

import iha.spring_data.entity.Contact;

import java.util.List;

/**
 * Date: 27.08.15
 * Time: 17:22
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
public interface ContactService {

    Contact save(Contact contact);
    Contact findById(Long id);
    Contact findByIndex(Long index);
    List<Contact> findAll();
 

}
