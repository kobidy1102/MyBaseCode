package com.example.testmybasecode.domain.login;


import com.example.testmybasecode.service.model.LoginResponse;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface LoginView extends MvpView {

    void showLoading();

    void hideLoading();

    void loginSuccessful(LoginResponse loginResponse);

    void loginFailed(Throwable throwable);
}
