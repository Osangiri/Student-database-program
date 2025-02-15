
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;


public class StudentDatabase {
    private Student[] students;//array to store students
    private int count = 0; 
    
    private final int MAX_STUDENTS = 500000;
	private final String filePath = "students.txt";
	
	public StudentDatabase() {
		students = new Student[MAX_STUDENTS];
        loadFromFile();
    }
    // Add a new student to the database
    public void addStudent(Student student) {
        if (count < MAX_STUDENTS) {
            students[count++] = student;
            
        }else {
            System.out.println("Database is full!");
        }
    }
    

    // Retrieve student by admission number
    public Student getStudent(String admissionNumber) {
        for (int i = 0; i < count; i++) {
            if (students[i].getAdmissionNumber().equals(admissionNumber)) {
                return students[i];
            }
        }
        return null; // when student not found
    }


    // Update course for a student
    public boolean updateCourse(String admissionNumber, String newCourse) {
        for (int i = 0; i < count; i++) {
            if (students[i].getAdmissionNumber().equals(admissionNumber)) {
                students[i].setCourse(newCourse);//update course
                
                return true;
            }
        }
        return false;
	}
	//save to file
    private void saveToFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int i = 0; i < count; i++) {
                Student student = students[i];
                if (student instanceof StudentAthlete) {
                    StudentAthlete athlete = (StudentAthlete) student;
                    writer.println(athlete.getAdmissionNumber() + "," +
                                   athlete.getName() + "," +
                                   athlete.getCourse() + "," +
                                   athlete.getGrade() + "," +
                                   athlete.getGamePlayed() + "," +
                                   athlete.getGameYear());//save studenr-athlete with the two added fields
                }else {
                    writer.println(student.getAdmissionNumber() + "," +
                                   student.getName() + "," +
                                   student.getCourse() + "," +
                                   student.getGrade());//save regular student
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
	}

   
    // Load student data from the file
    private void loadFromFile() {
        try {
        File file = new File(filePath);
        if (!file.exists())
         return;  // Exit if file doesn't exist
        
        String content = new String(Files.readAllBytes(file.toPath())); // Read all content
        String[] lines = content.split("\n");  // Split by lines
        
        for (String line : lines) {
			if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (studentExists(parts[0])) continue;//added this to prevent duplicates
            if (parts.length == 4) {
                students[count++] = new Student(parts[0], parts[1], parts[2], parts[3]);
            } else if (parts.length == 6) {
				
                students[count++] = new StudentAthlete(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading from file: " + e.getMessage());
    }
}
	public void printAllStudents() {
        if (count == 0) {
        System.out.println("No students in the database.");
       }else {
			for (int i = 0; i < count; i++) {
				if (students[i] instanceof StudentAthlete) {
					StudentAthlete athlete = (StudentAthlete) students[i];
					System.out.println(athlete);  // This will print the complete athlete info
				}else {
					System.out.println(students[i]);  // This will print regular student info
				}
				System.out.println("-------------------------");
			}
		}
	}
    // Check if a student exists
    public boolean studentExists(String admissionNumber) {
        for (int i = 0; i < count; i++) {
            if (students[i].getAdmissionNumber().equals(admissionNumber)) {
                return true;
            }
        }
        return false;
    }
    public void saveChanges() {
		saveToFile();  // Save all changes at once
}
    
}
    
   
//https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
//https://www.programiz.com/java-programming/continue-statement
//https://chatgpt.com/share/675147a0-38ac-8008-80a1-bf1c1706d21d
//https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html
