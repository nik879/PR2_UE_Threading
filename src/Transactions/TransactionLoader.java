package Transactions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TransactionLoader {
    ArrayList<Transaction> transactions = new ArrayList<>();

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Transaction> loadTransactions(String path) throws LoadExcpetion {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                Transaction ta = new Transaction(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4],
                        parts[5], parts[6], parts[7]);
                transactions.add(ta);
            }

            return transactions;

        } catch (FileNotFoundException e) {
            throw new LoadExcpetion(e);
        } catch (IOException e) {
            throw new LoadExcpetion(e);
        }
    }

    public void sort(Comparator Comparator) {
        Collections.sort(transactions,Comparator);
    }
}
