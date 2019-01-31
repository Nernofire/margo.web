package margo.controllers.api;

import margo.models.Transaction;
import margo.services.TransactionDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/transactions")
public class TransactionController {
    @Autowired
    TransactionDAOImpl transactionDAO;

    @GetMapping("/getAll")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionDAO.getALl(), HttpStatus.OK);
    }

    @PostMapping("/postTransaction")
    public ResponseEntity<List<Transaction>> createTransaction(@Valid @RequestBody Transaction transaction) {
        transactionDAO.createTransaction(transaction);
        return new ResponseEntity<>(transactionDAO.getALl(), HttpStatus.OK);
    }

}
