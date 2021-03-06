package com.example.testmybasecode.domain.login;


import com.example.testmybasecode.service.authentication.RestAuthenticationService;
import com.example.testmybasecode.service.model.LoginRequest;
import com.example.testmybasecode.service.model.LoginResponse;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginPresenter extends MvpBasePresenter<LoginView> {

    @Inject
    protected RestAuthenticationService restAuthenticationService;

    @Inject
    public LoginPresenter() {

    }

    public void login(String email, String password) {
        getView().showLoading();
        restAuthenticationService.login(new LoginRequest(email, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getView().hideLoading();
                    }
                })
                .subscribe(new Action1<LoginResponse>() {
                    @Override
                    public void call(LoginResponse loginResponse) {
                        getView().loginSuccessful(loginResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().loginFailed(throwable);
                    }
                });

    }
}
