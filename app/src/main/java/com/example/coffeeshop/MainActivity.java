package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;




public class MainActivity extends AppCompatActivity {
    private TextView numberOfCoffee;
    private TextView bill;
    private Button minus;
    private Button plus;
    public String num;
    public int toNum;
    public int price = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfCoffee = findViewById(R.id.numberOfCoffee);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        bill = findViewById(R.id.bill);
    }

    public void btnMinus(View view) {
        num = String.valueOf(numberOfCoffee.getText());
        toNum = Integer.parseInt(num);
        if (toNum > 0) {
            toNum = toNum - 1;
            String toText = String.valueOf(toNum);
            numberOfCoffee.setText(toText);
            bill.setText("Your Order is :\n" + numberOfCoffee.getText() + "cups of coffee \nTotal cost = " + (toNum * price));
            Toast.makeText(getApplicationContext(), numberOfCoffee.getText() + " Cups" + "\ntotal price=" + (toNum * price), Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(getApplicationContext(), "Can not order less than zero coffees ", Toast.LENGTH_LONG).show();

    }

    public void btnPlus(View view) {
        if (toNum < 20) {

            num = String.valueOf(numberOfCoffee.getText());
            toNum = Integer.parseInt(num);
            toNum = toNum + 1;
            String toText = String.valueOf(toNum);
            numberOfCoffee.setText(toText);
            bill.setText("Your Order is :\n" + numberOfCoffee.getText() + "cups of coffee \nTotal cost = " + (toNum * price));
            Toast.makeText(getApplicationContext(), numberOfCoffee.getText() + " Cups" + "\ntotal price=" + (toNum * price), Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(getApplicationContext(), "Can not order more than twenty cups ", Toast.LENGTH_LONG).show();
    }
    public void btnOrder(View view) {
        int totalCups = toNum * price;
        int totalPrice = totalCups;

        StringBuilder orderText = new StringBuilder("Your Order is:\n");
        orderText.append(numberOfCoffee.getText()).append(" cups of coffee\t").append(totalCups).append("\n");

        CheckBox mandaziCheckbox = findViewById(R.id.mandaziCheckbox);
        if (mandaziCheckbox.isChecked()) {
            totalPrice += 100;
            orderText.append("Mandazi\t").append("100\n");
        }

        CheckBox kaimatiCheckbox = findViewById(R.id.kaimatiCheckbox);
        if (kaimatiCheckbox.isChecked()) {
            totalPrice += 250;
            orderText.append("Kaimati\t").append("250\n");
        }

        CheckBox chapatiCheckbox = findViewById(R.id.chapatiCheckbox);
        if (chapatiCheckbox.isChecked()) {
            totalPrice += 150;
            orderText.append("Chapati\t").append("150\n");
        }

        CheckBox ngumuCheckbox = findViewById(R.id.ngumuCheckbox);
        if (ngumuCheckbox.isChecked()) {
            totalPrice += 200;
            orderText.append("Ngumu\t").append("200\n");
        }

        CheckBox scornsCheckbox = findViewById(R.id.scornsCheckbox);
        if (scornsCheckbox.isChecked()) {
            totalPrice += 200;
            orderText.append("Scorns\t").append("200\n");
        }

        orderText.append("Total Price:\t").append(totalPrice);

        bill.setText(orderText.toString());

        // Display a success message
        Toast.makeText(getApplicationContext(), "Order Successful", Toast.LENGTH_LONG).show();

        // Display serving and welcome messages
        TextView servingTextView = findViewById(R.id.servingTextView);
        String servingMessage = "You were served by:\nMaxwell";
        servingTextView.setText(servingMessage);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        String welcomeMessage = "Welcome to Macgyver's Cafe\n###Extraordinary everyday###";
        welcomeTextView.setText(welcomeMessage);


        mandaziCheckbox.setChecked(false);
        kaimatiCheckbox.setChecked(false);
        chapatiCheckbox.setChecked(false);
        ngumuCheckbox.setChecked(false);

        scornsCheckbox.setChecked(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Order")
                .setMessage("Would you like to make a new order?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Reset to default values
                        numberOfCoffee.setText("0");
                        toNum = 0;
                        bill.setText("");
                    }
                })
                .setNegativeButton("No", null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        Toast.makeText(getApplicationContext(), "Order Successful", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }


}

