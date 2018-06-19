/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

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

        if (quantity > 100) {
            quantity = 100;
            Toast noCoffeeBulk = Toast.makeText(getApplicationContext(), "No more than 100 cups allowed", Toast.LENGTH_SHORT);
            noCoffeeBulk.show();
        }

        display(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;

        if (quantity < 1) {
            quantity = 1;
            Toast noNegative = Toast.makeText(getApplicationContext(), "No less than 1 cup allowed", Toast.LENGTH_SHORT);
            noNegative.show();
        }

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


    /**
     * Calculates the price of the order
     */
    private int calculatePrice (boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream){
            basePrice += 1;
        }

        if (addChocolate) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view) {

        String creamStatus;
        String chocoStatus;

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if (hasWhippedCream) {

            creamStatus = "Yes";

        } else {

            creamStatus = "No";

        }
        Log.i("MainActivity", "User chose whipped cream: " + hasWhippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.choco_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        if (hasChocolate) {

            chocoStatus = "Yes";

        } else {

            chocoStatus = "No";

        }
        Log.i("MainActivity", "User chose chocolate: " + hasChocolate);

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        EditText nameInput = (EditText) findViewById(R.id.name_input);
        String nameOfUser = nameInput.getText().toString();

        String priceMessage = createOrderSummary(price, creamStatus, chocoStatus, nameOfUser);

        //an intent to open email app with order summary already in text
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + nameOfUser);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    /**
     * Creates the summary of the order.
     *
     * @param price        of the order
     * @param whippedCream is whether the user wants whipped cream topping
     *                     @param chocolate is whether the user wants chocolate topping
     * @return text summary
     */
    private String createOrderSummary(int price, String whippedCream, String chocolate, String userName) {
        //how to get calculatePrice's value directly?
        String orderSummaryMessage = "Name: "+ userName;
        orderSummaryMessage += "\nQuantity: " + quantity;
        orderSummaryMessage += "\nAdd whipped cream? " + whippedCream;
        orderSummaryMessage += "\nAdd chocolate? " + chocolate;
        orderSummaryMessage += "\nTotal: $" + price;
        orderSummaryMessage += "\nThank you!";
        return orderSummaryMessage;
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


