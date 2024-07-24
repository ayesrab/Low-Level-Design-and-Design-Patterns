package PaymentGateway.Transaction;

import com.sun.source.tree.LiteralTree;

import java.util.List;

public class TransationController {
    TransactionService transactionService;

    TransationController(){
        transactionService = new TransactionService();
        transactionService.setProcessor(new Processor());
    }

    Transaction makePayment(Transaction transaction){
        return transactionService.makePayment(transaction);
    }

    List<Transaction> getTransationHistory(int userId){
        return transactionService.getTransationList(userId);
    }
}
