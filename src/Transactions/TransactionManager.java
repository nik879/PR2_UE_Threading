package Transactions;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionManager {
    private ArrayList<Transaction> transactions;

    public TransactionManager(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "TransactionManager{" + "transactions=" + transactions + '}';
    }

    public HashMap<String,Integer> getTransactionCountByCity() {
        HashMap<String, Integer> TransactionCountByCity = new HashMap<>();
        Integer value=0;
        for (Transaction transaction : transactions) {
            if (TransactionCountByCity.containsKey(transaction.getCity())) {
                TransactionCountByCity.get(transaction.getCity());
                value++;
                TransactionCountByCity.put(transaction.getCity(), value);
            } else {
                TransactionCountByCity.put(transaction.getCity(), 1);
            }
        }
        return TransactionCountByCity;
    }
}
