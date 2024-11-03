package lab3;

import java.io.Serializable;
import java.util.Date;

public class Message4 implements Serializable {
    private String subject;
    private String text;
    private transient Date date;

    public Message4() {}

    public Message4(String subject, String text, Date date) {
        this.subject = subject;
        this.text = text;
        this.date = date;
    }


    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    @Override
    public String toString() {
        return "Message{" +
                "subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
