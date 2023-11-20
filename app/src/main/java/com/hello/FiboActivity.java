package com.hello;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FiboActivity extends AppCompatActivity {
    private TextView showCount;
    private int count = 1;
    private long fibNMinus1 = 1;
    private long fibNMinus2 = 1;
    private int limit = -1; // Inisialisasi limit dengan nilai default

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibo);

        showCount = findViewById(R.id.show_count);
    }

    public void countUp(View view) {
        if (count == 0) {
            showCount.setText("0");
        } else if (count == 1) {
            showCount.setText("1");
        } else {
            if (limit != -1 && count > limit) {
                // Jika count melebihi limit, atur ulang perhitungan
                count = 0;
                fibNMinus1 = 1;
                fibNMinus2 = 0;
                showCount.setText(getString(R.string.count_initial_value));
            } else {
                long fibCurrent = fibNMinus1 + fibNMinus2;
                fibNMinus2 = fibNMinus1;
                fibNMinus1 = fibCurrent;

                // Mengubah warna teks menjadi warna RGB dengan warna yang berbeda setiap kali angka berubah
                int red = (int) (Math.random() * 256);
                int green = (int) (Math.random() * 256);
                int blue = (int) (Math.random() * 256);
                showCount.setTextColor(Color.rgb(red, green, blue));

                showCount.setText(String.valueOf(fibCurrent));
            }
        }

        count++;
    }

    public void Back(View view) {
        count = 1;
        fibNMinus1 = 1;
        fibNMinus2 = 0;
        showCount.setText(getString(R.string.count_initial_value));
    }

    public void setLimit(View view) {
        // Create and display a dialog to set the limit
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Limit");

        final EditText input = new EditText(this);
        input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            // Get the limit from the input and set it for calculations
            String limitStr = input.getText().toString();
            limit = Integer.parseInt(limitStr);
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());


        builder.show();
    }
}