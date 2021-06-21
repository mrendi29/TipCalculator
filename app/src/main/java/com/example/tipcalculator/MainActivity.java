package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnCalculate = findViewById(R.id.calculate);
        EditText totalPrice = findViewById(R.id.total_price);
        EditText tipAmount = findViewById(R.id.tip_amount);
        EditText numPeople = findViewById(R.id.num_people);

        btnCalculate.setOnClickListener(view -> {
            if (!validateFields(
                    totalPrice.getText().toString(),
                    tipAmount.getText().toString(),
                    numPeople.getText().toString())) {
                Toast.makeText(getBaseContext(), "Please fill all values", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MyApp", "Validation passed");
                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.putExtra("totalPrice", totalPrice.getText().toString());
                intent.putExtra("tipAmount", tipAmount.getText().toString());
                intent.putExtra("numPeople", numPeople.getText().toString());
                startActivity(intent);
            }
        });

    }

    private boolean validateFields(String totalPrice, String tipAmount, String numPeople) {
        return (totalPrice != null && tipAmount != null && numPeople != null) &&
                (!totalPrice.isEmpty() && !tipAmount.isEmpty() && !numPeople.isEmpty());
    }
}