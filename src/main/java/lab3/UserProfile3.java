package lab3;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserProfile3 implements Serializable {
    private static final long serialVersionUID = 1L; 

    @Expose
    private int id;

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose(serialize = false, deserialize = false)
    private String email;

    @Expose 
    private List<Message3> messages;

    public UserProfile3(int id, String firstName, String lastName, String email, List<Message3> messages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.messages = messages != null ? messages : new ArrayList<>(); 
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

    public List<Message3> getMessages() {
        return messages != null ? messages : new ArrayList<>(); 
    }
}
