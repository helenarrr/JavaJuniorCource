package org.example.lesson1_StreamApi.seminar.ProgramLibrary;

import java.util.List;

public class Library_v2 {

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Преступление и наказание", "Достоевский", 1866),
                new Book("Война и мир", "Толстой", 1869),
                new Book("Анна Каренина", "Толстой", 1877),
                new Book("Война и мир", "Толстой", 1869),
                new Book("Война и мир", "Толстой", 1869),
                new Book("Война и мир", "Толстой", 1869)
        );

        books
//                .stream()
//                .filter(book -> "Толстой".equals(book.getAuthor()))
//                .forEach(System.out::println);

//                .stream()
//                .filter(book -> book.getYearOfPublication() > 1866)
//                .forEach(System.out::println);

                .stream()
                .map(Book::getTitle)
                .distinct()
                .forEach(System.out::println);
    }


}
