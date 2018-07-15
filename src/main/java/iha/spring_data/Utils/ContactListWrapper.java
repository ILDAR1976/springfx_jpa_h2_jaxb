package iha.spring_data.Utils;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iha.spring_data.entity.Contact;
import iha.spring_data.entity.ContactList;



@SuppressWarnings("serial")
@XmlRootElement(name = "schedule")
public class ContactListWrapper implements Serializable  {
    
	private List<ContactList> contactList;
	private List<Contact> contacts;

    public ContactListWrapper() {
    	
    }

    public ContactListWrapper(List<ContactList> contactList, List<Contact> contacts) {
    	this.contactList = contactList;
    	this.contacts = contacts;
    }
    
    @XmlElement(name = "contact_list")
	public List<ContactList> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactList> contactList) {
		this.contactList = contactList;
	}
	
    @XmlElement(name = "contacts")
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	

}
