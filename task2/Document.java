package task2;

import java.util.ArrayList;
import java.util.List;

public class Files {
    private List<String> docNumber = new ArrayList<>();
    private List<String> email = new ArrayList<>();
    private List<String> telephoneNumber = new ArrayList<>();

    public void documentEmailAddition(String line) {
        email.add(line);
    }

    public void documentNumberAddition(String line) {
        docNumber.add(line);
    }

    public void documentTelephoneAddition(String line) {
        telephoneNumber.add(line);
    }

    public List<String> getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(List<String> docNumber) {
        this.docNumber = docNumber;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(List<String> telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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
