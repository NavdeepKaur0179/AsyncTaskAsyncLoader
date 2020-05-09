package com.app.aynctaskdemo.simpleasync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.aynctaskdemo.R;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE,
                mTextView.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView1);
        // Restore TextView if there is a savedInstanceState
        if(savedInstanceState!=null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);
        new SimpleAsyncTask(mTextView).execute();
    }
}