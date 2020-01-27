package com.example.testmybasecode.domain.main;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.example.testmybasecode.R;
import com.example.testmybasecode.domain.login.LoginActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @Click(R.id.tv_test)
    protected void onClickTest() {
        LoginActivity_.intent(this).start();
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }
}
