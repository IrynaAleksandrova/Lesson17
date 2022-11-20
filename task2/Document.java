package task2;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<String> docNumber = new ArrayList<>();
    private final List<String> email = new ArrayList<>();
    private final List<String> telephoneNumber = new ArrayList<>();

    public void documentEmailAddition(String line) {
        email.add(line);
    }

    public void documentNumberAddition(String line) {
        docNumber.add(line);
    }

    public void documentTelephoneAddition(String line) {
        telephoneNumber.add(line);
    }

    @Override
    public String toString() {
        return "Document{" +
                "docNumber=" + docNumber +
                ", email=" + email +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }
}
