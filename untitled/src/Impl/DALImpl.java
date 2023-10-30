package Impl;

import Interface.DALInterface;
import Model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DALImpl implements DALInterface {
    private List<Contact> contacts;

    public DALImpl() {
        contacts = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void deleteContact(int id) {
        Iterator<Contact> iterator = contacts.iterator();
        while (((Iterator) iterator).hasNext()) {
            Contact contact = iterator.next();
            if (contact.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void updateContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == contact.getId()) {
                contacts.set(i, contact);
                return;
            }
        }
    }

    @Override
    public List<Contact> searchContact(String keyword) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(keyword) || contact.getPhone().contains(keyword)) {
                result.add(contact);
            }
        }
        return result;
    }
}