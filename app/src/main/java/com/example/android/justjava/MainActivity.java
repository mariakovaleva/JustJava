/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;
<<<<<<< HEAD
    String creamStatus;
=======
    Context context;

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        int price = quantity*5;
        Log.v("MainActivity", "The price is: "+price);

        String priceMessage = "Name: Lyla the Labyrinth";
        priceMessage += "\nQuantity: "+ quantity;
        priceMessage += "\nTotal: $"+price;
        priceMessage += "\nWhipped Cream: "+creamStatus;
        priceMessage += "\nThank you!";
        displayMessage(priceMessage);
}

    public void whippedCreamChecked(View view){
        boolean creamOrdered = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.checkbox:
                if (creamOrdered) creamStatus = "ordered";
                else creamStatus = "none";
                        break;

        }

    /**
     * Calculates the price of the order.
     *  @param quantity is the number of cups of coffee ordered
     * @param pricePerCup is the price of the cup of coffee
     * */

    /**
     * Creates the summary of the order.
     */
>>>>>>> 14e26106598eb87ffd6e953db7f36772682b7522
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int money) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + money);
            }

    /**
     * This method displays the given price on the screen.

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
     */
}


