package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingsService {

    private List<Borrowings> borrowings;

    private BorrowingsService borrowingsService;

    public BorrowingsService(){
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
    public List<Borrowings> getBorrowings(String borrowingId){
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
    public  List<Borrowings> createBorrowing(Borrowings borrowing){
        this.borrowings.add(borrowing);

        return borrowings;
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(Integer borrowingId){
        this.borrowings.remove(this.borrowings.get(borrowingId));
    }
}
