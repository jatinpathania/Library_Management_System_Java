import model.Book;
import service.LibraryService;
import util.InputHelper;
import java.util.ArrayList;

public class Main {

    private static LibraryService libraryService;
    private static InputHelper inputHelper;

    public static void main(String[] args) {
        libraryService = new LibraryService();
        inputHelper = new InputHelper();

        loadSampleData();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = inputHelper.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBookById();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        inputHelper.close();
    }

    private static void displayMenu() {
        System.out.println("==============================================");
        System.out.println("      LIBRARY MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Add a new book");
        System.out.println("2. View all books");
        System.out.println("3. Search book by ID");
        System.out.println("4. Issue book");
        System.out.println("5. Return book");
        System.out.println("6. Delete book");
        System.out.println("7. Exit");
        System.out.println("==============================================");
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        long id = inputHelper.getLong("Enter book ID: ");

        if (libraryService.bookExists(id)) {
            System.out.println("Book with ID " + id + " already exists.");
            return;
        }

        String title = inputHelper.getString("Enter book title: ");
        String author = inputHelper.getString("Enter author name: ");

        Book book = new Book(id, title, author, true);
        libraryService.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void viewAllBooks() {
        System.out.println("\n--- All Books ---");
        ArrayList<Book> books = libraryService.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void searchBookById() {
        System.out.println("\n--- Search Book ---");
        long id = inputHelper.getLong("Enter book ID to search: ");

        Book book = libraryService.getBookById(id);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private static void issueBook() {
        System.out.println("\n--- Issue Book ---");
        long id = inputHelper.getLong("Enter book ID to issue: ");

        if (libraryService.issueBook(id)) {
            System.out.println("Book issued successfully!");
        } else {
            Book book = libraryService.getBookById(id);
            if (book == null) {
                System.out.println("Book with ID " + id + " not found.");
            } else {
                System.out.println("Book is already issued.");
            }
        }
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        long id = inputHelper.getLong("Enter book ID to return: ");

        if (libraryService.returnBook(id)) {
            System.out.println("Book returned successfully!");
        } else {
            Book book = libraryService.getBookById(id);
            if (book == null) {
                System.out.println("Book with ID " + id + " not found.");
            } else {
                System.out.println("Book is already available.");
            }
        }
    }

    private static void deleteBook() {
        System.out.println("\n--- Delete Book ---");
        long id = inputHelper.getLong("Enter book ID to delete: ");

        if (libraryService.deleteBook(id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private static void loadSampleData() {
        libraryService.addBook(new Book(1, "Java Programming", "Herbert Schildt", true));
        libraryService.addBook(new Book(2, "Clean Code", "Robert C. Martin", true));
        libraryService.addBook(new Book(3, "Design Patterns", "Gang of Four", false));
        libraryService.addBook(new Book(4, "Effective Java", "Joshua Bloch", true));
        libraryService.addBook(new Book(5, "The Pragmatic Programmer", "David Thomas", true));
    }

}
