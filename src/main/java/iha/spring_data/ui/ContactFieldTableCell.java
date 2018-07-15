package iha.spring_data.ui;

import iha.spring_data.entity.Contact;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

@SuppressWarnings({ "restriction", "unused" })
public class ContactFieldTableCell<S, T> extends TableCell<S, T> {
	
	public static <S> Callback<TableColumn<S,Contact>, TableCell<S,Contact>> forTableColumn() {
        return item -> new ContactFieldTableCell<S,Contact>();
    }
	
	public ContactFieldTableCell() {
		super();
	}

	// --- converter
    private ObjectProperty<Contact> converter =
            new SimpleObjectProperty<Contact>(this, "converter");

    public final ObjectProperty<Contact> converterProperty() {
        return converter;
    }
    
    public final Contact getConverter() {
        return converterProperty().get();
    }
	
	 @Override public void startEdit() {
		 super.startEdit();
	 }
	 
	 @Override public void updateItem(T item, boolean empty) {
		 super.updateItem(item, false);
		 if (item !=null) {
			 this.setText(((Contact) item).getName());
		 }
	 }
	 
	 @Override public void cancelEdit() {
	        super.cancelEdit();
	 }
	 

}
