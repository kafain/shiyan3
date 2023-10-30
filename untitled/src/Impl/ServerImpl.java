package Impl;

import Interface.DALInterface;
import Interface.ServerInterface;
import Model.Contact;

import java.util.List;

public class ServerImpl implements ServerInterface {
    private DALInterface dal;

    public ServerImpl(DALInterface dal) {
        this.dal = dal;
    }

    @Override
    public void addContact(Contact contact) {
        dal.addContact(contact);
    }

    @Override
    public void deleteContact(int id) {
        dal.deleteContact(id);
    }

    @Override
    public void updateContact(Contact contact) {
        dal.updateContact(contact);
    }

    @Override
    public Contact searchContact(String keyword) {
        List<Contact> contacts = dal.searchContact(keyword);
        if (!((List) contacts).isEmpty()) {
            return contacts.get(0); // 返回第一个匹配的联系人
        } else {
            return null;
        }
    }
}