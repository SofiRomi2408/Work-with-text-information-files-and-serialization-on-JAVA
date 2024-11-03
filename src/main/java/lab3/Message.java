package lab3;
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String subject;
    private String text;
    private Date date;

    public Message(String subject, String text, Date date) {
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
    public String getSubject() {
        return subject;
    }
    
    public String getText() {
        return text;
    }
    
    public Date getDate() {
        return date;
    }
    
}
