package com.example.testmybasecode.service.authentication;


import com.example.testmybasecode.service.model.LoginRequest;
import com.example.testmybasecode.service.model.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface RestAuthenticationService {

    @POST("auth/signIn")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);
}
