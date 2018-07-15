package iha.spring_data.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table
public class Contact implements Serializable {

	private static final long serialVersionUID = -3244421435144439340L;
	@XmlElement
	@XmlID
    @XmlJavaTypeAdapter(WSLongAdapter.class)
	private Long id;
	@XmlElement
	private String name;
	@XmlElementWrapper(name="contactList")
   
	private Set<ContactList> contactList = new HashSet<ContactList>();

	public Contact() {
	}

	public Contact(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contact")
	public Set<ContactList> getContactList() {
		return contactList;
	}

	public void setContactList(Set<ContactList> contactList) {
		this.contactList = contactList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
