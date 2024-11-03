package lab3;

import java.io.Serializable;
import java.util.List;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String firstName;
    private String lastName;
    

    private transient String email; 
    
    private List<Message> messages;

    public UserProfile(int id, String firstName, String lastName, String email, List<Message> messages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", messages=" + messages +
                '}';
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
