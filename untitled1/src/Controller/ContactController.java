package Controller;

import Model.Contact;
import Service.ContactService;

import Impl.ContactServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactController extends HttpServlet {
    private ContactService contactService;

    public ContactController() {
        contactService = new ContactServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("contacts", contactService.getAllContacts());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/contacts.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        if (action.equals("edit")) {
            String id = req.getParameter("id");
            Contact contact = contactService.getContact(id);
            req.setAttribute("contact", contact);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-contact.jsp");
            dispatcher.forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("add")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String phoneNumber = req.getParameter("phoneNumber");

            Contact contact = new Contact(id, name, phoneNumber);
            contactService.addContact(contact);
        } else if (action.equals("update")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String phoneNumber = req.getParameter("phoneNumber");

            Contact contact = new Contact(id, name, phoneNumber);
            contactService.updateContact(contact);
        } else if (action.equals("delete")) {
            String id = req.getParameter("id");
            contactService.deleteContact(id);
        }
        resp.sendRedirect(req.getContextPath() + "/contacts");
    }
}