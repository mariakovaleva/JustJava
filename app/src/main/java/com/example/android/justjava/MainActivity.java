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

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    String creamStatus;
    String chocoStatus;
    int pricePerCup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
     * Alternative solution to adding a Whipped Cream checkbox
     * Checks if the Whipped cream box is selected and summons OrderSummary when clicking order button

     public void whippedCreamChecked(View view){
     boolean creamOrdered = ((CheckBox) view).isChecked();
     switch (view.getId())
     {
     case R.id.checkbox:
     if (creamOrdered) creamStatus = "ordered";
     else creamStatus = "none";
     break;

     }

     displayMessage(createOrderSummary());
     }
     */

    /**
     * Calculates the price of the order.
     *
     * @param quantity    is the number of cups of coffee ordered
     * @param pricePerCup is the price of the cup of coffee
     */
    private int calculatePrice(int quantity, int pricePerCup) {
        return quantity * pricePerCup;
    }

    /**
     * This method is called when the order button is clicked
     */

    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if (hasWhippedCream == true) {

            creamStatus = "Yes";
        } else {

            creamStatus = "No";

        }
        Log.i("MainActivity", "User chose whipped cream: " + hasWhippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.choco_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        if (hasChocolate == true) {

            chocoStatus = "Yes";
        } else {

            chocoStatus = "No";

        }
        Log.i("MainActivity", "User chose chocolate: " + hasChocolate);

        int price = calculatePrice(quantity, pricePerCup);

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);

    }

    /**
     * Creates the summary of the order.
     *
     * @param price        of the order
     * @param whippedCream is whether the user wants whipped cream topping
     *                     @param chocolate is whether the user wants chocolate topping
     * @return text summary
     */
    private String createOrderSummary(int price, boolean whippedCream, boolean chocolate) {
        //how to get calculatePrice's value directly?
        String orderSummaryMessage = "Name: Maria Kovaleva";
        orderSummaryMessage += "\nQuantity: " + quantity;
        orderSummaryMessage += "\nTotal: $" + calculatePrice(quantity, 5);
        orderSummaryMessage += "\nThank you!";
        orderSummaryMessage += "\nAdd whipped cream? " + creamStatus;
        orderSummaryMessage += "\nAdd chocolate? " + chocoStatus;
        return orderSummaryMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.

     private void displayPrice(int number) {
     TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
     priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }
     */
}


