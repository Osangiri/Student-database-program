
# FinalCS1- Student Information System
For my final project, I decided to go with a student information System that is entirely text-based and does not require any use of a Graphic User Interface. This program allows users to register students, view student details, change courses, and view all students. The system supports regular students and student-athletes. I did not require any special installation for my program, no special configuration is needed, you just run the main class and follow the on-screen prompts to interact with the system. I incorporated a lot of concepts we learned throughout the course including:
 - Variables and Methods (primitive types, parameters, return types, overloading)
  - If/Else (ternary if, else if, nested if, inequalities, ==, equals())
  - Boolean logic
  - Loops (for, while, do-while, for-each)
  - Files and Scanners
  - Try/Catch
  - Arrays
  - Custom Objects, Inheritance, Interfaces, and Polymorphism
  - Switch
  - Enumerated types

# PROJECT BREAKDOWN
I have a total of 9 Classes:
   - Main
   - Student
   - StudentDatabase
   - StudentAthlete
   - Athlete
   - Basketball
   - Volleyball
   - Soccer
   - GAMES<br>
The <b>main method</b> contains the program's main interface, this is where all the display questions are asked, and different objects are called for different tasks. I used scanners to take the user's input. I also use Switch for the most part because it's inconvenient and easy to use. I used plenty of if-else statements to perform different tasks.<br>
The <b>Student method</b> contains a list of fields for students and accessors for every field. There is also a getter for the  course because there is an option to change students course in the main.<br>
The <b>Student Database</b> contains different methods to add new students to the database, retrieve by admission, update course for a student, save to file, load from file, and print all students.I used a lot of arrays to do most of these.<br>
The <b>Student Athlete</b> was a great addition to display the use of inheritance and interfaces.It extends students and implements Athlete<br>
The <b>Athlete</b> This is the interface that takes all games(basketball, soccer and volleyball)<br>
The <b>Basketball,soccer and Volleball </b> implement the Athlete interface for specific sports
The <b>Games</b> This class has enumerated types for use in the Athlete Interface.




One of the biggest problems I faced was rewriting a certain command twice in different methods and having issues with debugging.<br>
I also worked with so many different classes and I would easily get mixed up.<br>
I also had a couple of issues saving student athletes twice.<br>
All the citations are in the code main class.
# Conclusion
This project served as a showcase of skills I learned throughout the course.
Run the code from the main and Execute.<br>
<b> This a nice view of the terminal when I run the code and interact with the system</b>

![Screen Shot 2024-12-04 at 14 13 21](https://github.com/user-attachments/assets/6935bacb-3273-4601-abf1-031b141944d5)

