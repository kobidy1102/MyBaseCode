package com.example.testmybasecode.domain.login;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.testmybasecode.R;
import com.example.testmybasecode.factory.DaggerApplicationComponent;
import com.example.testmybasecode.service.model.LoginResponse;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

@EActivity(R.layout.activity_login)
public class LoginActivity extends MvpActivity<LoginView, LoginPresenter>
implements LoginView {

    @Inject
    protected LoginPresenter presenter;

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return presenter;
    }

    @AfterInject
    protected void afterInject() {
        DaggerApplicationComponent.builder()
                .build()
                .inject(this);
    }


    @AfterViews
    protected void initView() {

    }

   @Click(R.id.tv_test)
   protected void clickLogin() {
        presenter.login("phong@gmail.com", "123456");
   }

    @Override
    public void showLoading() {
     //   Toast.makeText(this, "Show loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
       // Toast.makeText(this, "Hide loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful(LoginResponse loginResponse) {
        Toast.makeText(this, "Login Successful: "
                + loginResponse.getUser().getAccessToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(Throwable throwable) {
         Toast.makeText(this, "Login failed "+throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
