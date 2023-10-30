package Interface;

import Model.Contact;

import java.util.List;

public interface DALInterface {
    void addContact(Contact contact);

    void deleteContact(int id);

    void updateContact(Contact contact);

    List<Contact> searchContact(String keyword);
}