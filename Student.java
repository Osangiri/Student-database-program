
public class Student {
    private String admissionNumber;
    private String name;
    private String course;
    private String grade;

    // Constructor
    public Student(String admissionNumber, String name, String course, String grade) {
        this.admissionNumber = admissionNumber;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    // Getters
    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    // Setter for course change
    public void setCourse(String course) {
        this.course = course;
    }

    
    public String toString() {
        return "Admission Number: " + admissionNumber + "\nName: " + name + "\nCourse: " + course + "\nGrade: " + grade;
    }
}
