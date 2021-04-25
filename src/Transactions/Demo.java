package Transactions;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws LoadExcpetion, TransactionObjectException {
        TransactionLoader tl = new TransactionLoader();
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions =
                tl.loadTransactions("C:\\Users\\nikikachelmaier\\Downloads\\transactions - Copy" +
                        ".csv");
        //System.out.println(transactions);

       /* tl.sort(new PriceProductComparator());
        System.out.println("__________\n\n");
        tl.sort(new CityAscendingComparator());
        TransactionObjectHandler fw = new TransactionObjectHandler("C:\\Users\\nikikachelmaier\\Desktop\\transactions_sorted.csv");
        fw.saveTransactions(transactions);
        System.out.println(tl.getTransactions());*/
        /*TransactionManager tm = new TransactionManager(transactions);

        System.out.println(tm.getTransactionCountByCity());
        System.out.println(tm.getCountOfTransaction("Argentina"));
        System.out.println(tm.getPaymentTypes());
        System.out.println(tm.getAverageTransactionAmountByPaymentType());*/

    }
}
