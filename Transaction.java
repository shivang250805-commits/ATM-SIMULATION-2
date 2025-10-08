package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private String date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
