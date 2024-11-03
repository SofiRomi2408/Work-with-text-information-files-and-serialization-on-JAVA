package lab3;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;

public class Message3 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Expose
    private String subject;

    @Expose
    private String text;

    @Expose
    private Date date;

    public Message3(String subject, String text, Date date) {
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
