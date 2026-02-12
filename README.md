# 📚 Library Management System

A lightweight, pure Java console-based application for managing library books without any external dependencies or databases. Built with core Java principles following clean OOP architecture.

---

## 🎯 Overview

The Library Management System is an educational project designed to demonstrate core Java concepts including Object-Oriented Programming, ArrayList collections, Scanner-based user input, and clean code structure. It provides a complete end-to-end library book management solution through an interactive console interface.

---

## 📂 Project Structure

```
Library_Management_System/
│
├── src/
│   ├── model/
│   │   └── Book.java                    # Book entity class
│   │
│   ├── service/
│   │   └── LibraryService.java          # Business logic & data management
│   │
│   ├── util/
│   │   └── InputHelper.java             # Input handling utility
│   │
│   └── Main.java                        # Application entry point
│
└── README.md                            # Project documentation
```

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| **Add Book** | Create and register new books with unique IDs |
| **View All Books** | Display complete list of all books with availability status |
| **Search Book** | Find specific book by ID with detailed information |
| **Issue Book** | Mark book as issued (unavailable) |
| **Return Book** | Mark book as returned (available) |
| **Delete Book** | Remove books from the library permanently |
| **Menu-Driven Interface** | User-friendly interactive console menu |
| **Sample Data** | Pre-loaded 5 books for testing |
| **Input Validation** | Error handling for invalid inputs |

---

## 💻 System Requirements

- **Java Version**: Java 8 or higher (JDK 1.8+)
- **Operating System**: Windows, Linux, macOS
- **RAM**: Minimum 512 MB
- **External Dependencies**: None (pure Core Java)

---

## 🚀 Quick Start

### Step 1: Navigate to Source Directory
```bash
cd Library_Management_System/src
```

### Step 2: Compile All Files
```bash
javac model/Book.java service/LibraryService.java util/InputHelper.java Main.java
```

### Step 3: Run the Application
```bash
java Main
```

---

## 📖 Detailed Compilation Guide

### Windows (Command Prompt)
```bash
cd src
javac -d . model/Book.java service/LibraryService.java util/InputHelper.java Main.java
java -cp . Main
```

### Linux/macOS (Terminal)
```bash
cd src
javac model/Book.java service/LibraryService.java util/InputHelper.java Main.java
java Main
```

### Compile with Output Directory
```bash
cd src
javac -d ../bin model/Book.java service/LibraryService.java util/InputHelper.java Main.java
cd ../bin
java Main
```

---

## 🎮 User Interface & Menu

When the application launches, you'll see this menu:

```
==============================================
      LIBRARY MANAGEMENT SYSTEM
==============================================
1. Add a new book
2. View all books
3. Search book by ID
4. Issue book
5. Return book
6. Delete book
7. Exit
==============================================
Enter your choice: _
```

---

## 📚 Feature Walkthrough

### 1️⃣ Add a New Book
```
--- Add New Book ---
Enter book ID: 10
Enter book title: The Pragmatic Coder
Enter author name: Jeff Patton
Book added successfully!
```
- Creates new book with unique ID
- Sets availability status to `true` (Available)
- Prevents duplicate IDs
- Validates all inputs

### 2️⃣ View All Books
```
--- All Books ---
ID: 1 | Title: Java Programming | Author: Herbert Schildt | Status: Available
ID: 2 | Title: Clean Code | Author: Robert C. Martin | Status: Available
ID: 3 | Title: Design Patterns | Author: Gang of Four | Status: Issued
ID: 4 | Title: Effective Java | Author: Joshua Bloch | Status: Available
ID: 5 | Title: The Pragmatic Programmer | Author: David Thomas | Status: Available
```
- Displays all books in library
- Shows current availability status
- Indicates if empty

### 3️⃣ Search Book by ID
```
--- Search Book ---
Enter book ID to search: 2
Book found: ID: 2 | Title: Clean Code | Author: Robert C. Martin | Status: Available
```
- Quickly find book by ID
- Shows complete book details
- Notifies if book doesn't exist

### 4️⃣ Issue a Book
```
--- Issue Book ---
Enter book ID to issue: 2
Book issued successfully!
```
- Marks book as unavailable
- Updates book status
- Only available books can be issued
- Validates book existence

