package com.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    private Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnMove = findViewById(R.id.button_move_count);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home.this, FiboActivity.class);
                startActivity(i);
            }
        });

        Button buttonMovehallo = findViewById(R.id.button_move_hallo);
        buttonMovehallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMoveToScroll = findViewById(R.id.button_move_to_other_scroll);
        buttonMoveToScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, scrollActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMoveToOtherActivity = findViewById(R.id.buttonMoveToOtherActivity);
        buttonMoveToOtherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, KeduaActivity.class);
                startActivity(intent);
            }
        });

        Button buttonMoveToalarm = findViewById(R.id.button_move_to_alarm);
        buttonMoveToalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, SetAlarm.class);
                startActivity(intent);
            }
        });
    }
}