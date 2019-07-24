package com.example.testmybasecode;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @Click(R.id.tv_test)
    protected void onClickTest() {
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }
}

