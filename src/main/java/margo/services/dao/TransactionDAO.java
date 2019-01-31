package margo.services.dao;

import margo.models.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getALl();

    Transaction createTransaction(Transaction transaction);
}
