package PaymentGateway.Transaction;

import PaymentGateway.Instrument.InstrumentServiceController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    static Map<Integer, List<Transaction>> userVsTransation = new HashMap<>();
    Processor processor;
    InstrumentServiceController instrumentServiceController;

    public static Map<Integer, List<Transaction>> getUserVsTransation() {
        return userVsTransation;
    }

    public static void setUserVsTransation(Map<Integer, List<Transaction>> userVsTransation) {
        TransactionService.userVsTransation = userVsTransation;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public InstrumentServiceController getInstrumentServiceController() {
        return instrumentServiceController;
    }

    public void setInstrumentServiceController(InstrumentServiceController instrumentServiceController) {
        this.instrumentServiceController = instrumentServiceController;
    }

    Transaction makePayment(Transaction transaction){
        List<Transaction> sendersList = userVsTransation.getOrDefault(transaction.getSenderId(), new ArrayList<>());
        List<Transaction> receiversList = userVsTransation.getOrDefault(transaction.getReceiverId(),new ArrayList<>());
        sendersList.add(transaction);
        receiversList.add(transaction);
        userVsTransation.put(transaction.getSenderId(),sendersList);
        userVsTransation.put(transaction.getReceiverId(),receiversList);
        processor.processPayment(transaction);
        return transaction;
    }

    List<Transaction> getTransationList(int userId){
        return userVsTransation.getOrDefault(userId,new ArrayList<>());
    }
}
