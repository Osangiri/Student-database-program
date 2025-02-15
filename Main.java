
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase database = new StudentDatabase();
		
		
        while (true) {
            System.out.println("\n--- Student Information System ---");
            System.out.println("1. Register New Student");
            System.out.println("2. View Student Details");
            System.out.println("3. Change Course");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 
			
			switch (choice) {
				case 1:
						// Register a new student
					System.out.print("Enter Admission Number: ");
					String admissionNumber = scanner.nextLine();
					if (admissionNumber.isEmpty()) {
                           throw new IllegalArgumentException("Admission number cannot be empty!");
                      }
                    if (!admissionNumber.matches("\\d+")) {
                           throw new IllegalArgumentException("Admission number must contain only numeric digits!");
                     }
					System.out.print("Enter Name: ");
					String name = scanner.nextLine();
					if (name.isEmpty()) {
                          throw new IllegalArgumentException("Name cannot be empty!");
                      }
					System.out.print("Enter Course: ");
					String course = scanner.nextLine();
					if (course.isEmpty()) {
                           throw new IllegalArgumentException("Course cannot be empty!");
                     }
					System.out.print("Enter Grade: ");
					String grade = scanner.nextLine();
					if (grade.isEmpty()) {
                                throw new IllegalArgumentException("Grade cannot be empty!");
                      }
					
				
					System.out.print("Is this an Athlete student? (yes/no): ");
					String isAthlete = scanner.nextLine();

					if (isAthlete.equalsIgnoreCase("yes")) {
						System.out.print("Enter Sport: 1. Volleball, 2. Basketball, 3.Soccer ");
						String gamePlayed = scanner.nextLine();
                        System.out.print("Enter Years of experience: ");
                        int gameYear = scanner.nextInt();
                        scanner.nextLine();
                        
                        // add StudentAthlete to the database
                        database.addStudent(new StudentAthlete(admissionNumber, name, course, grade, gamePlayed, gameYear));
                        System.out.println("Student Athlete registered successfully!");
                
                    
                        
					} else {
							// Add regular student
						database.addStudent(new Student(admissionNumber, name, course, grade));
						System.out.println("Student registered successfully!");
					}
					database.saveChanges();
					break;

				case 2:
						// View student details
					System.out.print("Enter Admission Number: ");
					String searchAdmissionNumber = scanner.nextLine();
					Student student = database.getStudent(searchAdmissionNumber);
					if (student != null) {
						System.out.println("\n--- Student Details ---");
						System.out.println(student);
						
						if (student instanceof StudentAthlete) {
                            StudentAthlete athlete = (StudentAthlete) student;
                            athlete.displayTeam();
                            athlete.train();
                            System.out.println("Coach: " + athlete.getCoachName());
                        }
					} else {
						System.out.println("Student not found!");
						}
					break;

				case 3:
						// Change course
					System.out.print("Enter Admission Number: ");
					String changeAdmissionNumber = scanner.nextLine();
					if (database.studentExists(changeAdmissionNumber)) {
						System.out.print("Enter New Course: ");
						String newCourse = scanner.nextLine();
						database.updateCourse(changeAdmissionNumber, newCourse);
						database.saveChanges();//save to database from main
						System.out.println("Course updated successfully!");
					} else {
						System.out.println("Student not found!");
					}
					break;
				case 4:
						// View all students
					System.out.println("\n--- All Students ---");
					database.printAllStudents();
					break;

				case 5:
						// Exit the program
					System.out.println("Exiting the system. Goodbye!");
					database.saveChanges();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice! Please enter a valid option.");
				}
				
        }
    }
}
         //all citations here
/*
 * https://www.geeksforgeeks.org/crud-operations-in-student-management-system-in-java/
 * https://stackoverflow.com/questions/604424/how-to-get-an-enum-value-from-a-string-value-in-java
 * https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
 * https://www.google.com/search?q=how+to+inherit+interface+in+java&rlz=1C5CHFA_enKE1040KE1045&oq=how+do+i+inherit+inter&aqs=chrome.1.69i57j0i22i30l5j0i390i512i650l2j0i512i546l2.35298j0j9&sourceid=chrome&ie=UTF-8-AI overview
 * https://www.programiz.com/java-programming/continue-statement
 * https://chatgpt.com/share/675146d1-01c0-8008-ada7-4d0da5dfc6dc
 * https://chatgpt.com/share/675147a0-38ac-8008-80a1-bf1c1706d21d
 * I did a lot of referencing from the codes we wrote in class and the textbook
 * https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html
 


*/
