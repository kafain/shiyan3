package Impl;

import Model.Contact;
import Service.ContactService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactServiceImpl implements ContactService {
    private Map<String, Contact> contacts;

    public ContactServiceImpl() {
        contacts = new HashMap<>();
    }

    @Override
    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    @Override
    public void deleteContact(String id) {
        contacts.remove(id);
    }

    @Override
    public void updateContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    @Override
    public Contact getContact(String id) {
        return contacts.get(id);
    }
    @Override
    public Object getAllContacts(){
        return contacts;
    }
}