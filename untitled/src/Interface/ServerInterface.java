package Interface;

import Model.Contact;

public interface ServerInterface {
    void addContact(Contact contact);

    void deleteContact(int id);

    void updateContact(Contact contact);

    Contact searchContact(String keyword);
}