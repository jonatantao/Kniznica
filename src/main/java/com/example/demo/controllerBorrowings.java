package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controllerBorrowings {
    List<Borrowings> borrowings;

    public controllerBorrowings(){
        this.borrowings = init3();
    }

    public List<Borrowings> init3(){
        List<Borrowings> borrowing = new ArrayList<>();

        Borrowings borrowings1 = new Borrowings();
        borrowings1.setBorrowingId("1");
        borrowing.add(borrowings1);

        return borrowing;
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

    @PostMapping("api/borrowings")
    public  List<Borrowings> createBorrowing(@RequestBody Borrowings borrowing){
        this.borrowings.add(borrowing);

        return borrowings;
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        this.borrowings.remove(this.borrowings.get(borrowingId));
    }
}
