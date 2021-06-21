package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        Intent intent = getIntent();

        int numPeople = Integer.parseInt(intent.getStringExtra("numPeople"));
        double totalPrice = Double.parseDouble(intent.getStringExtra("totalPrice"));
        double tipAmount = Double.parseDouble(intent.getStringExtra("tipAmount"));

        double tipPerPerson = getTipPerPerson(numPeople,totalPrice,tipAmount);
        TextView tipResult = findViewById(R.id.tip_result);
        tipResult.setText(getString(
                R.string.tip_result,tipPerPerson
        ));

        TextView priceResult = findViewById(R.id.total_price);
        priceResult.setText(getString(
                R.string.total_price,
                calculateBillResult(tipPerPerson,totalPrice,numPeople)

        ));
    }

    public double getTipPerPerson(int numPeople,double totalPrice,double tipAmount){
        return (totalPrice*(tipAmount/100))/numPeople;
    }

    public double calculateBillResult(double tipPerPerson,double totalPrice,int numPeople){
        return (tipPerPerson*numPeople)+totalPrice;
    }
}