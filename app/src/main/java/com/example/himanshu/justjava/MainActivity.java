package com.example.himanshu.justjava;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.himanshu.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int quantity = 0;

    public void submitOrder(View view) {

        EditText name = (EditText) findViewById(R.id.nameField);
        String nameValue = name.getText().toString();

        CheckBox cream = (CheckBox) findViewById(R.id.creamCheckbox);
        Boolean wantCream = cream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolateCheckbox);
        Boolean wantChocolate = chocolate.isChecked();

        int price = calculatePrice(wantCream,wantChocolate);

        String finalOrder = createOrderSummary(nameValue,price,wantCream,wantChocolate);
        displayMessage(finalOrder);
    }


    private String createOrderSummary(String name,int price,boolean wantCream,boolean wantChocolate){
        String wantedCream;
        String wantedChocolate;

        if(wantCream){
            wantedCream = "YES";
        }else {
            wantedCream = "NO";
        }

        if(wantChocolate){
            wantedChocolate = "YES";
        }else {
            wantedChocolate = "NO";
        }
        String finalOrder = "BILL GENERATED";
        finalOrder += "\nName : "+name;
        finalOrder += "\nQuantity : "+quantity;
        finalOrder += "\nWant Whipped Cream "+wantedCream;
        finalOrder += "\nWant Chocolate "+wantedChocolate;
        finalOrder += "\nTotal : $ "+price;
        finalOrder += "\nThank You...";

        return finalOrder;
    }

    private int calculatePrice(boolean wantCream,boolean wantChocolate){
        int price = quantity * 5;
        if(wantCream){
            price += 1;
        }

        if(wantChocolate){
            price += 2;
        }
        return price;
    }

    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement(View view) {

        quantity = quantity - 1;
        display(quantity);
     }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}