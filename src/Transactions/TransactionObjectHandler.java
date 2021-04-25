package Transactions;

import Transactions.Transaction;

import java.io.*;
import java.util.ArrayList;

public class TransactionObjectHandler {
    private String writePath;

    public TransactionObjectHandler(String writePath) {
        this.writePath = writePath;

    }

    /*public void saveTransactions(ArrayList<Transaction> transactions) throws
    TransactionObjectException {

        //ohne Objektoutputstream - habs in der Angabe überlesen

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writePath))) {
            for (Transaction transaction : transactions) {
                bw.write(transaction.getTransactionDate() + ";"
                        + transaction.getProduct() + ";" +
                        transaction.getPrice() + ";" + transaction.getPaymentType()
                        + ";" + transaction.getName() + ";" + transaction.getCity() +
                        ";" + transaction.getState() + ";" + transaction.getCountry());

                bw.newLine();
            }
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            throw new TransactionObjectException(e);
        }
    }*/

    public void saveTransactions(ArrayList<Transaction> transactions) throws TransactionObjectException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(writePath));
             BufferedOutputStream bs = new BufferedOutputStream(os)) {
            for (Transaction transaction : transactions) {
                os.writeObject(transaction);
            }
            os.writeObject(null);
            os.flush();
        } catch (FileNotFoundException e) {
            throw new TransactionObjectException(e);
        } catch (IOException e) {
            throw new TransactionObjectException(e);
        }
    }


}
