package Model;

public class Contact {
    private String id;
    private String name;
    private String phoneNumber;

    public Contact(String id, String name, String phoneNumber) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // 在需要的情况下，可以覆盖equals()和hashCode()方法
}