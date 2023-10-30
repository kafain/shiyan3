package Impl;

import Interface.ClientInterface;
import Interface.ServerInterface;
import Model.Contact;

public class ClientImpl implements ClientInterface {
    private ServerInterface server;

    public ClientImpl(ServerInterface server) {
        this.server = server;
    }

    @Override
    public void addContact(int id,String name, String phone) {
        Contact contact = new Contact(id, name, phone);
        server.addContact(contact);
    }

    @Override
    public void deleteContact(int id) {
        server.deleteContact(id);
    }

    @Override
    public void updateContact(int id, String name, String phone) {
        Contact contact = new Contact(id, name, phone);
        server.updateContact(contact);
    }

    @Override
    public void searchContact(String keyword) {
        Contact contact = server.searchContact(keyword);
        if (contact != null) {
            // 显示联系人信息
            System.out.println("Model.Contact found: " + contact.getName() + ", " + contact.getPhone() + ", " );
        } else {
            System.out.println("Model.Contact not found.");
        }
    }
}