package Service;

import Model.Contact;

public interface ContactService {
    void addContact(Contact contact);
    void deleteContact(String id);
    void updateContact(Contact contact);
    Contact getContact(String id);

    Object getAllContacts();
}