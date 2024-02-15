package org.example.lesson1_StreamApi.seminar.ProgramLibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("Преступление и наказание", "Достоевский", 1866));
        books.add(new Book("Война и мир", "Толстой", 1869));
        books.add(new Book("Анна Каренина", "Толстой", 1877));

        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if ("Толстой".equals(book.getAuthor())) {
                authorBooks.add(book);
            }
        }
        System.out.println("Книги Льва Толстого " + authorBooks);

        List<Book> booksAfter1866 = new ArrayList<>();
        for (Book book : books) {
            if (book.getYearOfPublication() > 1866) {
                booksAfter1866.add(book);
            }
        }

        System.out.println("Книги, опубликованные после 1866 года - " + booksAfter1866);


        List<String> uniqueTitle = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitle.contains(book.getTitle())) {
                uniqueTitle.add(book.getTitle());
            }
        }
        System.out.println("Уникальные названия книг - " + uniqueTitle);
    }
}

