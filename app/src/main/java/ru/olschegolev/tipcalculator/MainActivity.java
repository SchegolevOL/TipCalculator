package ru.olschegolev.tipcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText textOrder, textDiscount;
    TextView textPercent;
    Button calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        calculation = findViewById(R.id.calculation);
        textOrder = findViewById(R.id.editOrder);
        textDiscount = findViewById(R.id.editDiscount);
        textPercent = findViewById(R.id.percent);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textOrder.getText().toString().isEmpty() && textDiscount.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "fields are not filled in", Toast.LENGTH_LONG).show();
                } else {
                    int res = Integer.valueOf(String.valueOf(textOrder.getText())) / 100 * Integer.valueOf(String.valueOf(textDiscount.getText()));
                    Log.d("message", String.valueOf(res));
                    textPercent.setText(String.valueOf(res));
                }


            }
        });
    }
}