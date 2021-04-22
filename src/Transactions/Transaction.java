package Transactions;

public class Transaction {
    private String TransactionDate;
    private String Product;
    private double Price;
    private String PaymentType;
    private String Name;
    private String City;
    private String State;
    private String Country;

    public Transaction(String transactionDate, String product, double price, String paymentType, String name,
                       String city, String state, String country) {
        TransactionDate = transactionDate;
        Product = product;
        Price = price;
        PaymentType = paymentType;
        Name = name;
        City = city;
        State = state;
        Country = country;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public String getProduct() {
        return Product;
    }

    public double getPrice() {
        return Price;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public String getName() {
        return Name;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getCountry() {
        return Country;
    }

    @Override
    public String toString() {
        return "Transaction{" + "TransactionDate='" + TransactionDate + '\'' + ", Product='" + Product + '\'' + ", " +
                "Price=" + Price + ", PaymentType='" + PaymentType + '\'' + ", Name='" + Name + '\'' + ", City='" + City + '\'' + ", State='" + State + '\'' + ", Country='" + Country + '\'' + '}';
    }
}
