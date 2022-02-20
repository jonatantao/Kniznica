package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    List<Book> books;
    List<User> users;

    public controller(){
        this.books = init();
        this.users = init2();
    }

    public List<Book> init() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("Haruki Murakami");
        book1.setTitle("Norwegian Wood");
        book1.setIsbn("0099448823");
        book1.setId("1");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("Conan");
        book2.setTitle("Cau");
        book2.setIsbn("456");
        book2.setId("2");
        books.add(book2);

        return books;
    }

    public List<User> init2(){ //init2 list of users
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId("1");
        user1.setFirstName("Jožo");
        user1.setLastName("Alvaréz");
        user1.setEmail("j.alvarez@gmail.com");

        User user2 = new User();
        user2.setId("2");
        user2.setFirstName("Jano");
        user2.setLastName("Odvedľa");
        user2.setEmail("odvedla@gmail.com");

        return users;
    }

    @GetMapping("/api/users") //filtered users with user last name
    public List<User> getUsers(@RequestParam(required = false) String userlastName){
        if (userlastName == null){
            return this.users;
        }

        List<User> filteredUsers = new ArrayList<>();

        for (User user : users){
            if (user.getLastName().equals(userlastName)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @GetMapping("/api/userid") //filtered users with user last name
    public List<User> getUsersId(@RequestParam(required = false) String userId){
        if (userId == null){
            return this.users;
        }

        List<User> filteredUsers = new ArrayList<>();

        for (User user : users){
            if (user.getId().equals(userId)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        if (bookAuthor == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @GetMapping("/api/book/{bookId}") //search by {bookId}
    public Book getBook(@PathVariable Integer bookId){
        return this.books.get(bookId);
    }

    @GetMapping("/api/id") //search by bookId
    public List<Book> getBookId(@RequestParam(required = false) String bookId){
        if (bookId == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getId().equals(bookId)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @GetMapping("/api/isbn") //search by bookIsbn
    public List<Book> getBookIsbn(@RequestParam(required = false) String bookIsbn){
        if (bookIsbn == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getIsbn().equals(bookIsbn)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @PostMapping("/api/books") //create new book
    public List<Book> createBook(@RequestBody Book book){
        this.books.add(book);
        return books;
    }

    @PostMapping("/api/users") //creating new user
    public List<User> createUser(@RequestBody User user){
        this.users.add(user);

        return users;
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    @PutMapping("/api/books/{bookId}") //update by {book}
    public List<Book> putBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setId(book.getId());
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setIsbn(book.getIsbn());
        return books;
    }
}
