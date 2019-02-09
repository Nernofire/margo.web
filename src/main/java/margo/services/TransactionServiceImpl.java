package margo.services;

import margo.models.Transaction;
import margo.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class TransactionServiceImpl implements OrderService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Iterable<Transaction> getAllTransactions() {
        return this.transactionRepo.findAll();
    }

    @Override
    public Transaction create(Transaction transaction) {
        transaction.setTransaction_date(new Date());
        return this.transactionRepo.save(transaction);
    }

    @Override
    public void update(Transaction transaction) {
        this.transactionRepo.save(transaction);
    }
}
