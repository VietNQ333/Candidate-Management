package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Candidate {

    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String phone;
    private String email;
    private int typeCandidate;

    public Candidate() {
    }

    public Candidate(String id, String firstName, String lastName, Date birthDate, String address, String phone, String email, int typeCandidate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.typeCandidate = typeCandidate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
    public int getBirthYear() {
        // Chuyển đổi Date sang LocalDate
        LocalDate localDateOfBirth = getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Lấy năm từ LocalDate
        return localDateOfBirth.getYear();
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeCandidate() {
        return typeCandidate;
    }

    public void setTypeCandidate(int typeCandidate) {
        this.typeCandidate = typeCandidate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        return this.firstName + this.lastName + "|" + this.birthDate + "|"
                + this.address + "|" + this.phone + "|" + this.email + "|"
                + this.typeCandidate;
    }
}

