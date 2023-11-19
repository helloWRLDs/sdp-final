# SDP Final Project: Book Store

## Group: SE-2213
### Team Members:
- [Danil Li]
- [Seidulla Shalkharov]
- [Viktor Kossinov]


## Software Design Patterns Used:
- Singleton: Single database connection which will be used in multiple methods.
- Factory: Based on condition addition of different decorators.
- Observer: Email notification system.
- Strategy: Strategy for discount system.
- Decorator: Decorator for flex addition of multiple tags.
- Builder: Concrete creating of SQL queries.

## Frameworks used:
- Spring Boot
- MySQL

## Project Overview:
### Project Information:
Our project is a system of online bookstores designed to provide users with a convenient experience of viewing and selecting book genres.

### Project idea:
The goal of the project is to create a virtual bookstore where users will be able to get acquainted with a wide range of books with various genres

### Purpose of the work:
The purpose of this project is to introduce a fully functional online bookstore that simulates real scenarios of user interaction with dynamic book inventory.

### Work goals:
- Create an intuitive and user - friendly interface for viewing a book and choosing a genre .
- Implement various software design patterns to improve the project structure and ease of maintenance.

## Main Part:
### Features and Design Patterns:
#### Singleton Pattern:
- **Function:** DatabaseManager class that manages database connections.
- **Explanation:** The Singleton template is implemented to ensure that a single instance of DatabaseManager is used throughout the application to manage database connections.

#### Observer Pattern:
- **Feature:**  Mail Notification system 
- **Explanation:** MailNotification` class is part of a Java codebase implements the Observer design pattern for sending email notifications. The class has a constructor that sets up the JavaMail session by configuring properties such as the SMTP host, port, and authentication details using the provided email and password  If the email is sent successfully, a success message is printed to the console. Otherwise, an error message is printed with details about the exception that occurred during the email sending process.

#### Decorator Pattern:
- **Feature:** Choose a suitable genre
- **Explanation:** Decorator pattern works with Factory pattern by returning decorators. There are 6 genres of book (decorators) .This class, as part of a Decorator pattern, allows for the dynamic addition of the For example:( "Drama" tag ) to a book's existing tags. It can be combined with other decorators to extend the behavior of the Book class without modifying its code directly. Users can apply different tags to books at runtime, providing flexibility in managing and categorizing books within the system.

#### Factory Pattern:
- **Feature:** A book factory that creates various types of books.
- **Explanation:** This Factory implementation allows the BookStore application to dynamically apply different decorator types to books based on specified codes, facilitating the customization and categorization of books with various tags. The method uses a switch statement to determine the type of decorator to be applied based on the provided code. It returns the corresponding decorator instance.

#### Strategy Pattern:
- **Feature:** Discount system with changeable discount strategies.
- **Explanation:** A discount system has been developed in which various discount strategies can be applied when placing an order, using a strategy template for interchangeable discount algorithms. There are discounts on Black Friday and Holiday Discount.

#### Builder Pattern:
- **Feature:** Constructing SQL queries
- **Explanation:** This Builder implementation, specifically tailored for constructing SQL queries, enhances flexibility and maintainability in the BookStore application, enabling the dynamic creation of queries with different clauses and conditions. Methods such as select, from, where, insert_into, and value allow the construction of different parts of an SQL query. The Builder Pattern allows for the creation of complex objects with varying configurations while maintaining readability and ease of use.

### UML Diagram:

![UML Diagram](src/main/resources/static/images/java.png)


## Conclusion:
### Key Points:
- Successfully implemented various design patterns to enhance the project's architecture.
- Provided a range of features to create a comprehensive online bookstore system.

### Project Outcomes:
- Achieved a functional and modular online bookstore with a clear separation of concerns.
- Faced challenges in integrating different design patterns seamlessly.

### Future Improvements:
- Enhance the user interface for a more engaging experience.
- Expand the book inventory and explore additional features for users.
- Add more possibilities for our website.

