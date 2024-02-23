package Model;


import java.util.Date;

public class InternCandidate extends Candidate {
    private String major;
    private String semester;
    private String university;
    
    public InternCandidate (){
        super();
    }

    public InternCandidate(String major, String semester, String university, String id, String firstName, String lastName, Date birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String University) {
        this.university = University;
    }
    
    
}

    