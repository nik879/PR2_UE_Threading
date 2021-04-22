package Transactions;

import java.util.Comparator;

public class PriceProductComparator implements Comparator<Transaction> {


    @Override
    public int compare(Transaction o1, Transaction o2) {

        int cmp = Double.compare(o1.getPrice(), o2.getPrice());
        if (o1.getPrice() == o2.getPrice()) {
            cmp = o2.getProduct().compareTo(o1.getProduct());
        }
        return cmp;

    }
}
