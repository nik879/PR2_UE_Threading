package Transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                value=TransactionCountByCity.get(transaction.getCity());
                TransactionCountByCity.put(transaction.getCity(), value+1);
            } else {
                TransactionCountByCity.put(transaction.getCity(), 1);
            }
        }
        return TransactionCountByCity;
    }

    public Integer getCountOfTransaction(String country) {
        Integer CountryCount=0;
        for (Transaction transaction : transactions) {
            if (transaction.getCountry().equals(country)) {
                CountryCount++;
            }
        }
        return CountryCount;
    }

    public ArrayList<Transaction> getTransactionsToProduct(String product) {
        ArrayList<Transaction> transactionsOfProducts = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getProduct().equals(product)) {
                transactionsOfProducts.add(transaction);
            }
        }
        return transactionsOfProducts;
    }

    public HashMap<String, Double> getAverageTransactionAmountByPaymentType() {
        HashMap<String, Double> avgAmountPaymentType = new HashMap<>();
        HashMap<String, Integer> countPerPaymentType = getPaymentTypes();


        for (Map.Entry<String, Integer> stringIntegerEntry : countPerPaymentType.entrySet()) {
            double amount = 0;
            for (Transaction transaction : transactions) {
                if (transaction.getPaymentType().equals(stringIntegerEntry.getKey())) {
                    amount += transaction.getPrice();
                }
            }
            avgAmountPaymentType.put(stringIntegerEntry.getKey(),
                    amount / stringIntegerEntry.getValue());

        }
        return avgAmountPaymentType;
    }

    public HashMap<String,Integer> getPaymentTypes() {
        Integer value=0;
        HashMap<String,Integer> paymentTypes = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (paymentTypes.containsKey(transaction.getPaymentType())) {
                value=paymentTypes.get(transaction.getPaymentType());
                paymentTypes.put(transaction.getPaymentType(), value + 1);
            } else paymentTypes.put(transaction.getPaymentType(), 1);
        }
        return paymentTypes;
    }
}
