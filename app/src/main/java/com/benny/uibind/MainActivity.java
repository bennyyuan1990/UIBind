package com.benny.uibind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.benny.viewbind.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_tv)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
