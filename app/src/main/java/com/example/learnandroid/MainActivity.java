package com.example.learnandroid;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        final Button btnAdd = findViewById(R.id.btmAdd);
        btnAdd.setEnabled(false);

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                btnAdd.setEnabled(!text.isEmpty());
            }
        });
        Spannable point = new SpannableString("•");
        point.setSpan(new StyleSpan(Typeface.BOLD), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        point.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView textView = (TextView) findViewById(R.id.tvPriority);
        textView.setText(point);

    }
}
