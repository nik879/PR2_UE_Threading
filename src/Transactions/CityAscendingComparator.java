package Transactions;

import java.util.Comparator;

public class CityAscendingComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        int cmp = o1.getCity().compareTo(o2.getCity());
        return cmp;    }
}
