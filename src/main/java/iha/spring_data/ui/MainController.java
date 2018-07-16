package iha.spring_data.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import iha.spring_data.Utils.ContactListWrapper;
import iha.spring_data.entity.Contact;
import iha.spring_data.entity.ContactList;
import iha.spring_data.service.ContactListService;
import iha.spring_data.service.ContactService;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static iha.spring_data.Utils.Utils.*;

@SuppressWarnings({ "restriction" })
public class MainController {

    @SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired 
    private ContactListService contactListService;

    @Autowired 
    private ContactService contactService;
    
    @FXML private TableView<ContactList> table;
    @FXML private TextField txtName;
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;

    private ObservableList<ContactList> data;
    
    @FXML
    public void initialize() {
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() throws JAXBException {
    	
    	switch (1) {
		case 1:
			getTestData();
			break;

		case 2:
			createTestData();
			break;
		}
    	
    	
        List<ContactList> contactLists = contactListService.findAll();
        data = FXCollections.observableArrayList(contactLists);

        TableColumn<ContactList, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<ContactList, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<ContactList, Contact> contactColumn = new TableColumn<>("contact");
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        contactColumn.setCellFactory(ContactFieldTableCell.forTableColumn());
        table.getColumns().setAll(idColumn, nameColumn, contactColumn);

        table.setItems(data);
    }

    @FXML
    public void addContact() {
        ContactList ContactList = new ContactList(txtName.getText());
        contactListService.save(ContactList);
        data.add(ContactList);

        txtName.setText("");
    }

    private void createTestData() {
    	List<ContactList> shedule = new ArrayList<>();
    	List<Contact> contacts = new ArrayList<>();
    	
    	ContactList cl = new ContactList("First");
    	Contact c = new Contact("Ivan");
    	
    	cl.setContact(c);
    	c.getContactList().add(cl);
    	
    	contactService.save(c);
    	contactListService.save(cl);
    
    	cl = new ContactList("Second");
    	
    	cl.setContact(contactService.findByIndex(c.getId()));
    	c.getContactList().add(cl);
    	
    	contactListService.save(cl);

    	cl = new ContactList("Third");
    	c = new Contact("Robby");

    	cl.setContact(c);
    	c.getContactList().add(cl);
  	
    	contactService.save(c);
    	contactListService.save(cl);
    	
    	shedule.addAll(contactListService.findAll());
    	contacts.addAll(contactService.findAll());
    	
    	ContactListWrapper wrapper = new ContactListWrapper();
		wrapper.setContactList(shedule);
		wrapper.setContacts(contacts);
		
		try {
			File file = getContactsFile();
			saveObjects(file, wrapper);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		logger.info("Data saved");
    }
    
    private  void getTestData() throws JAXBException {
		File file = getContactsFile();
		ContactListWrapper wrapper = new ContactListWrapper();
		wrapper = loadObjects(file, wrapper);
		
		wrapper.getContactList().stream().forEach(e ->{
			Contact cn = e.getContact();
		    cn.getContactList().clear();
		    ContactList cl = e;
		    cl.setContact(cn);
		    contactService.save(cn);
			contactListService.save(cl);
			
		});
		
		
		logger.info("Data loaded");

    }
}
