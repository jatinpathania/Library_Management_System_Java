package service;

import model.Book;
import java.util.ArrayList;

public class LibraryService {

    private ArrayList<Book> books;

    public LibraryService() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean issueBook(long id) {
        Book book = getBookById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(long id) {
        Book book = getBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public boolean deleteBook(long id) {
        Book book = getBookById(id);
        if (book != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public boolean bookExists(long id) {
        return getBookById(id) != null;
    }

}
