package Interface;

public interface ClientInterface {
    void addContact(int id,String name, String phone);

    void deleteContact(int id);

    void updateContact(int id, String name, String phone);

    void searchContact(String keyword);
}