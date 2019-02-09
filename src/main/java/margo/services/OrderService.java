package margo.services;

import margo.models.Transaction;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {
    @NotNull Iterable<Transaction> getAllTransactions();

    Transaction create(@NotNull(message = "The order cannot be null.") @Valid Transaction transaction);

    void update(@NotNull(message = "The order cannot be null.") @Valid Transaction transaction);
}
