package Model;

import java.util.Date;

public class FresherCandidate extends Candidate {
    private Date graduationDate;
    private String  graduationRank;
    private String graduationUniversity;
    
    public FresherCandidate(){
        super();
    }

    public FresherCandidate(Date graduationDate, String graduationRank, String graduationUniversity, String id, String firstName, String lastName, Date birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.graduationUniversity = graduationUniversity;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getGraduationUniversity() {
        return graduationUniversity;
    }

    public void setUniversity(String graduationUniversity) {
        this.graduationUniversity = graduationUniversity;
    }
    
    
}