### 5️⃣ Return a Book
```
--- Return Book ---
Enter book ID to return: 3
Book returned successfully!
```
- Marks book as available again
- Only issued books can be returned
- Updates inventory status
- Validates book existence

### 6️⃣ Delete a Book
```
--- Delete Book ---
Enter book ID to delete: 1
Book deleted successfully!
```
- Permanently removes book from library
- Cannot be undone (in-memory operation)
- Validates book existence before deletion

### 7️⃣ Exit
```
Thank you for using Library Management System. Goodbye!
```
- Gracefully terminates the application
- Closes all resources

---

## 🔧 Class Architecture

### Book.java (Model Layer)
**Purpose**: Represents a book entity
**Private Fields**:
- `id` (long): Unique identifier
- `title` (String): Book title
- `author` (String): Author name
- `available` (boolean): Availability flag

**Public Methods**:
- Getters and setters for all fields
- `toString()`: Custom string representation

---

### LibraryService.java (Service Layer)
**Purpose**: Handles all business logic and data operations
**Operations**:
- `addBook(Book)`: Add new book to library
- `getAllBooks()`: Retrieve all books
- `getBookById(long)`: Find book by ID
- `issueBook(long)`: Issue a book
- `returnBook(long)`: Return a book
- `deleteBook(long)`: Delete a book
- `bookExists(long)`: Check if book exists

**Data Storage**: Uses `ArrayList<Book>` for in-memory storage

---

### InputHelper.java (Utility Layer)
**Purpose**: Provides safe user input handling with validation
**Methods**:
- `getString(String)`: Get string input
- `getLong(String)`: Get long integer input with validation
- `getInt(String)`: Get integer input with validation
- `close()`: Close Scanner resource

**Features**:
- Automatic trimming of input
- Exception handling for invalid numbers
- Retry logic for invalid inputs

---

### Main.java (Controller Layer)
**Purpose**: Application entry point and menu orchestration
**Key Methods**:
- `main()`: Application entry point
- `displayMenu()`: Shows menu options
- `addBook()`: Handles add book logic
- `viewAllBooks()`: Displays all books
- `searchBookById()`: Implements search functionality
- `issueBook()`: Handles book issuance
- `returnBook()`: Handles book return
- `deleteBook()`: Implements book deletion
- `loadSampleData()`: Initializes test data

---

## 📊 Sample Data

The application automatically loads 5 sample books on startup:

| ID | Title | Author | Status |
|----|-------|--------|--------|
| 1 | Java Programming | Herbert Schildt | Available |
| 2 | Clean Code | Robert C. Martin | Available |
| 3 | Design Patterns | Gang of Four | Issued |
| 4 | Effective Java | Joshua Bloch | Available |
| 5 | The Pragmatic Programmer | David Thomas | Available |

---

## 💾 Data Storage

- **Type**: In-Memory (ArrayList)
- **Persistence**: Data is lost when application exits
- **Scalability**: Can handle thousands of books
- **Thread-Safe**: Single-threaded console application

---

## 🎓 Learning Outcomes

This project demonstrates:

✅ **Object-Oriented Programming**: Classes, objects, encapsulation  
✅ **Collections Framework**: ArrayList usage and iteration  
✅ **Input/Output**: Scanner for console input, System.out for output  
✅ **Exception Handling**: Try-catch for input validation  
✅ **Code Organization**: Layered architecture (Model, Service, Util)  
✅ **Best Practices**: Following SOLID principles, clean code  
✅ **User Interface**: Menu-driven console application  
✅ **Logic Implementation**: Conditional statements and loops  

---

## 🐛 Error Handling

The application handles various error scenarios:

- **Duplicate IDs**: "Book with ID X already exists"
- **Book Not Found**: "Book with ID X not found"
- **Invalid Operations**: "Book is already issued/available"
- **Invalid Input**: "Invalid input. Please enter a valid number"
- **Empty Library**: "No books in the library"

---

## 📝 Future Enhancements

Possible improvements for extended functionality:

- File-based persistence (save/load from files)
- Search by title or author
- Borrower management
- Due date tracking
- Fine calculation system
- Database integration (MySQL/PostgreSQL)
- GUI using Swing or JavaFX
- Multi-user support

---

## 👨‍💻 Author

Educational Project - Library Management System

---

## 📧 Support

For questions or issues, refer to the inline code documentation or review class descriptions above.

