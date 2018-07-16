package iha.spring_data.Utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Utils {
	
	public static void saveObjects(File file, ContactListWrapper wrapper) throws JAXBException {
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(ContactListWrapper.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(wrapper, file);
	}
	
	public static ContactListWrapper loadObjects(File file, ContactListWrapper wrapper) {
		
		try {
	        JAXBContext context = JAXBContext
	                .newInstance(ContactListWrapper.class);
	        Unmarshaller um = context.createUnmarshaller();
	        wrapper = (ContactListWrapper) um.unmarshal(file);
		} catch (Exception e) { 
	    	System.out.println(e);
	    }
		
		return wrapper;
	}

	public static File getContactsFile() {
		Path path = Paths.get("./xml");
		if (!(Files.exists(path) && Files.isDirectory(path))) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new File(path.toString() +  "/contacts.xml");
		
	}
}
