# Course Registration System (CRS)
# Introduction
The Course Registration System (CRS) is a web-based application developed to streamline the course registration process at Maharishi International University. The system is designed to improve communication regarding registration deadlines, efficiently manage course and student information, and handle various aspects of course registration, including prerequisites and waitlists.

# Objective
Develop a comprehensive system to manage course registration.
Improve communication about registration deadlines.
Efficiently manage course and student information.

# Target Users
- Students: To enroll in courses, manage their schedules, and receive notifications.
- Registrar Faculty: To send notifications, manage course information, and handle student registrations.
- Administrative Staff: To manage the database, update student and course information, and generate reports.

# Features
# Student Use-Cases
- Login: Secure login using email and password.
- Password Reset: Option to reset the password if forgotten.
- Enroll/Drop Courses: Ability to enroll in or drop courses based on prerequisites and availability.
- View Schedule: Access to view the current course schedule.

# Registrar Faculty Use-Cases
- Send Notifications: Send email notifications to students about registration deadlines.
- Schedule Notifications: Ability to schedule notifications to be sent at specific times.

# Admin Use-Cases
- Retrieve Student List: Retrieve a list of all students enrolled in a particular course.
- Database Management: Access and update course and student information.

# System Scenarios
# Scenario 1: Student Enrollment and Course Management
1. Log In and View Courses: Students log in to view available courses.
2. Filter and Select Courses: Students filter courses by subject and level, view details, and select courses.
3. Enroll in Course: Students enroll in a selected course after meeting prerequisites.
4. Review Enrolled Courses: Students can review all currently enrolled courses and their details.
   
# Scenario 2: Notification Sending by Registrar Faculty
1. Send Notification: Registrar logs in and sends a notification to students.
2. Customize Notifications: Notifications can be customized for specific student groups.
3. Track and Schedule Notifications: Track the success rate of notifications and schedule future ones.
   
# Scenario 3: Database Management by Admin
1. Update Course Information: Admins can update course information in the system.
2. Retrieve Student List: Admins can retrieve lists of students enrolled in specific courses.
3. Generate Reports: Admins can generate and export reports for further analysis.
   
# Architecture & Design
The system is structured using a layered architecture with the following components:

- Controller Layer: Handles incoming HTTP requests and maps them to the appropriate service methods.
- Service Layer: Contains the business logic for processing data and interacting with the database.
- Repository Layer: Manages data persistence using JPA and interacts with the underlying database.
  
# Diagrams Included in the Project:
- Use Case Diagram: Illustrates the different actors and their interactions with the system.
- Class Diagram: Shows the structure of the system classes and their relationships.
- Database Design (E-R Diagram): Visualizes the database schema and relationships between entities.
- Sequence Diagram: Depicts the sequence of operations for the student enrollment process.
  
# Technologies Used
- Spring Boot: For developing the backend services.
- Thymeleaf: For building the front-end templates.
- Spring Security: For managing authentication and authorization.
- JPA/Hibernate: For database interactions.
- H2 Database: For in-memory testing and development.
- MySQL/PostgreSQL: For production database management.

# Installation & Setup
1. Clone the Repository:
   
   git clone https://github.com/your-username/course-registration-system.git
   
   cd course-registration-system
2. Configure the Database:
   Update the application.properties file with your database credentials.
3. Build and Run the Application:

   mvn clean install
   
   mvn spring-boot:run
4. Access the Application:
   Open your browser and navigate to http://localhost:8888.

   
# Contributors
- Adonay Gebrerufael
- Tsigereda Hagos
- Samsom Michael
- Henok Gebremichael
- Wycliff Kasirye

# License
This project is licensed under the MIT License - see the LICENSE file for details.
