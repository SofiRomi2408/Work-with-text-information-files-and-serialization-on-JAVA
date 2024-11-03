package lab3;

import java.io.Serializable;
import java.util.List;

class UserProfile1 implements Serializable {
    private static final long serialVersionUID = 1L; 
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private transient List<Message> messages;

    public UserProfile1(int id, String firstName, String lastName, String email, List<Message> messages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.messages = messages;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
