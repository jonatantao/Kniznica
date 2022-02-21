package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    List<Book> books;
    List<User> users;
    List<Borrowings> borrowings;

    public controller(){
        this.books = init();
        this.users = init2();
        this.borrowings = init3();
    }

    public List<Borrowings> init3(){
        List<Borrowings> borrowing = new ArrayList<>();

        Borrowings borrowings1 = new Borrowings();
        borrowings1.setBorrowingId("1");
        borrowing.add(borrowings1);

        return borrowing;
    }

    public List<Book> init() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("Haruki Murakami");
        book1.setTitle("Norwegian Wood");
        book1.setIsbn("0099448823");
        book1.setBookId("1");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("Conan");
        book2.setTitle("Cau");
        book2.setIsbn("456");
        book2.setBookId("2");
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
        users.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setFirstName("Jano");
        user2.setLastName("Odvedľa");
        user2.setEmail("odvedla@gmail.com");
        users.add(user2);
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

    @GetMapping("/api/borrowings")
    public List<Borrowings> getBorrowings(@RequestParam(required = false) String borrowingId){
        if(borrowingId == null){
            return this.borrowings;
        }

        List<Borrowings> filteredBorrowings = new ArrayList<>();

        for (Borrowings borrowings : borrowings){
            if(borrowings.getBorrowingId().equals(borrowingId)){
                filteredBorrowings.add(borrowings);
            }
        }

        return filteredBorrowings;
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

    @PostMapping("api/borrowings")
    public  List<Borrowings> createBorrowing(@RequestBody Borrowings borrowing){
        this.borrowings.add(borrowing);

        return borrowings;
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        this.users.remove(this.users.get(userId));
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        this.borrowings.remove(this.borrowings.get(borrowingId));
    }


    @PutMapping("/api/books/{bookId}") //update by {book}
    public List<Book> putBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setId(book.getId());
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setIsbn(book.getIsbn());
        return books;
    }

    @PutMapping("/api/users/{userId}")
    public List<User> putUser(@PathVariable Integer userId, @RequestBody User user){
        this.users.get(userId).setId(user.getId());
        this.users.get(userId).setFirstName(user.getFirstName());
        this.users.get(userId).setLastName(user.getLastName());
        this.users.get(userId).setEmail(user.getEmail());
        return users;
    }
}
