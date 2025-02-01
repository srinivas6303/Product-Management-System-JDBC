# Product Management System - JDBC

This project implements a Product Management System (PMS) using Java,and JDBC to interact with a MySQL database. 
It provides functionalities to add, retrieve, update, and delete product information.

## Features

*   **Add Product:** Adds a new product to the database.
*   **Get All Products:** Retrieves and displays all products from the database.
*   **Get Product by Name:** Retrieves and displays a product by its name.
*   **Get Product by Place:** Retrieves and displays products located at a specific place.
*   **Delete Product by Name:** Deletes a product from the database by its name.
*   **Delete All Products:** Deletes all products from the database.
*   **Out of Warranty:** Retrieves and displays products that are out of warranty based on a given year.
*   **Find by Substring:** Searches for products based on a substring in the name, type, place, or warranty year.

## Technologies Used

*   Java
*   Maven
*   JDBC (MySQL Connector/J)
*   MySQL

## Getting Started

1.  **Prerequisites:**
    *   Java Development Kit (JDK) 8 or higher
    *   Maven
    *   MySQL Server
    *   A suitable IDE (e.g., IntelliJ IDEA, Eclipse)

2.  **Clone the Repository:**

    ```bash
    git clone [https://github.com/YOUR_USERNAME/YOUR_REPOSITORY_NAME.git](https://www.google.com/search?q=https://github.com/YOUR_USERNAME/YOUR_REPOSITORY_NAME.git)
    ```

3.  **Configure Database Connection:**
    *   Open the `ProductDB.java` file.
    *   Update the `url`, `username`, and `password` variables with your MySQL database credentials.

    ```java
    String url="jdbc:mysql://localhost:3306/PMS";
    String username="root";
    String password="Srinu@4848"; // Replace with your password
    ```

4.  **Build the Project:**

    ```bash
    mvn clean install
    ```

5.  **Run the Application:**
    *  The `App.java` file contains the main method. You can run it directly from your IDE or using Maven:
    ```bash
    mvn compile exec:java -D"exec.mainClass"="com.srinivas.Product_Management.App"
    ```

6.  **Usage:**
    The `App.java` file contains example usage of the `ProductServices` class. You can modify this file to test different functionalities.

## Code Structure

*   `com.srinivas.Product_Management`: Contains the main application classes.
    *   `Product.java`: Represents the product entity (name, type, place, warranty).
    *   `ProductServices.java`: Provides the business logic for product management, using the `ProductDB` class.
    *   `ProductDB.java`: Handles database interactions using JDBC.  This class establishes the connection, executes queries, and manages the data transfer between the application and the MySQL database.
    *   `App.java`: The main application class, containing the `main` method to start the application and demonstrate usage.

## Database Schema

The database table `product` should be created with the following schema:

```sql
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    place VARCHAR(255),
    warrenty INT
);
```
![Screenshot 2025-02-01 193502](https://github.com/user-attachments/assets/30007136-916b-4832-808f-bef7307fb158)
![Screenshot 2025-02-01 194027](https://github.com/user-attachments/assets/380311d3-a766-4153-8293-9ee89974f2a7)

