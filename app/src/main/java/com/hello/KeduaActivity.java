package com.hello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KeduaActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.hello.extra.REPLY";
    Button button_second;
    private EditText mReply;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        mReply = findViewById(R.id.editText_second);


        Intent intent = getIntent();
        String message = intent.getStringExtra(pertamaActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        button_second = findViewById(R.id.button_second);
        button_second.setOnClickListener(v -> {
            Intent intent1 = new Intent(
                    KeduaActivity.this, pertamaActivity.class
            );
            startActivity(intent1);
        });


    }

    @Override
    public void onBackPressed() {
        Intent replyIntent = new Intent();
        String reply = mReply.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        super.onBackPressed();
    }
}