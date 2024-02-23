package Controller;

import Model.Candidate;
import Model.ExperienceCandidate;
import Model.FresherCandidate;
import Model.InternCandidate;
import View.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Menu<String> {
    ArrayList<Candidate> candidates = new ArrayList<>();
    static SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
    static String[] menu = {"1. Experience", "2. Fresher", "3. Internship", "4. Searching", "5. Exit"};
    
    public Manager() {
        super("Candidate Management System", menu);
    }
    @Override
    public void execute(int n) {
        switch(n){
                case 1:
            {
                try {
                    Manager.createCandidate(candidates, 0);
                } catch (ParseException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;

                case 2:
            {
                try {
                    Manager.createCandidate(candidates, 1);
                } catch (ParseException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;

                case 3:
            {
                try {
                    Manager.createCandidate(candidates, 2);
                } catch (ParseException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;

                case 4:
                    Manager.searchCandidate(candidates);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choosen. Please try again!!");
                
            
        }
    }
    //allow user input information common of candidate
    public static void createCandidate(ArrayList<Candidate> candidates, int type) throws ParseException {
        //loop until user don't want to create new candidate
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter birth date: ");
            Date birthDate = dateFormat.parse(Validation.checkInputString());
            System.out.print("Enter address: ");
            String address = Validation.checkInputString();
            
            System.out.print("Enter phone: ");   
            String phone = Validation.checkInputPhone();
            
            System.out.print("Enter email: ");      
            String email = Validation.checkInputEmail();
            
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            
            //check id exist or not
            if (Validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            //check user want to create new candidate or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    //allow user create experience
    public static void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkInputExprience(candidate.getBirthYear());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidates.add(new ExperienceCandidate(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create fresher
    public static void createFresher(ArrayList<Candidate> candidates, Candidate candidate) throws ParseException {
        System.out.print("Enter graduation date: ");
        Date graduationDate = dateFormat.parse(Validation.checkInputString());
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validation.checkInputGraduationRank();
        System.out.println("Enter graduation University: ");
        String graduationUniversity = Validation.checkInputString();
        candidates.add(new FresherCandidate(graduationDate, graduationRank, graduationUniversity, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create intern
    public static void createInternship (ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university: ");
        String university = Validation.checkInputString();
        candidates.add(new InternCandidate(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user search candidate by name
    public static void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof ExperienceCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof FresherCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof InternCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }


}

